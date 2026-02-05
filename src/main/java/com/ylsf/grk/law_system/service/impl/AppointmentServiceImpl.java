package com.ylsf.grk.law_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ylsf.grk.law_system.mapper.AppointmentMapper;
import com.ylsf.grk.law_system.pojo.dto.AppointmentDto;
import com.ylsf.grk.law_system.pojo.dto.AppointmentPageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Appointment;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author 小柯
 * @Date 2024/12/18 22:41
 * 预约单Service实现类
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {
    
    @Override
    public boolean createAppointment(AppointmentDto appointmentDto) {
        try {
            Appointment appointment = new Appointment();
            appointment.setClientId(appointmentDto.getClientId());
            appointment.setLawerId(appointmentDto.getLawerId());
            appointment.setCreateTime(appointmentDto.getCreateTime() != null ? appointmentDto.getCreateTime() : LocalDateTime.now());
            appointment.setCaseId(appointmentDto.getCaseId());
            
            boolean result = this.save(appointment);
            if (result) {
                log.info("预约创建成功，预约ID：{}", appointment.getId());
            }
            return result;
        } catch (Exception e) {
            log.error("创建预约失败：{}", e.getMessage());
            return false;
        }
    }
    
    @Override
    public java.util.List<Appointment> getAppointmentsByClientId(Long clientId) {
        try {
            return this.lambdaQuery()
                    .eq(Appointment::getClientId, clientId)
                    .orderByDesc(Appointment::getCreateTime)
                    .list();
        } catch (Exception e) {
            log.error("查询客户预约列表失败：{}", e.getMessage());
            return java.util.Collections.emptyList();
        }
    }
    
    @Override
    public java.util.List<Appointment> getAppointmentsByLawerId(Long lawerId) {
        try {
            return this.lambdaQuery()
                    .eq(Appointment::getLawerId, lawerId)
                    .orderByDesc(Appointment::getCreateTime)
                    .list();
        } catch (Exception e) {
            log.error("查询律师预约列表失败：{}", e.getMessage());
            return java.util.Collections.emptyList();
        }
    }
    
    @Override
    public PageResult pageAllAppointments(AppointmentPageQueryDto queryDto) {
        try {
            // 创建分页对象
            Page<Appointment> page = new Page<>(queryDto.getPage(), queryDto.getSize());
            
            // 构建查询条件
            LambdaQueryWrapper<Appointment> queryWrapper = new LambdaQueryWrapper<>();
            
            // 按客户ID筛选
            if (queryDto.getClientId() != null) {
                queryWrapper.eq(Appointment::getClientId, queryDto.getClientId());
            }
            
            // 按律师ID筛选
            if (queryDto.getLawerId() != null) {
                queryWrapper.eq(Appointment::getLawerId, queryDto.getLawerId());
            }
            
            // 按时间范围筛选
            if (queryDto.getStartTime() != null && !queryDto.getStartTime().isEmpty()) {
                LocalDateTime startTime = LocalDateTime.parse(queryDto.getStartTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                queryWrapper.ge(Appointment::getCreateTime, startTime);
            }
            
            if (queryDto.getEndTime() != null && !queryDto.getEndTime().isEmpty()) {
                LocalDateTime endTime = LocalDateTime.parse(queryDto.getEndTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                queryWrapper.le(Appointment::getCreateTime, endTime);
            }
            
            // 按时间倒序排列
            queryWrapper.orderByDesc(Appointment::getCreateTime);
            
            // 执行分页查询
            Page<Appointment> appointmentPage = this.page(page, queryWrapper);
            
            // 构建分页结果
            PageResult pageResult = new PageResult();
            pageResult.setTotal(appointmentPage.getTotal());
            pageResult.setRecords(appointmentPage.getRecords());
            
            log.info("分页查询预约记录成功，总记录数：{}，当前页：{}，每页大小：{}", 
                    appointmentPage.getTotal(), queryDto.getPage(), queryDto.getSize());
            
            return pageResult;
        } catch (Exception e) {
            log.error("分页查询预约记录失败：{}", e.getMessage());
            // 返回空的分页结果
            PageResult emptyResult = new PageResult();
            emptyResult.setTotal(0L);
            emptyResult.setRecords(java.util.Collections.emptyList());
            return emptyResult;
        }
    }

    /**
     * 删除预约单
     * @param id 预约单ID
     * @return 删除结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deleteAppointment(Long id) {
        log.info("开始删除预约单，预约单ID：{}", id);
        
        try {
            // 1. 验证预约单ID是否存在
            Appointment existingAppointment = getById(id);
            if (existingAppointment == null) {
                log.error("预约单ID不存在：{}", id);
                return Result.error("预约单不存在");
            }
            
            // 2. 记录删除前的信息（用于日志和可能的审计）
            log.info("删除预约单信息：预约单ID={}, 客户ID={}, 律师ID={}, 案件ID={}, 预约时间={}", 
                    id, existingAppointment.getClientId(), existingAppointment.getLawerId(), 
                    existingAppointment.getCaseId(), existingAppointment.getCreateTime());
            
            // 3. 执行删除操作
            boolean deleteResult = removeById(id);
            
            if (deleteResult) {
                log.info("预约单删除成功，预约单ID：{}", id);
                return Result.success(true);
            } else {
                log.error("预约单删除失败，预约单ID：{}", id);
                return Result.error("预约单删除失败");
            }
            
        } catch (Exception e) {
            log.error("删除预约单时发生异常，预约单ID：{}，异常信息：{}", id, e.getMessage(), e);
            return Result.error("删除预约单失败：" + e.getMessage());
        }
    }
}
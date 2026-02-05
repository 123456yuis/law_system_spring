package com.ylsf.grk.law_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylsf.grk.law_system.pojo.dto.AppointmentDto;
import com.ylsf.grk.law_system.pojo.dto.AppointmentPageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Appointment;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;

/**
 * @Author 小柯
 * @Date 2024/12/18 22:41
 * 预约单Service接口
 */
public interface AppointmentService extends IService<Appointment> {
    
    /**
     * 创建预约
     * @param appointmentDto 预约信息
     * @return 预约结果
     */
    boolean createAppointment(AppointmentDto appointmentDto);
    
    /**
     * 根据客户ID查询预约列表
     * @param clientId 客户ID
     * @return 预约列表
     */
    java.util.List<Appointment> getAppointmentsByClientId(Long clientId);
    
    /**
     * 根据律师ID查询预约列表
     * @param lawerId 律师ID
     * @return 预约列表
     */
    java.util.List<Appointment> getAppointmentsByLawerId(Long lawerId);
    
    /**
     * 分页查询所有预约记录
     * @param queryDto 分页查询参数
     * @return 分页结果
     */
    PageResult pageAllAppointments(AppointmentPageQueryDto queryDto);

    /**
     * 删除预约单（级联删除相关数据）
     * @param id 预约单ID
     * @return 删除结果
     */
    Result<Boolean> deleteAppointment(Long id);
}
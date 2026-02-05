package com.ylsf.grk.law_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylsf.grk.law_system.mapper.ClientMapper;
import com.ylsf.grk.law_system.pojo.dto.ClientPageQueryDto;
import com.ylsf.grk.law_system.pojo.dto.ClientUpdateDto;
import com.ylsf.grk.law_system.pojo.entity.Appointment;
import com.ylsf.grk.law_system.pojo.entity.Bill;
import com.ylsf.grk.law_system.pojo.entity.Case;
import com.ylsf.grk.law_system.pojo.entity.Client;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.AppointmentService;
import com.ylsf.grk.law_system.service.BillService;
import com.ylsf.grk.law_system.service.CaseService;
import com.ylsf.grk.law_system.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 小柯
 * @Date 2024/12/1 21:05
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {
    private final ClientMapper clientMapper;
    private final AppointmentService appointmentService;
    private final BillService billService;
    private final CaseService caseService;

    /**
     * 分页查询客户端信息
     * @param clientPageQueryDto
     * @return
     */
    @Override
    public PageResult pageAllClient(ClientPageQueryDto clientPageQueryDto) {
        PageHelper.startPage(clientPageQueryDto.getPage(), clientPageQueryDto.getSize());
        Page<Client> clients = clientMapper.pageQuery(clientPageQueryDto);
        return new PageResult(clients.getTotal(), clients.getResult());
    }

    /**
     * 根据客户名称查询id
     *
     * @param clientName
     * @return
     */
    @Override
    public Long getIdByName(String clientName) {
        Client client = getOne(new LambdaQueryWrapper<Client>().eq(Client::getName, clientName));
        return client==null?null:client.getId();
    }

    /**
     * 更新客户信息
     * @param clientUpdateDto
     * @return
     */
    /**
     * 更新客户信息
     * @param clientUpdateDto 客户更新信息
     * @return 更新结果
     */
    @Transactional
    @Override
    public Result updateClient(ClientUpdateDto clientUpdateDto) {
        log.info("开始更新客户信息，客户ID：{}", clientUpdateDto.getId());
        
        // 1. 验证客户ID是否存在
        Client existingClient = getById(clientUpdateDto.getId());
        if (existingClient == null) {
            log.error("客户ID不存在：{}", clientUpdateDto.getId());
            return Result.error("客户不存在");
        }
        
        // 2. 验证必填字段
        if (!StringUtils.hasText(clientUpdateDto.getName())) {
            return Result.error("客户姓名不能为空");
        }
        if (!StringUtils.hasText(clientUpdateDto.getUsername())) {
            return Result.error("用户名不能为空");
        }
        if (clientUpdateDto.getSex() == null) {
            return Result.error("性别不能为空");
        }
        if (!StringUtils.hasText(clientUpdateDto.getPhone())) {
            return Result.error("联系电话不能为空");
        }
        
        // 3. 验证用户名唯一性（如果修改了用户名）
        if (!existingClient.getUsername().equals(clientUpdateDto.getUsername())) {
            Client clientByUsername = getOne(new LambdaQueryWrapper<Client>()
                    .eq(Client::getUsername, clientUpdateDto.getUsername()));
            if (clientByUsername != null && !clientByUsername.getId().equals(clientUpdateDto.getId())) {
                log.error("用户名已存在：{}", clientUpdateDto.getUsername());
                return Result.error("用户名已存在");
            }
        }
        
        // 4. 验证手机号格式（简单验证）
        if (StringUtils.hasText(clientUpdateDto.getPhone()) && 
            !clientUpdateDto.getPhone().matches("^1[3-9]\\d{9}$")) {
            log.error("手机号格式不正确：{}", clientUpdateDto.getPhone());
            return Result.error("手机号格式不正确");
        }
        
        // 5. 创建更新对象
        Client clientToUpdate = new Client();
        BeanUtils.copyProperties(clientUpdateDto, clientToUpdate);
        
        // 6. 处理密码（如果提供了新密码，则进行加密；否则保持原密码）
        if (StringUtils.hasText(clientUpdateDto.getPassword())) {
            // 对新密码进行MD5加密
            String encryptedPassword = DigestUtils.md5DigestAsHex(clientUpdateDto.getPassword().getBytes());
            clientToUpdate.setPassword(encryptedPassword);
        } else {
            // 不更新密码，保持原密码
            clientToUpdate.setPassword(existingClient.getPassword());
        }
        
        // 8. 执行更新操作
        boolean updateResult = updateById(clientToUpdate);
        
        if (updateResult) {
            log.info("客户信息更新成功，客户ID：{}，姓名：{}", clientUpdateDto.getId(), clientUpdateDto.getName());
            return Result.success(true);
        } else {
            log.error("客户信息更新失败，客户ID：{}", clientUpdateDto.getId());
            return Result.error("客户信息更新失败");
        }
    }

    /**
     * 删除客户信息（级联删除关联数据）
     * @param id 客户ID
     * @return 删除结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deleteClient(Long id) {
        log.info("开始删除客户信息（级联删除），客户ID：{}", id);
        
        try {
            // 1. 验证客户ID是否存在
            Client existingClient = getById(id);
            if (existingClient == null) {
                log.error("客户ID不存在：{}", id);
                return Result.error("客户不存在");
            }
            
            // 2. 级联删除关联数据
            // 2.1 删除预约记录
            boolean appointmentDeleted = appointmentService.remove(
                new LambdaQueryWrapper<Appointment>().eq(com.ylsf.grk.law_system.pojo.entity.Appointment::getClientId, id)
            );
            log.info("删除客户预约记录，客户ID：{}，删除结果：{}", id, appointmentDeleted);
            
            // 2.2 删除账单记录
            boolean billDeleted = billService.remove(
                new LambdaQueryWrapper<Bill>().eq(com.ylsf.grk.law_system.pojo.entity.Bill::getClientId, id)
            );
            log.info("删除客户账单记录，客户ID：{}，删除结果：{}", id, billDeleted);
            
            // 2.3 删除案件记录（根据业务需求决定是否删除）
            // boolean caseDeleted = caseService.remove(
            //     new LambdaQueryWrapper<>().eq(com.ylsf.grk.law_system.pojo.entity.Case::getClientId, id)
            // );
            // log.info("删除客户案件记录，客户ID：{}，删除结果：{}", id, caseDeleted);
            
            // 3. 删除客户主记录
            boolean clientDeleted = removeById(id);
            
            if (clientDeleted) {
                log.info("客户信息删除成功，客户ID：{}，姓名：{}", id, existingClient.getName());
                return Result.success(true);
            } else {
                log.error("客户信息删除失败，客户ID：{}", id);
                throw new RuntimeException("客户信息删除失败");
            }
            
        } catch (Exception e) {
            log.error("删除客户信息时发生异常，客户ID：{}，异常信息：{}", id, e.getMessage(), e);
            // 事务会自动回滚
            return Result.error("删除客户信息失败：" + e.getMessage());
        }
    }
    
    /**
     * 检查客户是否有关联数据
     * @param clientId 客户ID
     * @return 是否存在关联数据
     */
    private boolean checkClientHasRelatedData(Long clientId) {
        // 检查预约记录
        long appointmentCount = appointmentService.count(
            new LambdaQueryWrapper<Appointment>().eq(com.ylsf.grk.law_system.pojo.entity.Appointment::getClientId, clientId)
        );
        
        // 检查账单记录
        long billCount = billService.count(
            new LambdaQueryWrapper<Bill>().eq(com.ylsf.grk.law_system.pojo.entity.Bill::getClientId, clientId)
        );
        
        // 检查案件记录
        long caseCount = caseService.count(
            new LambdaQueryWrapper<Case>().eq(com.ylsf.grk.law_system.pojo.entity.Case::getClientId, clientId)
        );
        
        log.info("客户关联数据检查，客户ID：{}，预约数：{}，账单数：{}，案件数：{}", 
                clientId, appointmentCount, billCount, caseCount);
        
        return appointmentCount > 0 || billCount > 0 || caseCount > 0;
    }
}
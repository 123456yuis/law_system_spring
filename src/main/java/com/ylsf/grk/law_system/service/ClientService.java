package com.ylsf.grk.law_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylsf.grk.law_system.pojo.dto.ClientPageQueryDto;
import com.ylsf.grk.law_system.pojo.dto.ClientUpdateDto;
import com.ylsf.grk.law_system.pojo.entity.Client;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;

/**
 * @Author 小柯
 * @Date 2024/12/1 21:05
 */
public interface ClientService extends IService<Client> {
    /**
     * 分页查询所有客户端信息
     * @param clientPageQueryDto
     * @return
     */
    PageResult pageAllClient(ClientPageQueryDto clientPageQueryDto);

    Long getIdByName(String clientName);

    Result<Boolean> updateClient(ClientUpdateDto clientUpdateDto);

    /**
     * 删除客户信息
     * @param id 客户ID
     * @return 删除结果
     */
    Result<Boolean> deleteClient(Long id);
}
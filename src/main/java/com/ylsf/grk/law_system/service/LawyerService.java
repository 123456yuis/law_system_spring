package com.ylsf.grk.law_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylsf.grk.law_system.pojo.dto.LawyerLoginDto;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.pojo.vo.LawyerCaseCountVO;
import com.ylsf.grk.law_system.result.Result;

import java.util.List;


public interface LawyerService extends IService<Lawyer> {
    /**
     * 根据律师名称获取律师id
     * @param lawyerName
     * @return
     */
    Long getIdByName(String lawyerName);

    /**
     * 获取律师案件数量
     * @return
     */
    Result<List<LawyerCaseCountVO>> getLawyerCaseCount();

    /**
     * 律师登录
     * @param lawyerLoginDto
     * @return
     */
    Lawyer login(LawyerLoginDto lawyerLoginDto);

    /**
     * 分页查询律师负责的案件
     * @param lawyerId 律师ID
     * @param page 页码
     * @param pageSize 每页大小
     * @param caseName 案件名称（可选）
     * @param caseType 案件类型（可选）
     * @param clientName 客户名称（可选）
     * @return 分页结果
     */
    com.ylsf.grk.law_system.result.PageResult getLawyerCasePage(Long lawyerId, Integer page, Integer pageSize, String caseName, String caseType, String clientName);

    /**
     * 获取律师负责的客户列表
     * @param lawyerId 律师ID
     * @return 客户列表
     */
    java.util.List<com.ylsf.grk.law_system.pojo.entity.Client> getLawyerClients(Long lawyerId);
}
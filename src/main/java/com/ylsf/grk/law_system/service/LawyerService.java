package com.ylsf.grk.law_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
}

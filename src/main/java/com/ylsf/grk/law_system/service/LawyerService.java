package com.ylsf.grk.law_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;


public interface LawyerService extends IService<Lawyer> {
    /**
     * 根据律师名称获取律师id
     * @param lawyerName
     * @return
     */
    Long getIdByName(String lawyerName);
}

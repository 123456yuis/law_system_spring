package com.ylsf.grk.law_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ylsf.grk.law_system.mapper.LawyerMapper;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.service.LawyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LawyerServiceImpl extends ServiceImpl<LawyerMapper, Lawyer> implements LawyerService {
    public Long getIdByName(String lawyerName) {
        Lawyer lawyer = getOne(new LambdaQueryWrapper<Lawyer>().eq(Lawyer::getName, lawyerName));
        return lawyer==null?null:lawyer.getId();
    }
}

package com.ylsf.grk.law_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ylsf.grk.law_system.mapper.CaseMapper;
import com.ylsf.grk.law_system.mapper.LawyerMapper;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.pojo.vo.LawyerCaseCountVO;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.CaseService;
import com.ylsf.grk.law_system.service.LawyerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LawyerServiceImpl extends ServiceImpl<LawyerMapper, Lawyer> implements LawyerService {


    @Resource
    private CaseMapper caseMapper;

    @Resource
    private LawyerMapper lawyerMapper;
    /**
     * 根据律师名称获取律师id
     * @param lawyerName
     * @return
     */
    public Long getIdByName(String lawyerName) {
        Lawyer lawyer = getOne(new LambdaQueryWrapper<Lawyer>().eq(Lawyer::getName, lawyerName));
        return lawyer==null?null:lawyer.getId();
    }

    /**
     * 获取律师案件数量
     * @return
     */
    @Override
    public Result<List<LawyerCaseCountVO>> getLawyerCaseCount() {
        //获取所有律师的信息
        List<LawyerCaseCountVO> lawyerCaseCountVOS = lawyerMapper.selectAllLawyerCaseCount();
        return Result.success(lawyerCaseCountVOS);
    }
}

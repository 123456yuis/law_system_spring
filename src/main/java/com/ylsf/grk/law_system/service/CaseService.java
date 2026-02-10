package com.ylsf.grk.law_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylsf.grk.law_system.pojo.dto.CaseDTO;
import com.ylsf.grk.law_system.pojo.dto.CasePageQueryDto;
import com.ylsf.grk.law_system.pojo.dto.CaseSearchDto;
import com.ylsf.grk.law_system.pojo.dto.PageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Case;
import com.ylsf.grk.law_system.pojo.vo.CaseCategoryStatisticsVO;
import com.ylsf.grk.law_system.pojo.vo.CaseStatisticVO;
import com.ylsf.grk.law_system.pojo.vo.LawyerCaseCountVO;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;

import java.util.List;


public interface CaseService extends IService<Case> {
    Result<PageResult> pageCase(CasePageQueryDto casePageQueryDto);

    Result<CaseStatisticVO> statistic();


    Result addCase(CaseDTO caseDTO);

    Result updateCase(CaseDTO caseDTO);

    Result removeCaseById(Long id);

    Result<CaseCategoryStatisticsVO> getCaseCategoryStatistics();

}

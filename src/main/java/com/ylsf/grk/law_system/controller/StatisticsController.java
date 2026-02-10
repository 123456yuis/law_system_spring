package com.ylsf.grk.law_system.controller;

import com.ylsf.grk.law_system.pojo.vo.CaseCategoryStatisticsVO;
import com.ylsf.grk.law_system.pojo.vo.LawyerCaseCountVO;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.CaseService;
import com.ylsf.grk.law_system.service.LawyerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 案件统计模块
 */
@Tag(name = "案件统计模块")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {

    private final CaseService caseService;
    private final LawyerService lawyerService;
    @Operation(summary = "案件分类统计")
    @GetMapping("/getCaseCategoryStatistics")
    public Result<CaseCategoryStatisticsVO> getCaseCategoryStatistics(){
        return caseService.getCaseCategoryStatistics();
    }

    @Operation(summary = "律师案件统计")
    @GetMapping("/getLawyerCaseCount")
    public Result<List<LawyerCaseCountVO>> getLawyerCaseCount(){
        return lawyerService.getLawyerCaseCount();
    }

}

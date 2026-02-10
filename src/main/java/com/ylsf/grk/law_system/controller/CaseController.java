package com.ylsf.grk.law_system.controller;


import com.ylsf.grk.law_system.annotation.Log;
import com.ylsf.grk.law_system.pojo.dto.CaseDTO;
import com.ylsf.grk.law_system.pojo.dto.CasePageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Case;
import com.ylsf.grk.law_system.pojo.vo.CaseStatisticVO;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.CaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

@Tag(name = "案件模块")
@RestController
@Slf4j
@RequestMapping("/lawer/case")
@RequiredArgsConstructor
public class CaseController {
    @Resource
    private CaseService caseService;

    @Log(desc = "案件列表查询")
    @Operation(summary = "分页查询案件列表")
    @PostMapping("/page")
    public Result<PageResult> page(@Param(value = "分页参数") @RequestBody CasePageQueryDto casePageQueryDto) {
        return caseService.pageCase(casePageQueryDto);
    }

    @Operation(summary = "案件数据统计")
    @PostMapping("/statistics")
    public Result<CaseStatisticVO> statistic() {
        return caseService.statistic();
    }

    @Operation(summary = "根据id获取案件详细信息")
    @GetMapping("/{id}")
    public Result<Case> getCaseDetail(@PathVariable("id") Long id) {
        return Result.success(caseService.getById(id));
    }

    @Operation(summary = "案件新增")
    @PostMapping
    public Result addCase(@RequestBody CaseDTO caseDTO) {
        log.info("案件新增：{}", caseDTO);
        return caseService.addCase(caseDTO);
    }

    @Operation(summary = "案件修改")
    @PutMapping("/update")
    public Result updateCase(@RequestBody CaseDTO caseDTO) {
        log.info("案件修改：{}", caseDTO);
        return caseService.updateCase(caseDTO);
    }

    @Operation(summary = "案件删除")
    @DeleteMapping("/delete/{id}")
    public Result deleteCase(@PathVariable("id") Long id) {
        return caseService.removeCaseById(id);
    }

}
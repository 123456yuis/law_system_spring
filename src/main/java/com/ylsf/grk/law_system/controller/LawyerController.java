package com.ylsf.grk.law_system.controller;

import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.LawyerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lawyer")
public class LawyerController {
    private final LawyerService lawyerService;
    @Operation(summary = "根据id获取律师信息")
    @GetMapping ("/{id}")
    public Result<Lawyer> getById(@PathVariable Long id){
        return Result.success(lawyerService.getById(id));
    }
}

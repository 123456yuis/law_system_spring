package com.ylsf.grk.law_system.controller;

import com.ylsf.grk.law_system.context.BaseContext;
import com.ylsf.grk.law_system.pojo.dto.LawyerLoginDto;
import com.ylsf.grk.law_system.pojo.entity.Client;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.pojo.vo.EmployeeLoginVo;
import com.ylsf.grk.law_system.pojo.vo.LawyerLoginVo;
import com.ylsf.grk.law_system.property.JwtProperties;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.LawyerService;
import com.ylsf.grk.law_system.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lawyer")
public class LawyerController {
    private final LawyerService lawyerService;
    private final JwtProperties jwtProperties;
    @Operation(summary = "根据id获取律师信息")
    @GetMapping("/{id}")
    public Result<Lawyer> getById(@PathVariable Long id) {
        return Result.success(lawyerService.getById(id));
    }

    @Operation(summary = "律师登录")
    @PostMapping("/login")
    public Result<LawyerLoginVo> login(@RequestBody LawyerLoginDto lawyerLoginDto) {
        log.info("登录：{}", lawyerLoginDto);
        Lawyer lawyer=lawyerService.login(lawyerLoginDto);
        Map<String, Object> claims = new HashMap<>();
        claims.put("empId", lawyer.getId());
        String token = JwtUtil.createJWT(jwtProperties.getEmployeeSecretKey(), jwtProperties.getEmployeeTtl(), claims);
        LawyerLoginVo lawyerLoginVo = LawyerLoginVo.builder().lawyerId(lawyer.getId())
                .token(token)
                .build();
        return Result.success(lawyerLoginVo);
    }

    @Operation(summary = "获取当前律师接口")
    @GetMapping("/current/info")
    public Result<Lawyer> getCurrentInfo() {
        log.info("获取当前律师信息");
        log.info("当前律师id：{}", BaseContext.getCurrentId());
        Lawyer lawyer = lawyerService.getById(BaseContext.getCurrentId());
        return Result.success(lawyer);
    }

    @Operation(summary = "分页查询当前律师负责案件")
    @PostMapping("/case/page")
    public Result<PageResult> page(@RequestParam(defaultValue = "1") Integer page, 
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(required = false) String caseName,
                                   @RequestParam(required = false) String caseType,
                                   @RequestParam(required = false) String clientName) {
        log.info("分页查询当前律师负责案件，页码：{}，每页大小：{}，案件名称：{}，案件类型：{}，客户名称：{}", 
                page, pageSize, caseName, caseType, clientName);
        
        // 获取当前登录律师ID
        Long currentLawyerId = BaseContext.getCurrentId();
        log.info("当前律师id：{}", currentLawyerId);
        
        // 调用服务层方法进行分页查询
        PageResult pageResult = lawyerService.getLawyerCasePage(currentLawyerId, page, pageSize, caseName, caseType, clientName);
        
        return Result.success(pageResult);
    }

    @Operation(summary = "获取案件类型列表")
    @GetMapping("/case/types")
    public Result<List<Map<String, Object>>> getCaseTypeList() {
        log.info("获取案件类型列表");
        
        List<Map<String, Object>> caseTypeList = new ArrayList<>();
        
        // 刑事案件
        Map<String, Object> criminalCase = new HashMap<>();
        criminalCase.put("value", 1);
        criminalCase.put("label", "刑事案件");
        caseTypeList.add(criminalCase);
        
        // 民事案件
        Map<String, Object> civilCase = new HashMap<>();
        civilCase.put("value", 2);
        civilCase.put("label", "民事案件");
        caseTypeList.add(civilCase);
        
        // 行政案件
        Map<String, Object> administrativeCase = new HashMap<>();
        administrativeCase.put("value", 3);
        administrativeCase.put("label", "行政案件");
        caseTypeList.add(administrativeCase);
        
        // 其他案件
        Map<String, Object> otherCase = new HashMap<>();
        otherCase.put("value", 4);
        otherCase.put("label", "其他案件");
        caseTypeList.add(otherCase);
        
        log.info("案件类型列表：{}", caseTypeList);
        
        return Result.success(caseTypeList);
    }

    @Operation(summary = "获取当前律师负责的客户列表")
    @GetMapping("/client/list")
    public Result<List<Client>> getLawyerClientList() {
        log.info("获取当前律师负责的客户列表");
        
        // 获取当前登录律师ID
        Long currentLawyerId = BaseContext.getCurrentId();
        log.info("当前律师id：{}", currentLawyerId);
        
        // 调用服务层方法获取客户列表
        List<Client> clientList = lawyerService.getLawyerClients(currentLawyerId);
        
        log.info("查询到{}个客户", clientList.size());
        
        return Result.success(clientList);
    }
}
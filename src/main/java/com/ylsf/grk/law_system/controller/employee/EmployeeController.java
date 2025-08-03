package com.ylsf.grk.law_system.controller.employee;


import com.baomidou.mybatisplus.annotation.TableName;
import com.ylsf.grk.law_system.context.BaseContext;
import com.ylsf.grk.law_system.pojo.dto.EmployeeLoginDto;
import com.ylsf.grk.law_system.pojo.dto.EmployeeRegisterDto;
import com.ylsf.grk.law_system.pojo.dto.LawyerPageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Employee;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.pojo.vo.EmployeeLoginVo;
import com.ylsf.grk.law_system.property.JwtProperties;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.EmployeeService;
import com.ylsf.grk.law_system.utils.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 小柯
 * @Date 2024/12/1 18:12
 */
@Tag(name = "员工测试类")
@RestController
@RequestMapping("/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final JwtProperties jwtProperties;

    /**
     * 员工登录
     * @param employeeLoginDto
     */
    @PostMapping("/login")
    public Result<EmployeeLoginVo> login(@RequestBody EmployeeLoginDto employeeLoginDto){
        log.info("登录：{}",employeeLoginDto);
        Employee employee = employeeService.login(employeeLoginDto);
        //登录成功后，根据员工id生成token
        Map<String, Object> claims = new HashMap<>();
        claims.put("empId", employee.getId());
        String token = JwtUtil.createJWT(jwtProperties.getEmployeeSecretKey(), jwtProperties.getEmployeeTtl(), claims);
        EmployeeLoginVo employeeLoginVo = EmployeeLoginVo.builder().employeeId(employee.getId())
                .token(token)
                .build();
        return Result.success(employeeLoginVo);
    }

    /**
     * 获取当前员工信息
     * @return
     */
    @GetMapping("/current/info")
    public Result<Employee> getCurrentEmployeeInfo(){
        Long currentId = BaseContext.getCurrentId();
        log.info("当前员工id：{}"+currentId);
        Employee employee=employeeService.getCurrentEmployeeInfo();
        return Result.success(employee);
    }

    /**
     * 员工注册 TODO
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody EmployeeRegisterDto employeeRegisterDto){
        log.info("注册用户信息：{}",employeeRegisterDto);
        employeeService.register(employeeRegisterDto);
        return Result.success();
    }

    /**
     * 分页查询所有律师的信息
     * @param lawyerPageQueryDto
     * @return
     */
    @PostMapping("/pageAllLawyer")
    public Result<PageResult> getAllLawyer(@RequestBody LawyerPageQueryDto lawyerPageQueryDto){
        PageResult pageResult = employeeService.pageAllLawyer(lawyerPageQueryDto);
        return Result.success(pageResult);
    }

    @Operation(summary = "获取律师数量")
    @GetMapping("/getLawyerCount")
    public Result<Long> getLawyerCount(){
        return employeeService.getLawyerCount();
    }
}

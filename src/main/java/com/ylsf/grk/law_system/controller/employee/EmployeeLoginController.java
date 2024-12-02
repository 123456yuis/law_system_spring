package com.ylsf.grk.law_system.controller.employee;


import com.ylsf.grk.law_system.pojo.dto.EmployeeLoginDto;
import com.ylsf.grk.law_system.pojo.entity.Employee;
import com.ylsf.grk.law_system.pojo.vo.EmployeeLoginVo;
import com.ylsf.grk.law_system.property.JwtProperties;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.EmployeeLoginService;
import com.ylsf.grk.law_system.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 小柯
 * @Date 2024/12/1 18:12
 */
@RestController
@RequestMapping("/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeLoginController {
    private final EmployeeLoginService employeeLoginService;
    private final JwtProperties jwtProperties;
    /**
     * 员工登录
     * @param employeeLoginDto
     */
    @PostMapping("/login")
    public Result<EmployeeLoginVo> login(@RequestBody EmployeeLoginDto employeeLoginDto){
        log.info("登录：{}",employeeLoginDto);
        Employee employee = employeeLoginService.login(employeeLoginDto);
        //登录成功后，根据员工id生成token
        Map<String, Object> claims = new HashMap<>();
        claims.put("empId", employee.getId());
        String token = JwtUtil.createJWT(jwtProperties.getEmployeeSecretKey(), jwtProperties.getEmployeeTtl(), claims);
        EmployeeLoginVo employeeLoginVo = EmployeeLoginVo.builder().employeeId(employee.getId())
                .token(token)
                .build();
        return Result.success(employeeLoginVo);
    }
}

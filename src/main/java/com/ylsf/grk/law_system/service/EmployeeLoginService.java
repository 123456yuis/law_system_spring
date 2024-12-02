package com.ylsf.grk.law_system.service;

import com.ylsf.grk.law_system.pojo.dto.EmployeeLoginDto;
import com.ylsf.grk.law_system.pojo.entity.Employee;

/**
 * @Author 小柯
 * @Date 2024/12/1 21:05
 */
public interface EmployeeLoginService {
    /**
     * 员工登录
     * @param employeeLoginDto
     */
    Employee login(EmployeeLoginDto employeeLoginDto);
}

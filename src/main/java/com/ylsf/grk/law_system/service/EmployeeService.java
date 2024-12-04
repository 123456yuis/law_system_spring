package com.ylsf.grk.law_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylsf.grk.law_system.pojo.dto.EmployeeLoginDto;
import com.ylsf.grk.law_system.pojo.dto.EmployeeRegisterDto;
import com.ylsf.grk.law_system.pojo.entity.Employee;

/**
 * @Author 小柯
 * @Date 2024/12/1 21:05
 */
public interface EmployeeService extends IService<Employee> {
    /**
     * 员工登录
     * @param employeeLoginDto
     */
    Employee login(EmployeeLoginDto employeeLoginDto);

    /**
     * 获取当前员工的信息
     * @return
     */
    Employee getCurrentEmployeeInfo();

    /**
     * 新员工注册
     * @param employeeRegisterDto
     */
    void register(EmployeeRegisterDto employeeRegisterDto);
}

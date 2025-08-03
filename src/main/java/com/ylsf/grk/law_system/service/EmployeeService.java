package com.ylsf.grk.law_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylsf.grk.law_system.pojo.dto.EmployeeLoginDto;
import com.ylsf.grk.law_system.pojo.dto.EmployeeRegisterDto;
import com.ylsf.grk.law_system.pojo.dto.LawyerPageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Employee;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;

import java.util.List;

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

    /**
     * 分页查询所有律师信息
     * @param lawyerPageQueryDto
     * @return
     */
    PageResult pageAllLawyer(LawyerPageQueryDto lawyerPageQueryDto);

    /**
     * 获取律师的数量
     * @return
     */
    Result<Long> getLawyerCount();
}

package com.ylsf.grk.law_system.service.impl;


import com.ylsf.grk.law_system.exception.EmployeeException;
import com.ylsf.grk.law_system.mapper.EmployeeLoginMapper;
import com.ylsf.grk.law_system.pojo.dto.EmployeeLoginDto;
import com.ylsf.grk.law_system.pojo.entity.Employee;
import com.ylsf.grk.law_system.service.EmployeeLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author 小柯
 * @Date 2024/12/1 21:05
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeLoginServiceImpl implements EmployeeLoginService {
    private final EmployeeLoginMapper employeeLoginMapper;
    @Override
    public Employee login(EmployeeLoginDto employeeLoginDto) {
        //获取到前端穿来的员工名和密码
        String username=employeeLoginDto.getUsername();
        String password=employeeLoginDto.getPassword();
        //从数据库中根据员工名查询出用户信息
        Employee employee=employeeLoginMapper.getByUsername(username);
        if (employee==null) {
            //说明没有该员工
            throw new EmployeeException("员工不存在");
        }
        if(!employee.getPassword().equals(password)){
            //说明密码不匹配
            throw new EmployeeException("密码错误");
        }
        return employee;
    }
}

package com.ylsf.grk.law_system.service.impl;




import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ylsf.grk.law_system.context.BaseContext;
import com.ylsf.grk.law_system.exception.BaseException;
import com.ylsf.grk.law_system.exception.EmployeeException;
import com.ylsf.grk.law_system.mapper.EmployeeMapper;
import com.ylsf.grk.law_system.mapper.LawyerMapper;
import com.ylsf.grk.law_system.pojo.dto.EmployeeLoginDto;
import com.ylsf.grk.law_system.pojo.dto.EmployeeRegisterDto;
import com.ylsf.grk.law_system.pojo.dto.LawyerPageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Employee;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author 小柯
 * @Date 2024/12/1 21:05
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final LawyerMapper lawyerMapper;
    /**
     * 员工登录
     * @param employeeLoginDto
     * @return
     */
    @Override
    public Employee login(EmployeeLoginDto employeeLoginDto) {
        //获取到前端穿来的员工名和密码
        String username=employeeLoginDto.getUsername();
        String password=employeeLoginDto.getPassword();
        //从数据库中根据员工名查询出用户信息
        Employee employee=employeeMapper.getByEmployeeName(username);
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

    /**
     * 获取当前员工的信息
     * @return
     */
    @Override
    public Employee getCurrentEmployeeInfo() {
        Long currentId = BaseContext.getCurrentId();
        return employeeMapper.getEmployeeInfoById(currentId);
    }

    /**
     * 新员工注册
     * @param employeeRegisterDto
     */
    @Transactional
    public void register(EmployeeRegisterDto employeeRegisterDto) {
        //查询用户名是否重名
        String username = employeeRegisterDto.getUsername();
        String password = employeeRegisterDto.getPassword();
        List<Employee> list = lambdaQuery().list();
        for (Employee employee : list) {
            if (username.equals(employee.getUsername())) {
                throw new BaseException("注册的用户名已存在");
            }
        }
        //检查用户名和密码是否符合格式
        judgeUserNameAndPassword(username,password);
        //注册员工
        Employee employee = new Employee();
        employee.setCreateTime(LocalDateTime.now());
        BeanUtil.copyProperties(employeeRegisterDto,employee);
        employeeMapper.insert(employee);
    }

    /**
     * 分页查询律师信息
     * @param lawyerPageQueryDto
     * @return
     */
    @Override
    public PageResult pageAllLawyer(LawyerPageQueryDto lawyerPageQueryDto) {
        PageHelper.startPage(lawyerPageQueryDto.getPage(),lawyerPageQueryDto.getSize());
        Page<Lawyer> lawyers = lawyerMapper.pageQuery(lawyerPageQueryDto);
        return new PageResult(lawyers.getTotal(),lawyers.getResult());
    }

    /**
     * 获取律师数量
     * @return
     */
    @Override
    public Result<Long> getLawyerCount() {

        return Result.success(lawyerMapper.getCount());
    }

    /**
     * 判断用户名和密码的合法性
     * @param username
     * @param password
     */
    private static void judgeUserNameAndPassword(String username, String password) {
        // 正则表达式：用户名必须是5-10位的字符
        String USERNAME_PATTERN = "^[a-zA-Z0-9]{5,10}$";
        // 正则表达式：密码必须是6-15位的非空字符
        String PASSWORD_PATTERN = "^[a-zA-Z0-9!@#$%^&*()_+]{6,15}$";
        if(!username.matches(USERNAME_PATTERN)){
            throw new BaseException("用户名必须是5-10位的字符");
        }
        if(!password.matches(PASSWORD_PATTERN)){
            throw new BaseException("密码必须是6-15位的非空字符");
        }
    }

}

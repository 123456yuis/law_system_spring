package com.ylsf.grk.law_system.mapper;

import com.ylsf.grk.law_system.pojo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author 小柯
 * @Date 2024/12/2 0:11
 */
@Mapper
public interface EmployeeLoginMapper {
    /**
     * 根据员工名查询出员工信息
     * @param username
     * @return
     */
    @Select("select * from employee where username=#{username}")
    Employee getByUsername(String username);
}

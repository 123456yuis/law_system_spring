package com.ylsf.grk.law_system.mapper;

import com.ylsf.grk.law_system.pojo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author 小柯
 * @Date 2024/12/2 0:11
 */
@Mapper
public interface EmployeeMapper {
    /**
     * 根据员工名查询出员工信息
     * @param username
     * @return
     */
    @Select("select * from employee where username=#{username}")
    Employee getByEmployeeName(String username);

    /**
     * 根据id获取员工信息
     * @param currentId
     * @return
     */
    @Select("select * from employee where id=#{id}")
    Employee getEmployeeInfoById(Long currentId);
}

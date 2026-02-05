package com.ylsf.grk.law_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;

import com.ylsf.grk.law_system.pojo.dto.PageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.result.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author 小柯
 * @Date 2024/12/18 22:55
 */

@Mapper
public interface LawyerMapper extends BaseMapper<Lawyer> {
    @Select("select * from lawyer")
    Page<Lawyer> pageQuery(PageQueryDto lawyerPageQueryDto);

    @Select("select count(*) from lawyer")
    Long getCount();

    @Update("update lawyer set name=#{name}, avatar=#{avatar}, address=#{address}, sex=#{sex}, years=#{years}, business=#{business}, biography=#{biography}, identification=#{identification}, phone=#{phone}, state=#{state}, expenses=#{expenses} where id=#{id}")
    int update(Lawyer lawyer);

}
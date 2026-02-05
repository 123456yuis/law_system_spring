package com.ylsf.grk.law_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.ylsf.grk.law_system.pojo.dto.ClientPageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author 小柯
 * @Date 2024/12/18 22:55
 */
@Mapper
public interface ClientMapper extends BaseMapper<Client> {
    @Select("select * from client")
    Page<Client> pageQuery(ClientPageQueryDto clientPageQueryDto);
}
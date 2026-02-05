package com.ylsf.grk.law_system.pojo.dto;

import lombok.Data;

/**
 * 客户信息更新DTO
 */
@Data
public class ClientUpdateDto {
    
    /**
     * 客户ID
     */
    private Long id;
    
    /**
     * 客户姓名
     */
    private String name;
    
    /**
     * 账号
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 性别 (0:女, 1:男)
     */
    private Integer sex;
    
    /**
     * 联系电话
     */
    private String phone;
    
    /**
     * 个人简介
     */
    private String biography;
}
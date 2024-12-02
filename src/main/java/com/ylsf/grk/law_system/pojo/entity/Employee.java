package com.ylsf.grk.law_system.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author 小柯
 * @Date 2024/12/1 18:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Integer sex;
    private String avatar;
    private String address;
    private LocalDateTime createTime;
}

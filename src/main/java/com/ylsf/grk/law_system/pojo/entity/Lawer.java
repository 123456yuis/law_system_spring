package com.ylsf.grk.law_system.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author 小柯
 * @Date 2024/12/1 18:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lawer {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String avatar;
    private String address;
    private Integer sex;
    private Integer years;
    private String business;
    private String biography;
    private String identification;
    private String phone;
    private BigDecimal expenses;
    private LocalDateTime createTime;
}

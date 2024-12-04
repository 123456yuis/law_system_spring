package com.ylsf.grk.law_system.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 小柯
 * @Date 2024/12/3 23:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDto {
    private String username;
    private String password;
}

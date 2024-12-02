package com.ylsf.grk.law_system.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 小柯
 * @Date 2024/12/1 19:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLoginDto {
    private Long empId;
    private String username;
    private String password;
}

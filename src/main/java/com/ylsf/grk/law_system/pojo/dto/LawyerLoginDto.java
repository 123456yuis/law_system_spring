package com.ylsf.grk.law_system.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 律师登录信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LawyerLoginDto {
    private String username;
    private String password;
}

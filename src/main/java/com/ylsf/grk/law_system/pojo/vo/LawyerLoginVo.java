package com.ylsf.grk.law_system.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 律师登录返回值
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LawyerLoginVo {
    private Long lawyerId;
    private String token;
}

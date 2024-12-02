package com.ylsf.grk.law_system.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 小柯
 * @Date 2024/12/1 21:53
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EmployeeLoginVo {
    private Long employeeId;
    private String token;
}

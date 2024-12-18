package com.ylsf.grk.law_system.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author 小柯
 * @Date 2024/12/18 22:42
 * 工资单类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wage {
    private Long id;
    private BigDecimal salPaid;
    private BigDecimal salPayable;
    private Long emId;
    private Long lawerId;
    private Integer salState;
    private LocalDateTime createTime;
}

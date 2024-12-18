package com.ylsf.grk.law_system.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author 小柯
 * @Date 2024/12/18 22:38
 * 支付订单类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private Long id;
    private Long emId;
    private Long clientId;
    private LocalDateTime createTime;
    private Integer billState;
    private BigDecimal billPaid;
    private BigDecimal billPayable;
}

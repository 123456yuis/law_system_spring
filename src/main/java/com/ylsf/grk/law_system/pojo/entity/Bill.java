package com.ylsf.grk.law_system.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("bill")
public class Bill {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long emId;
    private Long clientId;
    private LocalDateTime createTime;
    private Integer billState;
    private BigDecimal billPaid;
    private BigDecimal billPayable;
}

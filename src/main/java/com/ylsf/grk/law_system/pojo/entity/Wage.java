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
 * @Date 2024/12/18 22:42
 * 工资单类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("wage")
public class Wage {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private BigDecimal salPaid;
    private BigDecimal salPayable;
    private Long emId;
    private Long lawerId;
    private Integer salState;
    private LocalDateTime createTime;
}

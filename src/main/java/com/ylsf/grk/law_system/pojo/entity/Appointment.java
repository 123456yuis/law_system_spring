package com.ylsf.grk.law_system.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author 小柯
 * @Date 2024/12/18 22:41
 * 预约单类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private Long id;
    private Long clientId;
    private Long lawerId;
    private LocalDateTime createTime;
    private Long caseId;
}
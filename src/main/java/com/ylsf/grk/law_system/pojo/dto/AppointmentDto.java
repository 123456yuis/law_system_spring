package com.ylsf.grk.law_system.pojo.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * @Author 小柯
 * @Date 2024/12/18 22:41
 * 预约DTO类
 */
@Data
public class AppointmentDto {
    private Long clientId;
    private Long lawerId;
    private LocalDateTime createTime;
    private Long caseId;
}
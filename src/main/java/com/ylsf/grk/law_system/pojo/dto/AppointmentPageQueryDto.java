package com.ylsf.grk.law_system.pojo.dto;

import lombok.Data;

/**
 * @Author 小柯
 * @Date 2024/12/18 22:41
 * 预约分页查询DTO
 */
@Data
public class AppointmentPageQueryDto {
    private Integer page = 1;      // 页码，默认第1页
    private Integer size = 10;     // 每页大小，默认10条
    private String keyword;        // 搜索关键词（可搜索客户名、律师名）
    private Long clientId;         // 客户ID（可选）
    private Long lawerId;          // 律师ID（可选）
    private String startTime;      // 开始时间（可选）
    private String endTime;        // 结束时间（可选）
}
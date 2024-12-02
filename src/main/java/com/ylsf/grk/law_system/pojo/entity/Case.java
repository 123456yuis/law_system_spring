package com.ylsf.grk.law_system.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author 小柯
 * @Date 2024/12/1 18:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Case {
    private Long id;
    private String name;
    private Integer category;
    private Long clientId;
    private Integer isFinal;
    private String Description;
    private Long LawerId;
    private String auditResponse;
    private Integer auditStatus;
    private LocalDateTime createTime;
}

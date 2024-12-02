package com.ylsf.grk.law_system.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author 小柯
 * @Date 2024/12/1 18:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private Long clientId;
    private Long lawerId;
    private String Content;
    private LocalDateTime CreateTime;
}

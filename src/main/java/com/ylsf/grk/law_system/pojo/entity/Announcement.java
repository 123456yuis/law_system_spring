package com.ylsf.grk.law_system.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author 小柯
 * @Date 2024/12/1 18:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private Long clientId;
    private Long thumbsUp;
    private Long views;
}

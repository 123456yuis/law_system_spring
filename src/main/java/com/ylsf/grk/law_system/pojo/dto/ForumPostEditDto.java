package com.ylsf.grk.law_system.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 小柯
 * @Date 2025/1/31 20:22
 * 帖子编辑
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumPostEditDto {
    String title;
    String content;
    String category;
}

package com.ylsf.grk.law_system.pojo.dto;

import lombok.Data;

/**
 * 论坛评论DTO
 */
@Data
public class ForumCommentDto {

    /**
     * 帖子ID
     */
    private Long postId;

    /**
     * 父评论ID(用于回复，可为空)
     */
    private Long parentId;

    /**
     * 评论者ID
     */
    private Long authorId;

    /**
     * 评论者姓名
     */
    private String authorName;

    /**
     * 评论内容
     */
    private String content;

}
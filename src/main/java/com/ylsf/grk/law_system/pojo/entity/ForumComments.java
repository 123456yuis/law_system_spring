package com.ylsf.grk.law_system.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 论坛评论实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("forum_comments")
public class ForumComments {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 帖子ID
     */
    private Long postId;

    /**
     * 父评论ID(用于回复)
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

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
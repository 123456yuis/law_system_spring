package com.ylsf.grk.law_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylsf.grk.law_system.pojo.dto.ForumCommentDto;
import com.ylsf.grk.law_system.pojo.entity.ForumComments;
import com.ylsf.grk.law_system.result.Result;

import java.util.List;

public interface ForumCommentsService extends IService<ForumComments> {

    Result<List<ForumComments>> getByForumPostId(Long id);

    /**
     * 删除评论
     * @param id 评论ID
     * @return 删除结果
     */
    Result deleteComment(Long id);

    /**
     * 新增评论
     * @param commentDto 评论DTO
     * @return 新增结果
     */
    Result addComment(ForumCommentDto commentDto);

    /**
     * 点赞评论
     * @param id 评论ID
     * @return 点赞结果
     */
    Result likeComment(Long id);

    /**
     * 取消点赞评论
     * @param id 评论ID
     * @return 取消点赞结果
     */
    Result unlikeComment(Long id);
}
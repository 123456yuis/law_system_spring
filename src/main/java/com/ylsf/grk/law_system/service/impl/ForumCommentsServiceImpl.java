package com.ylsf.grk.law_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ylsf.grk.law_system.mapper.ForumCommentsMapper;
import com.ylsf.grk.law_system.pojo.dto.ForumCommentDto;
import com.ylsf.grk.law_system.pojo.entity.ForumComments;
import com.ylsf.grk.law_system.pojo.entity.ForumPosts;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.ForumCommentsService;
import com.ylsf.grk.law_system.service.ForumPostsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ForumCommentsServiceImpl extends ServiceImpl<ForumCommentsMapper, ForumComments> implements ForumCommentsService {
    @Resource
    private ForumPostsService forumPostsService;
    @Override
    public Result<List<ForumComments>> getByForumPostId(Long id) {
        List<ForumComments> list = list(new LambdaQueryWrapper<>(ForumComments.class).eq(ForumComments::getPostId, id));
        if (list==null)
            return Result.error("无评论数据");
        return Result.success(list);
    }

    @Override
    public Result deleteComment(Long id) {
        // 检查评论是否存在
        ForumComments comment = getById(id);
        if (comment == null) {
            return Result.error("评论不存在");
        }
        
        // 删除评论
        boolean flag = removeById(id);
        if (flag) {
            return Result.success();
        } else {
            return Result.error("删除失败");
        }
    }

    @Override
    public Result addComment(ForumCommentDto commentDto) {
        // 参数校验
        if (commentDto.getPostId() == null) {
            return Result.error("帖子ID不能为空");
        }
        if (commentDto.getAuthorId() == null) {
            return Result.error("评论者ID不能为空");
        }
        if (commentDto.getAuthorName() == null || commentDto.getAuthorName().trim().isEmpty()) {
            return Result.error("评论者姓名不能为空");
        }
        if (commentDto.getContent() == null || commentDto.getContent().trim().isEmpty()) {
            return Result.error("评论内容不能为空");
        }
        
        // 检查帖子是否存在
        ForumPosts post = forumPostsService.getById(commentDto.getPostId());
        if (post == null) {
            return Result.error("帖子不存在");
        }
        
        // 构建评论实体
        ForumComments comment = new ForumComments();
        comment.setPostId(commentDto.getPostId());
        comment.setParentId(commentDto.getParentId()); // 可为空
        comment.setAuthorId(commentDto.getAuthorId());
        comment.setAuthorName(commentDto.getAuthorName().trim());
        comment.setContent(commentDto.getContent().trim());
        comment.setLikeCount(0); // 默认点赞数为0
        //comment.setStatus("active"); // 默认状态为激活
        comment.setCreateTime(LocalDateTime.now());
        comment.setUpdateTime(LocalDateTime.now());
        
        // 保存评论
        boolean flag = save(comment);
        if (flag) {
            return Result.success();
        } else {
            return Result.error("评论发表失败");
        }
    }

    @Override
    public Result likeComment(Long id) {
        // 检查评论是否存在
        ForumComments comment = getById(id);
        if (comment == null) {
            return Result.error("评论不存在");
        }
        
        // 更新点赞数
        comment.setLikeCount(comment.getLikeCount() + 1);
        comment.setUpdateTime(LocalDateTime.now());
        
        boolean flag = updateById(comment);
        if (flag) {
            return Result.success("点赞成功");
        } else {
            return Result.error("点赞失败");
        }
    }

    @Override
    public Result unlikeComment(Long id) {
        // 检查评论是否存在
        ForumComments comment = getById(id);
        if (comment == null) {
            return Result.error("评论不存在");
        }
        
        // 确保点赞数不会小于0
        int newLikeCount = Math.max(0, comment.getLikeCount() - 1);
        comment.setLikeCount(newLikeCount);
        comment.setUpdateTime(LocalDateTime.now());
        
        boolean flag = updateById(comment);
        if (flag) {
            return Result.success("取消点赞成功");
        } else {
            return Result.error("取消点赞失败");
        }
    }
}
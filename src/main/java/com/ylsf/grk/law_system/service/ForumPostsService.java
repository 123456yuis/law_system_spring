package com.ylsf.grk.law_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylsf.grk.law_system.pojo.dto.ForumPostEditDto;
import com.ylsf.grk.law_system.pojo.dto.ForumPostsDto;
import com.ylsf.grk.law_system.pojo.dto.PageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.ForumPosts;
import com.ylsf.grk.law_system.pojo.vo.ForumPostsVO;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ForumPostsService extends IService<ForumPosts> {
    Result<PageResult> pageList(PageQueryDto queryDto);

    Result editForum(Long id, ForumPostEditDto forumPostEditDto);

    boolean saveForum(ForumPostsDto forumPostsDto);

    /**
     * 点赞帖子
     * @param id 帖子ID
     * @return 点赞结果
     */
    Result likePost(Long id);

    /**
     * 取消点赞帖子
     * @param id 帖子ID
     * @return 取消点赞结果
     */
    Result unlikePost(Long id);
}
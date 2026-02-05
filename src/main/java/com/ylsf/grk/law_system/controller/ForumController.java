package com.ylsf.grk.law_system.controller;

import cn.hutool.db.Page;
import com.ylsf.grk.law_system.pojo.dto.ForumCommentDto;
import com.ylsf.grk.law_system.pojo.dto.ForumPostEditDto;
import com.ylsf.grk.law_system.pojo.dto.ForumPostsDto;
import com.ylsf.grk.law_system.pojo.dto.PageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.ForumCategories;
import com.ylsf.grk.law_system.pojo.entity.ForumComments;
import com.ylsf.grk.law_system.pojo.entity.ForumPosts;
import com.ylsf.grk.law_system.pojo.vo.ForumPostsVO;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.ForumCategoriesService;
import com.ylsf.grk.law_system.service.ForumCommentsService;
import com.ylsf.grk.law_system.service.ForumPostsService;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 小柯
 * @Date 2025/12/31 9:35
 */
@Tag(name = "论坛模块")
@Slf4j
@RestController
@RequestMapping("/forum")
@RequiredArgsConstructor
public class ForumController {
    private final ForumPostsService forumPostsService;
    private final ForumCategoriesService forumCategoriesService;
    private final ForumCommentsService forumCommentsService;

    /**
     * 分页获取论坛列表
     * @param queryDto
     * @return
     */
    @Operation(summary = "分页获取论坛列表")
    @PostMapping("/page")
    public Result<PageResult> pageList(@RequestBody PageQueryDto queryDto){
        log.info("获取论坛列表");
        return forumPostsService.pageList(queryDto);
    }

    @Operation(summary = "获取论坛分类列表")
    @GetMapping("/category")
    public Result<List<ForumCategories>> getCategoryList(){
        List<ForumCategories> forumCategories = forumCategoriesService.list();
        return Result.success(forumCategories);
    }

    @Operation(summary = "编辑论坛")
    @PostMapping("/edit/{id}")
    public Result editForum(@PathVariable Long id, @RequestBody ForumPostEditDto forumPostEditDto){
        return forumPostsService.editForum(id,forumPostEditDto);
    }

    /**
     * 删除论坛
     * @param id
     * @return
     */
    @Operation(summary = "删除论坛")
    @DeleteMapping("/delete/{id}")
    public Result deleteForum(@PathVariable Long id){
        boolean flag = forumPostsService.removeById(id);
        if (flag){
            return Result.success();
        }else {
            return Result.error("删除失败");
        }
    }


    @Operation(summary = "新增论坛")
    @PostMapping("/add")
    public Result addForum(@RequestBody ForumPostsDto forumPostsDto){
        boolean flag = forumPostsService.saveForum(forumPostsDto);
        if (flag){
            return Result.success();
        }else {
            return Result.error("新增失败");
        }
    }
   /* @Operation(summary = "获取论坛详情")
    @GetMapping("/detail/{id}")
    public Result<ForumPostsVO> getDetail(@PathVariable String id){

    }*/
    @Operation(summary = "获取论坛详情")
    @GetMapping("/detail/{id}")
    public Result<ForumPosts> getDetail(@PathVariable Long id){
        ForumPosts forumPosts = forumPostsService.getById(id);
        if (forumPosts==null){
            return Result.error("帖子不存在");
        }
        return Result.success(forumPosts);
    }

    @Operation(summary = "根据论坛分类id获取分类信息")
    @GetMapping("/getCategoryById/{id}")
    public Result<ForumCategories> getCategoryById(@PathVariable Long id){
        ForumCategories forumCategories = forumCategoriesService.getById(id);
        if (forumCategories==null){
            return Result.error("分类不存在");
        }
        return Result.success(forumCategories);
    }

    /**
     * 根据论坛id获取论坛评论
     * @param id
     * @return
     */
    @Operation(summary = "根据论坛id获取论坛评论")
    @GetMapping("/getCommentById/{id}")
    public Result<List<ForumComments>> getCommentById(@PathVariable Long id){
        return forumCommentsService.getByForumPostId(id);
    }

    /**
     * 删除评论
     * @param id 评论ID
     * @return 删除结果
     */
    @Operation(summary = "删除评论")
    @DeleteMapping("/comment/delete/{id}")
    public Result deleteComment(@PathVariable Long id){
        return forumCommentsService.deleteComment(id);
    }

    /**
     * 新增评论
     * @param commentDto 评论DTO
     * @return 新增结果
     */
    @Operation(summary = "新增评论")
    @PostMapping("/comment/add")
    public Result addComment(@RequestBody ForumCommentDto commentDto){
        return forumCommentsService.addComment(commentDto);
    }

    /**
     * 点赞评论
     * @param id 评论ID
     * @return 点赞结果
     */
    @Operation(summary = "点赞评论")
    @PutMapping("/comment/like/{id}")
    public Result likeComment(@PathVariable Long id){
        return forumCommentsService.likeComment(id);
    }

    /**
     * 取消点赞评论
     * @param id 评论ID
     * @return 取消点赞结果
     */
    @Operation(summary = "取消点赞评论")
    @PutMapping("/comment/unlike/{id}")
    public Result unlikeComment(@PathVariable Long id){
        return forumCommentsService.unlikeComment(id);
    }

    /**
     * 点赞帖子
     * @param id 帖子ID
     * @return 点赞结果
     */
    @Operation(summary = "点赞帖子")
    @PutMapping("/post/like/{id}")
    public Result likePost(@PathVariable Long id){
        return forumPostsService.likePost(id);
    }

    /**
     * 取消点赞帖子
     * @param id 帖子ID
     * @return 取消点赞结果
     */
    @Operation(summary = "取消点赞帖子")
    @PutMapping("/post/unlike/{id}")
    public Result unlikePost(@PathVariable Long id){
        return forumPostsService.unlikePost(id);
    }

}
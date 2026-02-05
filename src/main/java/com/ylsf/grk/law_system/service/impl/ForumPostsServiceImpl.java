package com.ylsf.grk.law_system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ylsf.grk.law_system.context.BaseContext;
import com.ylsf.grk.law_system.mapper.ForumPostsMapper;
import com.ylsf.grk.law_system.pojo.dto.ForumPostEditDto;
import com.ylsf.grk.law_system.pojo.dto.ForumPostsDto;
import com.ylsf.grk.law_system.pojo.dto.PageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Employee;
import com.ylsf.grk.law_system.pojo.entity.ForumCategories;
import com.ylsf.grk.law_system.pojo.entity.ForumPosts;
import com.ylsf.grk.law_system.pojo.vo.ForumPostsVO;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.EmployeeService;
import com.ylsf.grk.law_system.service.ForumCategoriesService;
import com.ylsf.grk.law_system.service.ForumPostsService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ForumPostsServiceImpl extends ServiceImpl<ForumPostsMapper, ForumPosts> implements ForumPostsService{

    @Resource
    private ForumCategoriesService categoriesService;

    @Resource
    private EmployeeService employeeService;

    /**
     * 分页获取论坛列表
     * @param queryDto
     * @return
     */
    @Override
    public Result<PageResult> pageList(PageQueryDto queryDto) {
        Page<ForumPosts> page = new Page<>(queryDto.getPage(), queryDto.getSize());
        //查询得到分页数据
        Page<ForumPosts> forumPostsPage = baseMapper.selectPage(page, null);
        
        //构建返回分页数据
        List<ForumPosts> records = forumPostsPage.getRecords();
        List<ForumPostsVO> forumPostsVOS = new ArrayList<>();
        for (ForumPosts record : records) {
            ForumPostsVO forumPostsVO = new ForumPostsVO();
            forumPostsVO.setAuthor(record.getAuthorName());
            forumPostsVO.setTitle(record.getTitle());
            //根据categoryId查询分类名称
            String category=getCategoryById(record.getCategoryId());
            forumPostsVO.setCategory(category);
            forumPostsVO.setLikeCount(record.getLikeCount().toString());
            forumPostsVO.setBrowseCount(record.getViewCount().toString());
            forumPostsVO.setPublishTime(record.getCreateTime());
            forumPostsVO.setId(record.getId().toString());
            forumPostsVO.setContent(record.getContent());
            forumPostsVOS.add(forumPostsVO);
        }
        
        //构建正确的分页结果
        PageResult pageResult = new PageResult();
        pageResult.setTotal(forumPostsPage.getTotal());  // 使用原始分页的总记录数
        pageResult.setRecords(forumPostsVOS);
        
        return Result.success(pageResult);
    }

    /**
     * 编辑论坛
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Result editForum(Long id, ForumPostEditDto forumPostEditDto) {
        //1.根据id查询论坛文章
        ForumPosts forumPosts = baseMapper.selectById(id);
        //2.根据分类名称查询分类id
        String categoryName = forumPostEditDto.getCategory();
        ForumCategories category = categoriesService.getOne(new QueryWrapper<ForumCategories>().eq("name", categoryName));
        //3.更新数据
        forumPosts.setTitle(forumPostEditDto.getTitle());
        forumPosts.setContent(forumPostEditDto.getContent());
        forumPosts.setCategoryId(category.getId());
        forumPosts.setUpdateTime(LocalDateTime.now());
        baseMapper.updateById(forumPosts);
        return Result.success();
    }

    @Transactional
    @Override
    public boolean saveForum(ForumPostsDto forumPostsDto) {
        //1.获取当前登录员工信息
        Employee currentEmployeeInfo = employeeService.getCurrentEmployeeInfo();
        //2.将dto转换为entity
        ForumPosts forumPosts = new ForumPosts();
        forumPosts.setAuthorName(currentEmployeeInfo.getName());
        forumPosts.setAuthorId(currentEmployeeInfo.getId());
        forumPosts.setContent(forumPostsDto.getContent());
        forumPosts.setTitle(forumPostsDto.getTitle());
        String categoryId = categoriesService.getOne(new QueryWrapper<ForumCategories>().eq("name", forumPostsDto.getCategory())).getId().toString();
        forumPosts.setCategoryId(Integer.parseInt(categoryId));
        //3.设置默认值
        forumPosts.setViewCount(0);
        forumPosts.setLikeCount(0);
        forumPosts.setCommentCount(0);
        forumPosts.setIsTop(false);
        forumPosts.setCreateTime(LocalDateTime.now());
        forumPosts.setUpdateTime(LocalDateTime.now());
        //4.保存到数据库
        return baseMapper.insert(forumPosts) > 0;
    }

    /**
     * 根据id查询论坛文章分类名称
     * @param categoryId
     * @return
     */
    private String getCategoryById(Integer categoryId) {
        ForumCategories category = categoriesService.getById(categoryId);
        return category.getName().toString();
    }

    @Override
    public Result likePost(Long id) {
        // 检查帖子是否存在
        ForumPosts post = getById(id);
        if (post == null) {
            return Result.error("帖子不存在");
        }
        
        // 更新点赞数
        post.setLikeCount(post.getLikeCount() + 1);
        post.setUpdateTime(LocalDateTime.now());
        
        boolean flag = updateById(post);
        if (flag) {
            return Result.success("点赞成功");
        } else {
            return Result.error("点赞失败");
        }
    }

    @Override
    public Result unlikePost(Long id) {
        // 检查帖子是否存在
        ForumPosts post = getById(id);
        if (post == null) {
            return Result.error("帖子不存在");
        }
        
        // 确保点赞数不会小于0
        int newLikeCount = Math.max(0, post.getLikeCount() - 1);
        post.setLikeCount(newLikeCount);
        post.setUpdateTime(LocalDateTime.now());
        
        boolean flag = updateById(post);
        if (flag) {
            return Result.success("取消点赞成功");
        } else {
            return Result.error("取消点赞失败");
        }
    }
}
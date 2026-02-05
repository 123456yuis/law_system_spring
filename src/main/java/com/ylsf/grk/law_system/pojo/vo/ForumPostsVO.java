package com.ylsf.grk.law_system.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumPostsVO {
    private String id;//帖子id
    private String title;//帖子标题
    private String category;//帖子分类
    private String author;// 作者
    private String likeCount;//点赞量
    private String browseCount;//浏览量
    private String content;//帖子内容
    private LocalDateTime publishTime;//发布时间
}

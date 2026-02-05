package com.ylsf.grk.law_system.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumPostsDto {
    private String author;
    private String title;
    private String content;
    private String category;
}

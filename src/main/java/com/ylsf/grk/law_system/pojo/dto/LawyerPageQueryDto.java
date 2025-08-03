package com.ylsf.grk.law_system.pojo.dto;

import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 小柯
 * @Date 2025/1/31 20:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LawyerPageQueryDto {
    //页码
    private Integer page;
    //每页记录数
    private Integer size;
}

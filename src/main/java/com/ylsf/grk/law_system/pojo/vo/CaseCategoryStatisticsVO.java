package com.ylsf.grk.law_system.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 案件分类统计信息
 * Criminal law, civil law, administrative law
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseCategoryStatisticsVO {
    private Long criminalCaseCount;//刑事案件数量
    private Long civilCaseCount;//民事案件数量
    private Long administrativeCaseCount;//行政案件数量
}

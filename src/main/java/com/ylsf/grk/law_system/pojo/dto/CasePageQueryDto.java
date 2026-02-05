package com.ylsf.grk.law_system.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CasePageQueryDto {
    // 分页参数
    private Integer page;
    private Integer size;

    // 搜索参数
    private String caseName;
    private String caseType;
    private String lawyerName;
    private String clientName;

    //是否进行搜索
    private Boolean isSearch;
}

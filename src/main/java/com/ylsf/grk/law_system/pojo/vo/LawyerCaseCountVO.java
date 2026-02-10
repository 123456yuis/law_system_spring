package com.ylsf.grk.law_system.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 律师案件统计信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LawyerCaseCountVO {
    private Long lawyerId;//律师id
    private String lawyerName;//律师名称
    private Long caseCount;//受理案件数量
}

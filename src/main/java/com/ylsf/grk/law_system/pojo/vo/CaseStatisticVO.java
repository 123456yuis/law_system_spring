package com.ylsf.grk.law_system.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseStatisticVO {
    private Long caseCount;//案件总数
    private Long prAuditCount;//待审核案件数
    private Long afAuditCount;//已审核通过案件数
    private Long reAuditCount;//已审核拒绝案件数
    private Long isEntrustCount;//已委托案件数
    private Long notEntrustCount;//未委托案件数
    private Long completedCount;//已完成案件数
}

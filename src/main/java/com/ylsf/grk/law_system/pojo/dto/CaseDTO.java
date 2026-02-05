package com.ylsf.grk.law_system.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 小柯
 * @Date 2025/1/31 20:05
 * 案件DTO
 * 描述案件信息
 * 描述案件信息
 * 包含案件名称、案件类型、客户账号、律师姓名、案件状态、是否结案、审核回复、是否委托、案件描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseDTO {
    private String id;//案件id
    private String caseName;//案件名称
    private String caseType;//案件类型
    private String clientId;//客户id
    private String lawyerId;//律师id
    private String caseStatus;//案件状态
    private String isClosed;//是否结案
    private String auditReply;//审核回复
    private String isDelegated;//是否委托
    private String caseDesc;//案件描述
}

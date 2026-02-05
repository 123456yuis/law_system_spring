package com.ylsf.grk.law_system.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseSearchDto {
    private String caseName;//案件名称
    private String caseType;//案件类型
    private String lawyerName;//律师名称
    private String clientName;//客户名称
}

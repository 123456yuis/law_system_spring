package com.ylsf.grk.law_system.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author 小柯
 * @Date 2024/12/1 18:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("law_case")
public class Case {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;//主键
    private String name;//案件名称
    private Integer category;//案件类别
    private Long clientId;//客户id
    private Integer isFinal;//是否结案
    private String Description;//案件描述
    private Long LawerId;//律师id
    private String auditResponse;//审核回复
    private String isEntrust;//是否委托
    private Integer auditStatus;//审核状态
    private LocalDateTime createTime;//创建时间
}

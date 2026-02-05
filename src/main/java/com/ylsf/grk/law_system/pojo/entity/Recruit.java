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
 * @Date 2024/12/1 18:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("recruit")
public class Recruit {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private LocalDateTime createTime;
    private String lawerName;
    private String originArea;
    private String resume;
    private Integer isAgree;
    private String response;
    private Long emId;
}
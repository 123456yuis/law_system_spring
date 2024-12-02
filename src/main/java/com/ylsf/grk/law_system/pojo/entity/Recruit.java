package com.ylsf.grk.law_system.pojo.entity;

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
public class Recruit {
    private Long id;
    private LocalDateTime createTime;
    private String lawerName;
    private String originArea;
    private Integer isAgree;
    private String response;
}

package com.ylsf.grk.law_system.service;

import com.ylsf.grk.law_system.pojo.entity.Announcement;

import java.util.List;

/**
 * @Author 小柯
 * @Date 2024/12/11 0:07
 */
public interface AnnouncementService {
    /**
     * 获取所有的公告信息
     * @return
     */
    List<Announcement> getAllAnnouncements();
}

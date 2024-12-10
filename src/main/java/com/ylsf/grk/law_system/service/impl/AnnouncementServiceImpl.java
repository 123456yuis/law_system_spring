package com.ylsf.grk.law_system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ylsf.grk.law_system.mapper.AnnouncementMapper;
import com.ylsf.grk.law_system.pojo.entity.Announcement;
import com.ylsf.grk.law_system.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 小柯
 * @Date 2024/12/11 0:07
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper,Announcement> implements AnnouncementService {
    private final AnnouncementMapper announcementMapper;

    /**
     * 查询所有的公告信息
     * @return
     */
    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementMapper.selectList(null);
    }
}

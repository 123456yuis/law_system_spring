package com.ylsf.grk.law_system.controller.announcement;

import com.ylsf.grk.law_system.pojo.entity.Announcement;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 小柯
 * @Date 2024/12/8 21:22
 */

@RestController
@Slf4j
@RequestMapping("/announcements")
@RequiredArgsConstructor
public class AnnouncementController {
    private final AnnouncementService announcementService;
    /**
     * 获取所有的公告信息
     * @return
     */
    @GetMapping("/getAll")
    public Result<List<Announcement>> getAll(){
        List<Announcement> allAnnouncements=announcementService.getAllAnnouncements();
        return Result.success(allAnnouncements);
    }
}

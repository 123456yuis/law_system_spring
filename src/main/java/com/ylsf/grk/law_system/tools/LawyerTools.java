package com.ylsf.grk.law_system.tools;

import com.ylsf.grk.law_system.pojo.entity.*;
import com.ylsf.grk.law_system.service.*;
import dev.langchain4j.agent.tool.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LawyerTools {
    private final LawyerService lawyerService;
    private final ClientService clientService;
    private final CaseService caseService;
    private final AppointmentService appointmentService;
    private final ForumPostsService forumPostsService;
    private final ForumCategoriesService forumCategoriesService;
    private final ForumCommentsService forumCommentsService;
    private final AnnouncementService announcementService;
    private final BillService billService;
    private final RecruitService recruitService;
    
    // ========== 律师管理相关方法 ==========
    
    @Tool(name = "查询律所中的律师", value = "查询律所中的所有律师信息")
    public String getLawyerInfo() {
        List<Lawyer> lawyers = lawyerService.list();
        return lawyers.stream()
                .map(l -> String.format("律师ID: %d, 姓名: %s, 专业领域: %s", 
                    l.getId(), l.getName(), l.getBusiness()))
                .collect(Collectors.joining("\n"));
    }
    
    @Tool(name = "根据专业领域查询律师", value = "根据专业领域查询符合条件的律师")
    public String getLawyersBySpecialization(String specialization) {
        List<Lawyer> lawyers = lawyerService.list();
        return lawyers.stream()
                .filter(l -> l.getBusiness() != null && l.getBusiness().contains(specialization))
                .map(l -> String.format("律师ID: %d, 姓名: %s, 专业领域: %s", 
                    l.getId(), l.getName(), l.getBusiness()))
                .collect(Collectors.joining("\n"));
    }
    
    // ========== 客户管理相关方法 ==========
    
    @Tool(name = "查询律所中的客户", value = "查询律所中的所有客户信息")
    public String getAllClients() {
        List<Client> clients = clientService.list();
        return clients.stream()
                .map(c -> String.format("客户ID: %d, 姓名: %s, 电话: %s",
                    c.getId(), c.getName(), c.getPhone()))
                .collect(Collectors.joining("\n"));
    }
    
    @Tool(name = "根据客户姓名查询客户信息", value = "根据客户姓名模糊查询客户信息")
    public String getClientsByName(String name) {
        List<Client> clients = clientService.list();
        return clients.stream()
                .filter(c -> c.getName() != null && c.getName().contains(name))
                .map(c -> String.format("客户ID: %d, 姓名: %s, 电话: %s",
                    c.getId(), c.getName(), c.getPhone()))
                .collect(Collectors.joining("\n"));
    }
    
    // ========== 案件管理相关方法 ==========
    
    @Tool(name = "查询所有案件信息", value = "查询律所中的所有案件信息")
    public String getAllCases() {
        List<Case> cases = caseService.list();
        return cases.stream()
                .map(c -> String.format("案件ID: %d, 名称: %s, 类别: %d, 客户ID: %d, 律师ID: %d, 状态: %s", 
                    c.getId(), c.getName(), c.getCategory(), c.getClientId(), 
                    c.getLawerId(), getCaseStatus(c.getAuditStatus())))
                .collect(Collectors.joining("\n"));
    }
    
    @Tool(name = "根据案件状态查询案件", value = "根据审核状态查询案件信息")
    public String getCasesByStatus(Integer auditStatus) {
        List<Case> cases = caseService.list();
        return cases.stream()
                .filter(c -> c.getAuditStatus() != null && c.getAuditStatus().equals(auditStatus))
                .map(c -> String.format("案件ID: %d, 名称: %s, 状态: %s", 
                    c.getId(), c.getName(), getCaseStatus(c.getAuditStatus())))
                .collect(Collectors.joining("\n"));
    }
    
    @Tool(name = "查询律师负责的案件", value = "查询指定律师负责的所有案件")
    public String getCasesByLawyer(Long lawyerId) {
        List<Case> cases = caseService.list();
        return cases.stream()
                .filter(c -> c.getLawerId() != null && c.getLawerId().equals(lawyerId))
                .map(c -> String.format("案件ID: %d, 名称: %s, 客户ID: %d, 状态: %s", 
                    c.getId(), c.getName(), c.getClientId(), getCaseStatus(c.getAuditStatus())))
                .collect(Collectors.joining("\n"));
    }
    
    // ========== 预约管理相关方法 ==========
    
    @Tool(name = "查询所有预约信息", value = "查询律所中的所有预约记录")
    public String getAllAppointments() {
        List<Appointment> appointments = appointmentService.list();
        return appointments.stream()
                .map(a -> String.format("预约ID: %d, 客户ID: %d, 律师ID: %d, 时间: %s, 案件ID: %s", 
                    a.getId(), a.getClientId(), a.getLawerId(), 
                    a.getCreateTime(), a.getCaseId()))
                .collect(Collectors.joining("\n"));
    }
    
    @Tool(name = "查询律师的预约安排", value = "查询指定律师的所有预约安排")
    public String getAppointmentsByLawyer(Long lawyerId) {
        List<Appointment> appointments = appointmentService.list();
        return appointments.stream()
                .filter(a -> a.getLawerId() != null && a.getLawerId().equals(lawyerId))
                .map(a -> String.format("预约ID: %d, 客户ID: %d, 时间: %s", 
                    a.getId(), a.getClientId(), a.getCreateTime()))
                .collect(Collectors.joining("\n"));
    }
    
    @Tool(name = "查询客户的预约记录", value = "查询指定客户的所有预约记录")
    public String getAppointmentsByClient(Long clientId) {
        List<Appointment> appointments = appointmentService.list();
        return appointments.stream()
                .filter(a -> a.getClientId() != null && a.getClientId().equals(clientId))
                .map(a -> String.format("预约ID: %d, 律师ID: %d, 时间: %s", 
                    a.getId(), a.getLawerId(), a.getCreateTime()))
                .collect(Collectors.joining("\n"));
    }
    
    // ========== 论坛管理相关方法 ==========
    
    @Tool(name = "查询论坛分类", value = "查询论坛的所有分类信息")
    public String getForumCategories() {
        List<ForumCategories> categories = forumCategoriesService.list();
        return categories.stream()
                .map(c -> String.format("分类ID: %d, 名称: %s, 描述: %s, 状态: %s", 
                    c.getId(), c.getName(), c.getDescription(), 
                    c.getStatus() ? "启用" : "禁用"))
                .collect(Collectors.joining("\n"));
    }
    
    @Tool(name = "查询最新论坛帖子", value = "查询最新的论坛帖子信息")
    public String getLatestForumPosts() {
        List<ForumPosts> posts = forumPostsService.list();
        return posts.stream()
                .limit(10) // 只显示最新10条
                .map(p -> String.format("帖子ID: %d, 标题: %s, 作者ID: %d, 分类ID: %d, 发布时间: %s", 
                    p.getId(), p.getTitle(), p.getAuthorId(), p.getCategoryId(), p.getCreateTime()))
                .collect(Collectors.joining("\n"));
    }
    
    @Tool(name = "根据分类查询论坛帖子", value = "根据分类ID查询论坛帖子")
    public String getForumPostsByCategory(Integer categoryId) {
        List<ForumPosts> posts = forumPostsService.list();
        return posts.stream()
                .filter(p -> p.getCategoryId() != null && p.getCategoryId().equals(categoryId))
                .map(p -> String.format("帖子ID: %d, 标题: %s, 作者ID: %d, 发布时间: %s", 
                    p.getId(), p.getTitle(), p.getAuthorId(), p.getCreateTime()))
                .collect(Collectors.joining("\n"));
    }
    
    // ========== 公告管理相关方法 ==========
    
    @Tool(name = "查询最新公告", value = "查询最新的公告信息")
    public String getLatestAnnouncements() {
        List<Announcement> announcements = announcementService.list();
        return announcements.stream()
                .limit(5) // 只显示最新5条
                .map(a -> String.format("公告ID: %d, 标题: %s, 发布时间: %s, 浏览量: %d", 
                    a.getId(), a.getTitle(), a.getCreateTime(), a.getViews()))
                .collect(Collectors.joining("\n"));
    }
    
    @Tool(name = "根据关键词查询公告", value = "根据标题关键词查询公告")
    public String getAnnouncementsByKeyword(String keyword) {
        List<Announcement> announcements = announcementService.list();
        return announcements.stream()
                .filter(a -> a.getTitle() != null && a.getTitle().contains(keyword))
                .map(a -> String.format("公告ID: %d, 标题: %s, 发布时间: %s", 
                    a.getId(), a.getTitle(), a.getCreateTime()))
                .collect(Collectors.joining("\n"));
    }
    
    // ========== 其他业务方法 ==========

    
    @Tool(name = "查询账单信息", value = "查询律所的账单信息")
    public String getBillInfo() {
        List<Bill> bills = billService.list();
        return bills.stream()
                .map(b -> String.format("账单ID: %d, 客户ID: %d, 金额: %.2f, 状态: %s", 
                    b.getId(), b.getClientId(), b.getBillPaid(), b.getBillState()))
                .collect(Collectors.joining("\n"));
    }
    
    @Tool(name = "统计律所基本信息", value = "统计律所的基本运营信息")
    public String getStatistics() {
        long lawyerCount = lawyerService.list().size();
        long clientCount = clientService.list().size();
        long caseCount = caseService.list().size();
        long appointmentCount = appointmentService.list().size();
        
        return String.format("""
                律所运营统计：
                - 律师数量: %d 人
                - 客户数量: %d 人
                - 案件数量: %d 个
                - 预约数量: %d 次
                """, lawyerCount, clientCount, caseCount, appointmentCount);
    }
    
    // ========== 辅助方法 ==========
    
    private String getCaseStatus(Integer auditStatus) {
        if (auditStatus == null) return "未知";
        switch (auditStatus) {
            case 0: return "待审核";
            case 1: return "审核通过";
            case 2: return "审核拒绝";
            default: return "未知状态";
        }
    }
}
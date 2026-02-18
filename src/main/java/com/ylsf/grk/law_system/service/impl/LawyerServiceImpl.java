package com.ylsf.grk.law_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ylsf.grk.law_system.exception.LawyerException;
import com.ylsf.grk.law_system.mapper.CaseMapper;
import com.ylsf.grk.law_system.mapper.ClientMapper;
import com.ylsf.grk.law_system.mapper.LawyerMapper;
import com.ylsf.grk.law_system.pojo.dto.LawyerLoginDto;
import com.ylsf.grk.law_system.pojo.entity.Case;
import com.ylsf.grk.law_system.pojo.entity.Client;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.pojo.vo.LawyerCaseCountVO;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.CaseService;
import com.ylsf.grk.law_system.service.LawyerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LawyerServiceImpl extends ServiceImpl<LawyerMapper, Lawyer> implements LawyerService {


    @Resource
    private CaseMapper caseMapper;

    @Resource
    private LawyerMapper lawyerMapper;
    
    @Resource
    private ClientMapper clientMapper;
    /**
     * 根据律师名称获取律师id
     * @param lawyerName
     * @return
     */
    public Long getIdByName(String lawyerName) {
        Lawyer lawyer = getOne(new LambdaQueryWrapper<Lawyer>().eq(Lawyer::getName, lawyerName));
        return lawyer==null?null:lawyer.getId();
    }

    /**
     * 获取律师案件数量
     * @return
     */
    @Override
    public Result<List<LawyerCaseCountVO>> getLawyerCaseCount() {
        //获取所有律师的信息
        List<LawyerCaseCountVO> lawyerCaseCountVOS = lawyerMapper.selectAllLawyerCaseCount();
        return Result.success(lawyerCaseCountVOS);
    }

    @Override
    public Lawyer login(LawyerLoginDto lawyerLoginDto) {
        String name = lawyerLoginDto.getUsername();
        String password = lawyerLoginDto.getPassword();
        Lawyer lawyer = getOne(new LambdaQueryWrapper<Lawyer>().eq(Lawyer::getPhone, name));
        if(lawyer==null){
            throw new LawyerException("律师不存在");
        }
        if(!password.equals(lawyer.getPassword())){
            throw new LawyerException("密码错误");
        }
        return lawyer;
    }

    @Override
    public PageResult getLawyerCasePage(Long lawyerId, Integer page, Integer pageSize, String caseName, String caseType, String clientName) {
        log.info("查询律师负责的案件，律师ID：{}，页码：{}，每页大小：{}，案件名称：{}，案件类型：{}，客户名称：{}", 
                lawyerId, page, pageSize, caseName, caseType, clientName);
        
        // 创建分页对象
        Page<Case> pageInfo = new Page<>(page, pageSize);
        
        // 构建查询条件
        LambdaQueryWrapper<Case> queryWrapper = new LambdaQueryWrapper<>();
        
        // 根据律师ID查询
        queryWrapper.eq(Case::getLawerId, lawyerId);
        
        // 添加搜索条件
        if (caseName != null && !caseName.trim().isEmpty()) {
            queryWrapper.like(Case::getName, caseName.trim());
        }
        
        if (caseType != null && !caseType.trim().isEmpty()) {
            // 将案件类型转换为分类ID
            Integer categoryId = convertCaseTypeToCategory(caseType.trim());
            if (categoryId != null) {
                queryWrapper.eq(Case::getCategory, categoryId);
            }
        }
        
        if (clientName != null && !clientName.trim().isEmpty()) {
            // 需要关联客户表查询，这里先实现基础版本，后续可以优化
            // 暂时只支持案件名称和案件类型搜索
            log.info("客户名称搜索功能暂未实现，搜索条件：{}", clientName);
        }
        
        // 按创建时间倒序排列
        queryWrapper.orderByDesc(Case::getCreateTime);
        
        // 执行分页查询
        Page<Case> casePage = caseMapper.selectPage(pageInfo, queryWrapper);
        
        // 构建返回结果
        PageResult pageResult = new PageResult();
        pageResult.setTotal(casePage.getTotal());
        pageResult.setRecords(casePage.getRecords());
        
        log.info("查询完成，共找到{}条记录", casePage.getTotal());
        
        return pageResult;
    }

    @Override
    public List<Client> getLawyerClients(Long lawyerId) {
        log.info("获取律师负责的客户列表，律师ID：{}", lawyerId);
        
        // 查询该律师负责的所有案件
        LambdaQueryWrapper<Case> caseQueryWrapper = new LambdaQueryWrapper<>();
        caseQueryWrapper.eq(Case::getLawerId, lawyerId);
        List<Case> cases = caseMapper.selectList(caseQueryWrapper);
        
        if (cases.isEmpty()) {
            log.info("律师ID：{} 没有负责的案件", lawyerId);
            return List.of();
        }
        
        // 提取所有客户ID（去重）
        List<Long> clientIds = cases.stream()
                .map(Case::getClientId)
                .distinct()
                .collect(Collectors.toList());
        
        log.info("律师ID：{} 负责的客户ID列表：{}", lawyerId, clientIds);
        
        // 查询客户信息
        LambdaQueryWrapper<Client> clientQueryWrapper = new LambdaQueryWrapper<>();
        clientQueryWrapper.in(Client::getId, clientIds);
        List<Client> clients = clientMapper.selectList(clientQueryWrapper);
        
        log.info("查询到{}个客户信息", clients.size());
        
        return clients;
    }
    
    /**
     * 将案件类型字符串转换为分类ID
     * @param caseType 案件类型
     * @return 分类ID
     */
    private Integer convertCaseTypeToCategory(String caseType) {
        return switch (caseType) {
            case "刑事案件" -> 1;
            case "民事案件" -> 2;
            case "行政案件" -> 3;
            case "其他案件" -> 4;
            default -> {
                // 尝试解析数字类型
                try {
                    yield Integer.valueOf(caseType);
                } catch (NumberFormatException e) {
                    log.warn("未知的案件类型：{}", caseType);
                    yield null;
                }
            }
        };
    }
}
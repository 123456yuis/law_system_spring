package com.ylsf.grk.law_system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ylsf.grk.law_system.mapper.CaseMapper;
import com.ylsf.grk.law_system.pojo.dto.CaseDTO;
import com.ylsf.grk.law_system.pojo.dto.CasePageQueryDto;
import com.ylsf.grk.law_system.pojo.entity.Case;
import com.ylsf.grk.law_system.pojo.vo.CaseStatisticVO;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.CaseService;
import com.ylsf.grk.law_system.service.ClientService;
import com.ylsf.grk.law_system.service.LawyerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case> implements CaseService {
    @Resource
    private LawyerService lawyerService;
    @Resource
    private ClientService clientService;

    /**
     * 获取案件列表
     * @param casePageQueryDto
     * @return
     */
    @Override
    public Result<PageResult> pageCase(CasePageQueryDto casePageQueryDto) {
        log.info("获取案件列表，页码：{}，每页大小：{}", casePageQueryDto.getPage(), casePageQueryDto.getSize());
        //判断是否搜索
        casePageQueryDto.setIsSearch(judgeIsSearch(casePageQueryDto));
        if(casePageQueryDto.getIsSearch()){
            //开始搜索
            log.info("开始搜索案件");
            //构造查询条件
            LambdaQueryWrapper<Case> queryWrapper = new LambdaQueryWrapper<>();
            if(!casePageQueryDto.getCaseName().equals("")){
                queryWrapper.like(Case::getName, casePageQueryDto.getCaseName());
            }
            if(!casePageQueryDto.getCaseType().equals("")) {
                String caseType = casePageQueryDto.getCaseType();
                Integer categoryId = Integer.valueOf(caseType);
                queryWrapper.eq(Case::getCategory, categoryId);
            }
            if(!casePageQueryDto.getLawyerName().equals("")) {
                Long lawyerId = lawyerService.getIdByName(casePageQueryDto.getLawyerName());
                queryWrapper.eq(Case::getLawerId, lawyerId);
            }
            if(!casePageQueryDto.getClientName().equals("")) {
                queryWrapper.eq(Case::getClientId, clientService.getIdByName(casePageQueryDto.getClientName()));
            }
            //执行搜索查询
            Page<Case> page = new Page<>(casePageQueryDto.getPage(), casePageQueryDto.getSize());
            Page<Case> casePage = baseMapper.selectPage(page, queryWrapper);
            List<Case> records = casePage.getRecords();
            PageResult pageResult = new PageResult();
            pageResult.setTotal(casePage.getTotal());
            pageResult.setRecords(records);
            return Result.success(pageResult);
        }
        //执行分页查询
        Page<Case> page = new Page<>(casePageQueryDto.getPage(), casePageQueryDto.getSize());
        Page<Case> casePage = baseMapper.selectPage(page, null);
        PageResult pageResult = new PageResult();
        List<Case> records = casePage.getRecords();
        pageResult.setTotal(casePage.getTotal());
        pageResult.setRecords(records);
        return Result.success(pageResult);
    }

    /**
     * 获取案件统计信息
     * @return
     */
    @Override
    public Result<CaseStatisticVO> statistic() {
        Long total = baseMapper.selectCount(null);
        Long completedCount = baseMapper.selectCount(new LambdaQueryWrapper<Case>()
                .eq(Case::getIsFinal, 1));
        Long isEntrustCount = baseMapper.selectCount(new LambdaQueryWrapper<Case>()
                .eq(Case::getIsEntrust, 1));
        Long notEntrustCount = baseMapper.selectCount(new LambdaQueryWrapper<Case>()
                .eq(Case::getIsEntrust, 0));
        Long prAuditCount = baseMapper.selectCount(new LambdaQueryWrapper<Case>()
                .eq(Case::getAuditStatus, 0));
        Long afAuditCount = baseMapper.selectCount(new LambdaQueryWrapper<Case>()
                .eq(Case::getAuditStatus, 1));
        Long reAuditCount = baseMapper.selectCount(new LambdaQueryWrapper<Case>()
                .eq(Case::getAuditStatus, 2));
        CaseStatisticVO caseStatisticVO = new CaseStatisticVO();
        caseStatisticVO.setCaseCount(total);
        caseStatisticVO.setPrAuditCount(prAuditCount);
        caseStatisticVO.setAfAuditCount(afAuditCount);
        caseStatisticVO.setReAuditCount(reAuditCount);
        caseStatisticVO.setIsEntrustCount(isEntrustCount);
        caseStatisticVO.setNotEntrustCount(notEntrustCount);
        caseStatisticVO.setCompletedCount(completedCount);
        return Result.success(caseStatisticVO);
    }

    /**
     * 添加案件
     * @param caseDTO
     * @return
     */
    @Override
    public Result addCase(CaseDTO caseDTO) {
        Case casePojo = new Case();
        casePojo.setCategory(Integer.valueOf(caseDTO.getCaseType()));
        casePojo.setAuditResponse(caseDTO.getAuditReply());
        casePojo.setClientId(Long.valueOf(caseDTO.getClientId()));
        casePojo.setIsFinal(Integer.valueOf(caseDTO.getIsClosed()));
        casePojo.setIsEntrust(caseDTO.getCaseStatus());
        casePojo.setDescription(caseDTO.getCaseDesc());
        casePojo.setName(caseDTO.getCaseName());
        casePojo.setLawerId(Long.valueOf(caseDTO.getLawyerId()));
        casePojo.setAuditStatus(Integer.valueOf(caseDTO.getCaseStatus()));
        casePojo.setCreateTime(LocalDateTime.now());
        baseMapper.insert(casePojo);
        return Result.success();
    }

    /**
     * 更新案件信息
     * @param caseDTO
     * @return
     */
    @Transactional
    @Override
    public Result updateCase(CaseDTO caseDTO) {
        Case casePojo = new Case();
        casePojo.setId(Long.valueOf(caseDTO.getId()));
        String caseType = caseDTO.getCaseType();
        if(caseType.length()>1){
            casePojo.setCategory(toCategory(caseType));
        }else{
            casePojo.setCategory(Integer.valueOf(caseType));
        }
        casePojo.setClientId(Long.valueOf(caseDTO.getClientId()));
        casePojo.setIsFinal(Integer.valueOf(caseDTO.getIsClosed()));
        casePojo.setIsEntrust(caseDTO.getCaseStatus());
        casePojo.setDescription(caseDTO.getCaseDesc());
        casePojo.setName(caseDTO.getCaseName());
        casePojo.setLawerId(Long.valueOf(caseDTO.getLawyerId()));
        casePojo.setAuditStatus(Integer.valueOf(caseDTO.getCaseStatus()));
        baseMapper.updateById(casePojo);
        return Result.success();
    }

    /**
     * 删除案件
     * @param id
     * @return
     */
    @Override
    public Result removeCaseById(Long id) {
        baseMapper.deleteById(id);
        return Result.success();
    }

    /**
     * 将案件分类转换为案件类型
     * @param category
     * @return
     */
    private String toCaseType(Integer category){
        return switch (category) {
            case 1 -> "刑事案件";
            case 2 -> "民事案件";
            case 3 -> "行政案件";
            default -> "其他案件";
        };
    }

    /**
     * 将案件类型转换为案件分类
     * @param caseType
     * @return
     */
    private Integer toCategory(String caseType){
        return switch (caseType) {
            case "刑事案件" -> 1;
            case "民事案件" -> 2;
            case "行政案件" -> 3;
            default -> 4;
        };
    }

    /**
     * 判断是否为搜索案件
     * @param casePageQueryDto
     * @return
     */
    private Boolean judgeIsSearch(CasePageQueryDto casePageQueryDto){
        if(casePageQueryDto.getCaseName().equals("")&&casePageQueryDto.getCaseType().equals("")
                &&casePageQueryDto.getLawyerName().equals("")&&casePageQueryDto.getClientName().equals("")){
            return false;
        }
        return true;
    }
}

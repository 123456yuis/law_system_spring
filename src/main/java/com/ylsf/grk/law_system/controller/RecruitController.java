package com.ylsf.grk.law_system.controller;

import com.ylsf.grk.law_system.pojo.entity.Recruit;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.RecruitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/recruit")
@Tag(name = "招聘模块")
public class RecruitController {
    private final RecruitService recruitService;
    @Operation(summary = "获取招聘信息")
    @GetMapping("/list")
    public Result<List<Recruit>> getRecruitList(){
        List<Recruit> recruitList = recruitService.list();
        return Result.success(recruitList);
    }

    @Operation(summary = "删除招聘信息")
    @DeleteMapping("/delete/{id}")
    public Result deleteRecruit(@PathVariable("id") Long id){
        boolean b = recruitService.removeById(id);
        if(b){
            return Result.success();
        }else{
            return Result.error("删除失败");
        }
    }

    /**
     * 编辑招聘信息
     * @param recruit
     * @return
     */
    @Operation(summary = "编辑招聘信息")
    @PostMapping("/update")
    public Result updateRecruit(@RequestBody Recruit recruit){
        boolean b = recruitService.updateById(recruit);
        if(b){
            return Result.success();
        }else{
            return Result.error("更新失败");
        }
    }
}

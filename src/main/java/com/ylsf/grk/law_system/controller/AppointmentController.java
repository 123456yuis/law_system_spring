package com.ylsf.grk.law_system.controller;

import com.ylsf.grk.law_system.pojo.entity.Appointment;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 小柯
 * @Date 2024/12/18 22:41
 */
@Slf4j
@RequestMapping("/appointment")
@RestController
@RequiredArgsConstructor
@Tag(name = "预约单模块")
public class AppointmentController {
    private final AppointmentService appointmentService;

    /**
     * 根据id获取预约单详情
     * @param id
     * @return
     */
    @Operation(summary = "根据id获取预约单详情")
    @GetMapping("/getById")
    public Result<Appointment> getById(Long id){
        Appointment appointment=appointmentService.getById(id);
        return Result.success(appointment);
    }

    /**
     * 删除预约单
     * @param id 预约单ID
     * @return 删除结果
     */
    @Operation(summary = "删除预约单")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteAppointment(@PathVariable("id") Long id) {
        log.info("删除预约单，预约单ID：{}", id);
        return appointmentService.deleteAppointment(id);
    }
}
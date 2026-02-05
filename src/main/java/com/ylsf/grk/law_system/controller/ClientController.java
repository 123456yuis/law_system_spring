package com.ylsf.grk.law_system.controller;

import com.ylsf.grk.law_system.pojo.dto.AppointmentDto;
import com.ylsf.grk.law_system.pojo.dto.AppointmentPageQueryDto;
import com.ylsf.grk.law_system.pojo.dto.ClientPageQueryDto;
import com.ylsf.grk.law_system.pojo.dto.ClientUpdateDto;
import com.ylsf.grk.law_system.pojo.entity.Appointment;
import com.ylsf.grk.law_system.pojo.entity.Case;
import com.ylsf.grk.law_system.pojo.entity.Client;
import com.ylsf.grk.law_system.pojo.entity.Lawyer;
import com.ylsf.grk.law_system.result.PageResult;
import com.ylsf.grk.law_system.result.Result;
import com.ylsf.grk.law_system.service.AppointmentService;
import com.ylsf.grk.law_system.service.CaseService;
import com.ylsf.grk.law_system.service.ClientService;
import com.ylsf.grk.law_system.service.LawyerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "客户端模块")
@RestController
@Slf4j
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final AppointmentService appointmentService;
    private final LawyerService lawyerService;
    private final CaseService caseService;

    @Operation(summary = "分页查询客户端列表")
    @PostMapping("/pageAllClients")
    public Result<PageResult> getClientList(@RequestBody ClientPageQueryDto clientPageQueryDto){
        log.info("获取客户端列表，页码：{}，每页大小：{}", clientPageQueryDto.getPage(), clientPageQueryDto.getSize());
        PageResult pageResult = clientService.pageAllClient(clientPageQueryDto);
        return Result.success(pageResult);
    }

    @Operation(summary = "批量获取客户列表")
    @GetMapping("/getAllClients")
    public Result<List<Client>> getAllClients(){
        List<Client> clientList = clientService.list();
        return Result.success(clientList);
    }

    @Operation(summary = "根据id查询客户信息")
    @GetMapping("/getClientById/{id}")
    public Result<Client> getClientById(@PathVariable("id") Long id){
        Client client = clientService.getById(id);
        return Result.success(client);
    }

    @Operation(summary = "编辑客户信息")
    @PutMapping("/updateClient")
    public Result<Boolean> updateClient(@RequestBody ClientUpdateDto clientUpdateDto) {
        log.info("编辑客户信息，客户ID：{}，姓名：{}", clientUpdateDto.getId(), clientUpdateDto.getName());
        return clientService.updateClient(clientUpdateDto);
    }

    @Operation(summary = "删除客户信息")
    @DeleteMapping("/deleteClient/{id}")
    public Result<Boolean> deleteClient(@PathVariable("id") Long id) {
        log.info("删除客户信息，客户ID：{}", id);
        return clientService.deleteClient(id);
    }

    @Operation(summary = "创建客户预约")
    @PostMapping("/createAppointment")
    public Result<Boolean> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        log.info("创建客户预约，客户ID：{}，律师ID：{}，案件ID：{}", 
                appointmentDto.getClientId(), appointmentDto.getLawerId(), appointmentDto.getCaseId());
        boolean result = appointmentService.createAppointment(appointmentDto);
        if (result) {
            return Result.success(true);
        } else {
            return Result.error("预约创建失败");
        }
    }

    @Operation(summary = "根据客户ID查询预约列表")
    @GetMapping("/getAppointmentsByClientId/{clientId}")
    public Result<List<Appointment>> getAppointmentsByClientId(@PathVariable("clientId") Long clientId) {
        log.info("查询客户预约列表，客户ID：{}", clientId);
        List<Appointment> appointments = appointmentService.getAppointmentsByClientId(clientId);
        return Result.success(appointments);
    }

    @Operation(summary = "根据律师ID查询预约列表")
    @GetMapping("/getAppointmentsByLawerId/{lawerId}")
    public Result<List<Appointment>> getAppointmentsByLawerId(@PathVariable("lawerId") Long lawerId) {
        log.info("查询律师预约列表，律师ID：{}", lawerId);
        List<Appointment> appointments = appointmentService.getAppointmentsByLawerId(lawerId);
        return Result.success(appointments);
    }

    @Operation(summary = "根据预约ID查询预约详情")
    @GetMapping("/getAppointmentById/{id}")
    public Result<Appointment> getAppointmentById(@PathVariable("id") Long id) {
        log.info("查询预约详情，预约ID：{}", id);
        Appointment appointment = appointmentService.getById(id);
        return Result.success(appointment);
    }

    @Operation(summary = "删除预约")
    @DeleteMapping("/deleteAppointment/{id}")
    public Result<Boolean> deleteAppointment(@PathVariable("id") Long id) {
        log.info("删除预约，预约ID：{}", id);
        boolean result = appointmentService.removeById(id);
        if (result) {
            return Result.success(true);
        } else {
            return Result.error("预约删除失败");
        }
    }

    @Operation(summary = "分页查询所有预约记录")
    @PostMapping("/pageAllAppointments")
    public Result<PageResult> pageAllAppointments(@RequestBody AppointmentPageQueryDto queryDto) {
        log.info("分页查询所有预约记录，页码：{}，每页大小：{}，客户ID：{}，律师ID：{}", 
                queryDto.getPage(), queryDto.getSize(), queryDto.getClientId(), queryDto.getLawerId());
        PageResult pageResult = appointmentService.pageAllAppointments(queryDto);
        return Result.success(pageResult);
    }



    @Operation(summary = "获取律师信息")
    @GetMapping("/getLawyerById/{lawyerId}")
    public Result<Lawyer> getLawyerById(@PathVariable("lawyerId") Long lawyerId) {
        log.info("获取律师信息，律师ID：{}", lawyerId);
        Lawyer lawyer = lawyerService.getById(lawyerId);
        if (lawyer != null) {
            return Result.success(lawyer);
        } else {
            return Result.error("律师不存在");
        }
    }

    @Operation(summary = "获取案件信息")
    @GetMapping("/getCaseById/{caseId}")
    public Result<Case> getCaseById(@PathVariable("caseId") Long caseId) {
        log.info("获取案件信息，案件ID：{}", caseId);
        Case caseInfo = caseService.getById(caseId);
        if (caseInfo != null) {
            return Result.success(caseInfo);
        } else {
            return Result.error("案件不存在");
        }
    }
}
package com.ylsf.grk.law_system.controller;

import com.ylsf.grk.law_system.assistant.LegalAssistant;
import com.ylsf.grk.law_system.pojo.dto.ChatDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@Tag(name = "法律咨询")
@RestController
@RequestMapping("/legal")
public class LegalController {

    @Resource
    private LegalAssistant legalAssistant;
    @Operation(summary = "法律咨询")
    @PostMapping(value = "/chat",produces = "text/stream;charset=UTF-8")
    public Flux<String> chat(@RequestBody ChatDto chatDto){
        return legalAssistant.chat(chatDto.getMemoryId(), chatDto.getMessage());
    }
}

package com.ylsf.grk.law_system;

import com.ylsf.grk.law_system.assistant.SeparateChatAssistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToolsTest {

    @Resource
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void test() {
        String chat = separateChatAssistant.chat(1, "1+2等于多少？，475695037565的平方根是多少？");
        System.out.println(chat);//689,706.4865324959
    }
}



package com.ylsf.grk.law_system;

import com.ylsf.grk.law_system.assistant.SeparateChatAssistant;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
public class OpenAiTest {
    @Autowired
    private OpenAiChatModel openAiChatModel;
    /*@Test
    void test01() {
        String chat = openAiChatModel.chat("你好");
        System.out.println(chat);
    }*/
    @Resource
    private SeparateChatAssistant separateChatAssistant;

    @Test
    void test02() {
        //String chat = separateChatAssistant.chat(1,"你好，我是张三");
        String chat = separateChatAssistant.chat(1,"你好，我是谁");
        System.out.println(chat);
    }
}

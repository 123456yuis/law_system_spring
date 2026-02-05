package com.ylsf.grk.law_system;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
public class OpenAiTest {
    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Test
    void test01() {
        String chat = openAiChatModel.chat("你好");
        System.out.println(chat);
    }
}

package com.ylsf.grk.law_system.utils;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {

    @Tool(name = "加法器",value = "用于返回两个数的和")
     double sum(@ToolMemoryId int memoryId, double a, double b) {
        System.out.println("调用加法器 memoryId=" + memoryId);
        return a + b;
    }

    @Tool(name = "平方根器",value = "用于返回一个数的平方根")
    double squareRoot(@ToolMemoryId int memoryId, double a) {
        System.out.println("调用平方根器 memoryId=" + memoryId);
        return Math.sqrt(a);
    }

}

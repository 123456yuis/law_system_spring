package com.ylsf.grk.law_system.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Date;

@Aspect // 标记这是一个切面
@Component // 交给Spring管理
@Slf4j
public class LogAspect {

    /**
     * 定义切入点：匹配所有使用@Log注解的方法
     * （如果想匹配所有controller方法，改为 execution(* com.example.demo.controller.*.*(..)) ）
     */
    @Pointcut("@annotation(com.ylsf.grk.law_system.annotation.Log)")
    public void logPointcut() {
    }



    /**
     * @Around：统计方法执行耗时（能控制目标方法是否执行）
     */
    @Around("logPointcut()")
    public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // 执行目标方法（必须调用，否则目标方法不会执行）
        long end = System.currentTimeMillis();
        log.info("【日志-环绕】耗时：{}ms", (end - start));
        return result; // 返回目标方法的结果
    }

}


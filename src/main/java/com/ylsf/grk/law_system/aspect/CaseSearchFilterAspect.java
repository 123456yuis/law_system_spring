package com.ylsf.grk.law_system.aspect;

import com.ylsf.grk.law_system.pojo.dto.CasePageQueryDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CaseSearchFilterAspect {
    /**
     * 定义切入点：匹配所有使用@CaseSearchFilter注解的方法
     */
    @Pointcut("@annotation(com.ylsf.grk.law_system.annotation.CaseSearchFilter)")
    public void caseSearchFilterPointcut() {}


}

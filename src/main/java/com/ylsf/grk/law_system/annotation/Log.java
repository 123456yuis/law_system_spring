package com.ylsf.grk.law_system.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD) // 作用在方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时生效
public @interface Log {
    String desc() default "默认日志"; // 日志描述
}


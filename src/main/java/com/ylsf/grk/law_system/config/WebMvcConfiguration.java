package com.ylsf.grk.law_system.config;


import com.ylsf.grk.law_system.interceptor.JWTEmployeeInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author 小柯
 * @Date 2024/12/1 23:14
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    private final JWTEmployeeInterceptor jwtEmployeeInterceptor;
    /**
     * 注册自定义拦截器
     *
     * @param registry
     */
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtEmployeeInterceptor)
                .addPathPatterns("/employee/**")
                .excludePathPatterns("/employee/login")
                .excludePathPatterns("/employee/register");
    }
    /**
     * 设置静态资源映射
     * @param registry
     */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

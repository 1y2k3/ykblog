package com.yk.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/**").excludePathPatterns("/web/user/login").excludePathPatterns("/web/user/register").excludePathPatterns("/api/user/login").excludePathPatterns("/api/user/register");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/web/user/login");
        super.addInterceptors(registry);
    }
}
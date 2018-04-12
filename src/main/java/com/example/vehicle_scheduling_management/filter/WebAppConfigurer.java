package com.example.vehicle_scheduling_management.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by 叶俊锋 on 2018/4/4.
 * 添加一个拦截器
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurationSupport {
    /*注册拦截器*/
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*/**");
        super.addInterceptors(registry);
    }

    /*静态资源配置，禁止拦截器拦截静态资源*/
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/assets/");
        registry.addResourceHandler("/contact/**").addResourceLocations("classpath:/static/contact/");
        super.addResourceHandlers(registry);
    }
}

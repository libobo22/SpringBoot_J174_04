package com.boot.config;

import com.boot.interceptors.MyInterceptor;
import com.boot.interceptors.PowerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class MyWebConfiguer implements WebMvcConfigurer {

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/leaf/findAllUserList","/**/*.html","/repertory/**","/data/**","/power/login","/gotoLogin");
        registry.addInterceptor(new PowerInterceptor())
                .addPathPatterns("/repertory/**","/data/**");

    }

    /**
     * 放行静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}

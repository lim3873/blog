package com.example.blog.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry){
        registry.addResourceHandler("/img/**", "/css/**", "/js/**")
                .addResourceLocations("classpath:/templates",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }

}

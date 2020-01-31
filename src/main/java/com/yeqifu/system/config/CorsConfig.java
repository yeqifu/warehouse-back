package com.yeqifu.system.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决跨域问题
 * @Author: 落亦-
 * @Date: 2020/1/31 12:49
 */
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/*")
                .allowedOrigins("*")
                .allowedMethods("GET,POST,PUT,DELETE,HEAD,OPTIONS")
                .allowedHeaders("*")
                //是否可以携带cookie
                .allowCredentials(true)
                .maxAge(3600);
    }

}

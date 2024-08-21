package com.anaperini.todosimple.configs;


import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
    
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**");
    }
}

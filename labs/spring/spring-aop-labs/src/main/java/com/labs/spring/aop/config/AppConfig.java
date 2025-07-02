package com.labs.spring.aop.config;

import com.labs.spring.aop.aspect.LoggingAspect;
import com.labs.spring.aop.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public ProductService productService() {
        return new ProductService();
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}

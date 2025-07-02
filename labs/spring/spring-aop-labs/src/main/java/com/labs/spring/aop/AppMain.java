package com.labs.spring.aop;

import com.labs.spring.aop.config.AppConfig;
import com.labs.spring.aop.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Arrays;

public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println(ctx);
        System.out.println("Bean Count: " + ctx.getBeanDefinitionCount());
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        ctx.getBean("productService", ProductService.class).doWork();
        ctx.getBean("productService", ProductService.class).takeBreak();

    }
}

package com.labs.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LoggingAspect {

    @Before("execution(* com.labs.spring.aop.service.ProductService.*(..))")
    public void beforeAdvice() {
        System.out.println("LoggingAspect: Before advice executed.");
    }

    @After("execution(* com.labs.spring.aop.service.ProductService.*(..))")
    public void afterAdvice() {
        System.out.println("LoggingAspect: After advice executed.");
    }

}

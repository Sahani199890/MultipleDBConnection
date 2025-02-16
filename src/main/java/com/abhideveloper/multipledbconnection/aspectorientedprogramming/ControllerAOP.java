package com.abhideveloper.multipledbconnection.aspectorientedprogramming;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAOP {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAOP.class);

    @Before("execution(* com.abhideveloper.multipledbconnection.controller..*(..))")
    public void logBeforeDynamic(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("Method [{}] is about to execute", methodName);
    }
}

package com.latha.creditservice.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
@Component
class LoggingAspect {
    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.latha.creditservice.*.*.*(..) )")
    public void logBefore(JoinPoint joinPoint) {
        log.info("logBefore() is running!");
        log.info("method invoked {}:{}() ", joinPoint.getSignature().getName(), joinPoint.getTarget().getClass().toString());
    }

    @After("execution(* com.latha.creditservice.*.*.*(..) )")
    public void logAfter(JoinPoint joinPoint) {
        log.info("logAfter() is running!");
        log.info("method invoked {}:{}() ", joinPoint.getSignature().getName(), joinPoint.getTarget().getClass().toString());
    }

    @AfterReturning(pointcut = "execution(* com.latha.creditservice.*.*.*(..) )", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("logAfterReturning() is running!");
        log.info("method invoked {}:{}() ", joinPoint.getSignature().getName(), joinPoint.getTarget().getClass().toString());
        log.info("Method returned value is :{} ", result);
    }

    @AfterThrowing(pointcut = "execution(* com.latha.creditservice.*.*.*(..) )", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.info("logAfterThrowing() is running!");
        log.info("method invoked {}:{}() ", joinPoint.getSignature().getName(), joinPoint.getTarget().getClass().toString());
        log.info("Exception :{} ", error);
    }

//    @Around("execution(* com.latha.creditservice.*.*.*(..) )")
//    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        ObjectMapper mapper = new ObjectMapper();
//        log.info("logAround() is running!");
//        log.info("method invoked :{} " , joinPoint.getSignature().getName());
//        log.info("arguments : {}",Arrays.toString(joinPoint.getArgs()));
//        log.info("class name: {}",joinPoint.getTarget().getClass().toString());
//        Object object = joinPoint.proceed();
//        log.info("Response: {}",mapper.writeValueAsString(object));
//        return object;
//
//    }

}
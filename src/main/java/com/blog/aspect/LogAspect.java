package com.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @version V1.0
 * @author: hezheng
 * @date: 2020/4/26 10:35
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Pointcut("execution(public * com.blog.controller.*.*(..))")
    public void log() {
    }

    @Before(value = "log()")
    public void doBefore(JoinPoint joinPoint) {
        LocalDateTime now = LocalDateTime.now();
        logger.info(now.toString()+"开始执行"+joinPoint.getSignature().getName());
    }


    @After(value = "log()")
    public void doAfter(JoinPoint joinPoint) {
        LocalDateTime now = LocalDateTime.now();
        logger.info(now.toString()+"执行完成"+joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result) {
        logger.info("Result:{}",result);
    }
}

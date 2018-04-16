package com.example.vehicle_scheduling_management.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 19:52 2018/4/16
 * @modified by:
 */
@Aspect
@Component
public class WebLogger {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.example.vehicle_scheduling_management.action.*.*(..))")
    public void baseLogger(){}

    @Before("baseLogger()")
    public void toBefore(JoinPoint joinPoint){
// 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

// 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("请求方法 : " + request.getMethod());
        logger.info("类_方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("参数 : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret",pointcut = "baseLogger()")
    public void toAfter(Object ret){
        logger.info("响应:" + ret);
    }
}

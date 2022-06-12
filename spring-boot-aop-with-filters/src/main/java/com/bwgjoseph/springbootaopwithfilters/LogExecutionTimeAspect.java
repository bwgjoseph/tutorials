package com.bwgjoseph.springbootaopwithfilters;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogExecutionTimeAspect {
    @Around(value = "@annotation(LogExecutionTime)")
    // Solution 1
    // @Around(value = "@annotation(LogExecutionTime) && !@annotation(Ignore)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        var stopWatch = new StopWatch();
        stopWatch.start();

        Object proceed = joinPoint.proceed();

        stopWatch.stop();

        log.info("{} took a total of {}ms to complete", joinPoint.getSignature(), stopWatch.getTotalTimeMillis());

        return proceed;
    }
}

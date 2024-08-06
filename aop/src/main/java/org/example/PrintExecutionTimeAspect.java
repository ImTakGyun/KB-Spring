package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import java.lang.annotation.Target;

@Component
@Target()
public class PrintExecutionTimeAspect {
    @Around("@annotation(PrintExecutionAspect")
    public Object pringExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();

        var object = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        System.out.println("executed " + joinPoint.toShortString() + "in" + executionTime);
        return object;
    }
}

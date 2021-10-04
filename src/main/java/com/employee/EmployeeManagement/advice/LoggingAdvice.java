package com.employee.EmployeeManagement.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {


    @Before("execution(public * com.employee.EmployeeManagement.*.*.*(*))")
    public void beforeLog() {
    log.info("Hi started before ");
    }

    @AfterReturning("execution(public * com.employee.EmployeeManagement.*.*.*(*)))")
    public void logAfter(){
        log.info("After completing Method");
    }

    @AfterThrowing("execution(public * com.employee.EmployeeManagement.*.*.*(*)))")
    public void logAfterException(){
        log.info("Issue :    ");
    }
}

package com.employee.EmployeeManagement.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Scope("prototype")
public class ProtoTypeTestService {

    private String dateTime = LocalDateTime.now().toString();

    public String getMethod(){
        return dateTime;
    }

}

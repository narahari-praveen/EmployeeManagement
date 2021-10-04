package com.employee.EmployeeManagement.controller;

import com.employee.EmployeeManagement.model.EmployeeModel;
import com.employee.EmployeeManagement.service.EmployeeService;
import com.employee.EmployeeManagement.service.ProtoTypeTestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
@AllArgsConstructor
public class EmployeeController {

    @Lookup
    ProtoTypeTestService getProtoTypeTestService(){
        return null;
    };

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployees(@PathVariable Integer id){
        EmployeeModel emp = employeeService.getEmplyee(id);
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/employees")
    public ResponseEntity getAllEmployees(){
        List<EmployeeModel> emp = employeeService.getAllEmplyees();
        int i = 5/0;
        return ResponseEntity.ok(emp);
    }

    @PostMapping("/employees")
    public ResponseEntity addEmployee(@RequestBody EmployeeModel employeeModel){
        EmployeeModel emp = employeeService.addEmplyee(employeeModel);
        return ResponseEntity.ok(emp);
    }

    @PutMapping("/employees")
    public ResponseEntity updateEmployee(@RequestBody EmployeeModel employeeModel){
        EmployeeModel emp = employeeService.updateEmployee(employeeModel);
        return ResponseEntity.ok(emp);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployees(@PathVariable Integer id){
        employeeService.deleteEmployees(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/testProtoType")
    public ResponseEntity testProtoType(){
        String dateTime = getProtoTypeTestService().getMethod();
        String dateTime2 = getProtoTypeTestService().getMethod();
        String[] arr = {dateTime,dateTime2};
        return ResponseEntity.ok(arr);
    }





}

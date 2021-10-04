package com.employee.EmployeeManagement.service;

import com.employee.EmployeeManagement.entity.Employee;
import com.employee.EmployeeManagement.model.EmployeeModel;
import com.employee.EmployeeManagement.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeModel getEmplyee(int id){
       Employee employee = employeeRepository.getById(id);
       return Employee.of(employee);
    }

    public EmployeeModel addEmplyee(EmployeeModel employeeModel){
        Employee employee = Employee.make(employeeModel);
        employeeRepository.save(employee);
        return Employee.of(employee);
    }

    public List<EmployeeModel> getAllEmplyees(){
        List<Employee> employee = employeeRepository.findAll();
        return employee.stream().map( e -> Employee.of(e)).collect(Collectors.toList());
    }

    public EmployeeModel updateEmployee(EmployeeModel employeeModel) {
        Employee employee = Employee.make(employeeModel);
        employeeRepository.save(employee);
        return Employee.of(employee);
    }

    public void deleteEmployees(Integer id) {
        employeeRepository.deleteById(id);
    }


}

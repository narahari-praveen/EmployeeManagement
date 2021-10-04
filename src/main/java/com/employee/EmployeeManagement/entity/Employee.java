package com.employee.EmployeeManagement.entity;

import com.employee.EmployeeManagement.model.EmployeeModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employee",schema = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @SequenceGenerator(sequenceName = "employee_id_seq", name = "EmployeeSeq",schema = "employees" ,initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "EmployeeSeq")
    private int id;

    private String firstName;

    private String lastName;

    private String emailId;

    private long mobileNumber;

    private double salary;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employee")
    private List<Address> addresses = new ArrayList<>();


    public static EmployeeModel of(Employee employee){
        EmployeeModel employeeModel = EmployeeModel.builder().build();
        BeanUtils.copyProperties(employee,employeeModel);
        return employeeModel;
    }

    public static Employee make(EmployeeModel employeeModel){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeModel,employee);
        employee.getAddresses().add(Address.of(employeeModel.getCurrentAddress(),"Current",employee));
        employee.getAddresses().add(Address.of(employeeModel.getPermanentAddress(),"Permanent",employee));
        return employee;
    }

}

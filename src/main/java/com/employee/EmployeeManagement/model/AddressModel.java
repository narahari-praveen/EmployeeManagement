package com.employee.EmployeeManagement.model;

import com.employee.EmployeeManagement.util.State;
import lombok.Data;

@Data
public class AddressModel {

    private String streetName;

    private String city;

    private int zipCode;

    private String state;

}

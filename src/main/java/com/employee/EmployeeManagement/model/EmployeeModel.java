package com.employee.EmployeeManagement.model;


import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class EmployeeModel {


    private int id;

    private String firstName;

    private String lastName;

    private String emailId;

    private long mobileNumber;

    private double salary;

    private AddressModel currentAddress;

    private AddressModel permanentAddress;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeModel)) return false;
        EmployeeModel employeeModel = (EmployeeModel) o;
        return getId() == employeeModel.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

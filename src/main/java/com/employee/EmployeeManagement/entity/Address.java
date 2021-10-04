package com.employee.EmployeeManagement.entity;

import com.employee.EmployeeManagement.model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="employee_address",schema = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {

    @Id
    @SequenceGenerator(name = "address_generator", sequenceName = "employee_address_address_id_seq" ,schema = "employees" ,initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_generator")
    private int addressId;

    private String addressType;

    private String streetName;

    private String city;

    private int zipCode;

    private String state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public static Address of(AddressModel addressModel,String type,Employee employee){
        Address address = Address.builder()
                .addressType(type)
                .streetName(addressModel.getStreetName())
                .city(addressModel.getCity())
                .zipCode(addressModel.getZipCode())
                .state(addressModel.getState())
                .employee(employee)
                .build();

        return address;
    }
}

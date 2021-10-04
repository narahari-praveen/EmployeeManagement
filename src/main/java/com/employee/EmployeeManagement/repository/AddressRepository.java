package com.employee.EmployeeManagement.repository;

import com.employee.EmployeeManagement.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}

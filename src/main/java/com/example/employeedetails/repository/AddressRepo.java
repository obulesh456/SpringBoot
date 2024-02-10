package com.example.employeedetails.repository;

import com.example.employeedetails.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}

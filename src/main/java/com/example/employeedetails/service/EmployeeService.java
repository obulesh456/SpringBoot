package com.example.employeedetails.service;

import com.example.employeedetails.model.Employee;
import com.example.employeedetails.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }
    public void deleteEmployee(Integer id){
         employeeRepo.deleteById(id);
    }
}

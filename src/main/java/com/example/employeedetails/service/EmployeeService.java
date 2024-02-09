package com.example.employeedetails.service;

import com.example.employeedetails.model.Employee;
import com.example.employeedetails.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Employee getEmployeeById(Integer id){
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }
}

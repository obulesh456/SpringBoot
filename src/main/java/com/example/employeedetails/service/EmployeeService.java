package com.example.employeedetails.service;

import com.example.employeedetails.model.Employee;
import com.example.employeedetails.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);
    }

    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    public Employee updateEmployeeById(Integer id, Employee employee) {
        Optional<Employee> employee1 = employeeRepo.findById(id);

        if (employee1.isPresent()) {
            Employee originalEmployee = employee1.get();

            if (Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName())) {
                originalEmployee.setName(employee.getName());
            }
            if (Objects.nonNull(employee.getSalary()) && employee.getSalary() != 0) {
                originalEmployee.setSalary(employee.getSalary());
            }
            return employeeRepo.save(originalEmployee);
        }
        return null;

    }
}

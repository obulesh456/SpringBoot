package com.example.employeedetails.controller;

import com.example.employeedetails.model.Employee;
import com.example.employeedetails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/createEmployee")
    private Employee createEmployee(@RequestBody Employee emp){
        return employeeService.saveEmployee(emp);
    }
    @GetMapping("/getEmployees")
    private List<Employee> findEmployees(){
        return employeeService.getEmployees();
    }
    @DeleteMapping("/employee/{id}")
    private void deleteEmployee(@PathVariable("id") Integer id){
         employeeService.deleteEmployee(id);
    }
    @GetMapping("/employee/{id}")
    private Employee findEmployeeById(@PathVariable("id") Integer id){
        return employeeService.getEmployeeById(id);
    }
}

package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Employee;
import com.tka.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController 
{

    @Autowired
     EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) 
    {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/getEmployeeByID/{id}")
    public Employee getEmployeeByID(@PathVariable Long id) 
    {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/performance/{id}/{rating}")
    public String updatePerformance(@PathVariable Long id, @PathVariable int rating) 
    {
        return employeeService.updatePerformance(id, rating);
    }

    @PutMapping("/disciplinary-action/{id}")
    public String markDisciplinaryAction(@PathVariable Long id)
    {
        return employeeService.markDisciplinaryAction(id);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() 
    {
        return employeeService.getAllEmployees();
    }
}


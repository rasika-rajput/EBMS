package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.BonusDao;
import com.tka.dao.EmployeeDao;
import com.tka.entity.Employee;

@Service
public class EmployeeService 
{

    @Autowired
     EmployeeDao employeeDao;
    
    @Autowired
     BonusDao bonusDao;

    public String addEmployee(Employee employee) 
	{
		 return employeeDao.addEmployee(employee);
	}
    
    public Employee getEmployeeById(Long id) 
    {
        return employeeDao.getEmployeeById(id);
    }

    public String updatePerformance(Long id, int newRating) 
    {
    	return employeeDao.updatePerformance(id, newRating);
    }

    public String markDisciplinaryAction(Long id) 
    {
        return employeeDao.markDisciplinaryAction(id);
    }

    public List<Employee> getAllEmployees() 
    {
        return employeeDao.getAllEmployees();
    }

	
}


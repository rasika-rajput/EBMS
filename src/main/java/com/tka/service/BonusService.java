package com.tka.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.BonusDao;
import com.tka.dao.EmployeeDao;
import com.tka.entity.Bonus;
import com.tka.entity.Employee;

@Service
public class BonusService 
{
    @Autowired
     EmployeeDao employeeDao;
    @Autowired
     BonusDao bonusDao;

    public String calculateTotalBonus(Long employeeId) 
    {
        Employee employee = employeeDao.getEmployeeById(employeeId);
        double bonus = calculateBonus(employee);
        double tax = calculateTax(employee.getSalary(), bonus);
        
        Bonus bonus1 = new Bonus();
        bonus1.setEmployeeId(employeeId);
        bonus1.setBonusAmount(bonus);
        bonus1.setBonusDate(Date.valueOf(LocalDate.now()));
        bonus1.setTaxDeducted(tax);
        return bonusDao.addBonus(bonus1);
    }

    private double calculateBonus(Employee employee) 
    {
        double salary = employee.getSalary();
        double bonusPercentage = 0;

        if (employee.getExperienceInYears() > 5) 
        {
        	bonusPercentage = bonusPercentage + 20;
        } 
        else if (employee.getExperienceInYears() >= 3 && employee.getExperienceInYears() <= 5) 
        {
        	bonusPercentage = bonusPercentage + 10;
        } 
        else if (employee.getExperienceInYears() < 3 && employee.getExperienceInYears() >= 1) 
        {
        	bonusPercentage = bonusPercentage + 5;
        }

        if (employee.getDesignation().equalsIgnoreCase("Manager")) 
        {
        	bonusPercentage = bonusPercentage + 5;
        } 
        else if (employee.getDesignation().equalsIgnoreCase("Executive"))
        {
        	bonusPercentage = bonusPercentage + 2;
        }

        if (employee.getPerformanceRating() == 5) 
        {
        	bonusPercentage = bonusPercentage + 15;
        } 
        else if (employee.getPerformanceRating() >= 3 && employee.getPerformanceRating() <= 4) 
        {
        	bonusPercentage = bonusPercentage + 10;
        }

        double calculatedBonus = salary * bonusPercentage / 100;
        
        
        if (calculatedBonus > 100000) 
        {
            return 100000;
        } 
        else 
        {
            return calculatedBonus;
        }
    }

    private double calculateTax(double salary, double bonus) 
    {
        double totalSalaryWithBonus = salary + bonus;
        double tax = 0;
        
        if (totalSalaryWithBonus > 100000) 
        {
            tax = tax + (bonus * 0.15);
        }
        if (salary > 200000)
        {
            tax = tax + (bonus * 0.20);
        }
        
        return tax;
    }

	public List<Bonus> getBonusByEmployeeId(Long employeeId) 
	{
		return bonusDao.getBonusByEmployeeId(employeeId);
	}
	
    public List<Bonus> bonusReport(Date startDate, Date endDate) 
    {
    	return bonusDao.bonusReport(startDate, endDate);
    }
}


package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Employee;

@Repository
public class EmployeeDao 
{

    @Autowired
     SessionFactory sessionFactory;
    
    public String addEmployee(Employee employee) 
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
		return "Employee Added Successfully...!!!";
    }
    
    public Employee getEmployeeById(Long id) 
    {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    public String updateEmployee(Employee employee) 
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();
        return "Employee Updated Successfully...!!!";
    }
    
    public List<Employee> getAllEmployees() 
    {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Employee.class); 
        List<Employee> employees = criteria.list();
        session.close();
        return employees;
    }
    
    public String updatePerformance(Long id, int newRating)
    {
      Employee employee = getEmployeeById(id);
      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      employee.setPerformanceRating(newRating);
      session.update(employee);
      transaction.commit();
      session.close();
      return "Employee's Performance Updated Successfully...!!!";
    }

	public String markDisciplinaryAction(Long id) 
	{
		Employee employee = getEmployeeById(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        employee.setDisciplinaryAction(true);
        session.update(employee);
        transaction.commit();
        session.close();
        return "Employee's Disciplinary Action Marked Successfully...!!!";
	}
}


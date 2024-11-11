package com.tka.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Bonus;

@Repository
public class BonusDao {

    @Autowired
     SessionFactory sessionFactory;

    public String addBonus(Bonus bonus) 
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bonus);
        transaction.commit();
        session.close();
        
        return "Bonus Added Successfully...";
    }

    public List<Bonus> getBonusByEmployeeId(Long employeeId) 
    {
        Session session = sessionFactory.openSession();
        
        Criteria criteria = session.createCriteria(Bonus.class);
        criteria.add(Restrictions.eq("employeeId", employeeId));
        
        List<Bonus> bonuses = criteria.list();
        session.close();
        
        return bonuses;
    }
    
    public List<Bonus> bonusReport(Date startDate, Date endDate) 
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Bonus.class);
		criteria.add(Restrictions.between("bonusDate", startDate, endDate));
		List<Bonus> report = criteria.list();
		
		return report;
	}
}


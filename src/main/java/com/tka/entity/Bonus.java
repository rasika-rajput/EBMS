package com.tka.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId; 
    private double bonusAmount;
    private Date bonusDate;
    private double taxDeducted;
	public Bonus() {
		super();
	}
	public Bonus(Long id, Long employeeId, double bonusAmount, Date bonusDate, double taxDeducted) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.bonusAmount = bonusAmount;
		this.bonusDate = bonusDate;
		this.taxDeducted = taxDeducted;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public double getBonusAmount() {
		return bonusAmount;
	}
	public void setBonusAmount(double bonusAmount) {
		this.bonusAmount = bonusAmount;
	}
	public Date getBonusDate() {
		return bonusDate;
	}
	public void setBonusDate(Date date) {
		this.bonusDate = date;
	}
	public double getTaxDeducted() {
		return taxDeducted;
	}
	public void setTaxDeducted(double taxDeducted) {
		this.taxDeducted = taxDeducted;
	}

    
}

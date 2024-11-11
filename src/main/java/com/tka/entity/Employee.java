package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;
    private double salary;
    private int experienceInYears;
    private int performanceRating; 
    private boolean probation; 
    private boolean disciplinaryAction;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Long id, String name, String designation, double salary, int experienceInYears,
			int performanceRating, boolean probation, boolean disciplinaryAction) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.experienceInYears = experienceInYears;
		this.performanceRating = performanceRating;
		this.probation = probation;
		this.disciplinaryAction = disciplinaryAction;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getExperienceInYears() {
		return experienceInYears;
	}
	public void setExperienceInYears(int experienceInYears) {
		this.experienceInYears = experienceInYears;
	}
	public int getPerformanceRating() {
		return performanceRating;
	}
	public void setPerformanceRating(int performanceRating) {
		this.performanceRating = performanceRating;
	}
	public boolean isProbation() {
		return probation;
	}
	public void setProbation(boolean probation) {
		this.probation = probation;
	}
	public boolean isDisciplinaryAction() {
		return disciplinaryAction;
	}
	public void setDisciplinaryAction(boolean disciplinaryAction) {
		this.disciplinaryAction = disciplinaryAction;
	} 

    
    
}

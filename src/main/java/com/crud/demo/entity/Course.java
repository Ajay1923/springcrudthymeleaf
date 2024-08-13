package com.crud.demo.entity;

import jakarta.persistence.Column;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String name;
	@Column
	String tech;
	@Column
	int noOfDays;
	
	
	public Course() {
		super();
		
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTech() {
		return tech;
	}


	public void setTech(String tech) {
		this.tech = tech;
	}


	public int getNoOfDays() {
		return noOfDays;
	}


	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}



	
	
}

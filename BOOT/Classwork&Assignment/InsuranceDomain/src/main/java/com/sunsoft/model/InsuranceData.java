package com.sunsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurancedata")
public class InsuranceData {
	@Id
	@Column
	int id;
	@Column
	String name;
	@Column 
	int tenure;
	@Column 
	int amount;

	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getTenure() {
		return this.tenure;
	}
	
	public int getAmount() {
		return this.amount;
	}

}

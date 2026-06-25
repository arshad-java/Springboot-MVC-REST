package com.mvc;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	int id=101;
	String name="Raj";
	
	//product
	int qyt=2;
	double price=4000;
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
	public int getQyt() {
		return qyt;
	}
	public void setQyt(int qyt) {
		this.qyt = qyt;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Customer()
	{
		
	}
	

}

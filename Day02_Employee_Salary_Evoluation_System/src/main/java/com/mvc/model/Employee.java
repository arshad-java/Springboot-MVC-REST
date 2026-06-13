package com.mvc.model;

import lombok.Data;

@Data
public class Employee {
	
	Integer empId;
	String name;
	Double basic;
	Double hra;
	Double da;
	Double grossSalary;

}

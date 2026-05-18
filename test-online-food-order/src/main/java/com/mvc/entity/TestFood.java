package com.mvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestFood {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(length = 20)
	String name;
	@Column(length = 20)
	String itemName;
	Integer quantity;
	Double price;
	//Double totalAmount;
	
	

}

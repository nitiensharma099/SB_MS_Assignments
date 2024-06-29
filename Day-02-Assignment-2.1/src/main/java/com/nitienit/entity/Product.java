package com.nitienit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private double price;
	private Integer quantity;
	private String description;
	private boolean isStock;
	private String barCode;
	
	//Many to one 
	@ManyToOne
	@JoinColumn(name="cat_id",nullable = false)
	private Category category;
}

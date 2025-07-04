package com.sunbeam.entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = "myCategory")
@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = {"product_name", "category_id"}))
public class Product extends BaseEntity{
	
	@Column(name = "product_name",length = 20 ,unique = true)
	private String name;
	@Column(name = "product_description",length = 300)
	private String productDesc;
	@Column(name = "manufacture_date")
	private LocalDate manufactureDate;
	private double price;
	@Column(name = "available_quantity")
	private int availableQuantity;
	@JoinColumn(name = "category_id")
	@ManyToOne
	private Category myCategory;
	
	
	
	
	public Product(String name, String productDesc, LocalDate manufactureDate, double price, int availableQuantity) {
		super();
		this.name = name;
		this.productDesc = productDesc;
		this.manufactureDate = manufactureDate;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}
//
//	public Product() {
//		
//	}
//	
//	public Product(String name, double price) {	
//		this.name = name;
//		this.price = price;
//	}
	
	
	
}

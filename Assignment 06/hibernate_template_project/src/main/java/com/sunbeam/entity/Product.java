package com.sunbeam.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * 
Typical product details -
product id : Long (auto increment)
name : string (unique) : varchar(20)
product description : string : varchar(300)
manufacture date : LocalDate
price : double
available quantity : int
category : enum (STATIONARY,SHOES,GRAINS,OIL...)

 * */

@Entity
@Table(name="products")

public class Product {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	@Column(length = 20,unique = true)
	private String name;
	
	@Column(name="product_description",length = 300)
	private String productDescription;
	
	@Column(name="manufacture_date")
	private LocalDate manufactureDate;
	
	private double price;
	
	@Column(name="available_quantity")
	private int availableQuantity;
	
	@Enumerated(EnumType.STRING)
	private Category category;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, String productDescription, LocalDate manufactureDate, double price,
			int availableQuantity, Category category) {
		
		this.name = name;
		this.productDescription = productDescription;
		this.manufactureDate = manufactureDate;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.category = category;
	}
	

	public Product(Long productId, String name, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", productDescription=" + productDescription
				+ ", manufactureDate=" + manufactureDate + ", price=" + price + ", availableQuantity="
				+ availableQuantity + ", category=" + category + "]";
	}
	
	
	
	
	
	
}

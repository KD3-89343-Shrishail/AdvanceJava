package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = "products")
@Table(name = "categories")
public class Category extends BaseEntity{
	@Column(name = "category_name",length = 50 ,unique = true)
	private String name;
	@Column(name = "category_description", length = 255)
	private String description;
	@OneToMany(mappedBy = "myCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products = new ArrayList<>();
	
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		
	}
	
	public void AddProduct(Product product) {
		this.products.add(product);
		product.setMyCategory(this);
	}
	
	public void deleteProduct(Product product) {
		this.products.remove(product);
		product.setMyCategory(null);
	}
}


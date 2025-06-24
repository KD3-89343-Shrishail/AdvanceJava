package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.entity.Category;
import com.sunbeam.entity.Product;

public interface ProductDao {

	String addProduct(Product product);
	Product getProductDetailsById(Long productId);
	List<Product> getProductDetailsByDateAndCategory(LocalDate date,Category category);
	String changeProductPrice(String name,double newPrice);
	
	


	
}

package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductDao {
	String addProductsToCategories(Long restaurantId, List<Product> products);
}

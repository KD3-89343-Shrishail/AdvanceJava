package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface ProductDao extends JpaRepository<Product,Long> {
//	String addProductsToCategories(Long restaurantId, List<Product> products);
//	List<Product> findAllProducts(Long categoryId);
//	List<Product> (Long categoryId);
}

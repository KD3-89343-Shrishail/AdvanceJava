package com.sunbeam.service;

import com.sunbeam.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts(Long categoryId);
}

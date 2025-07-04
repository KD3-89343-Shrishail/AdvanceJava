package com.sunbeam.service;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
//    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAllProducts(Long categoryId) {
        return productDao.findAll();
    }
}

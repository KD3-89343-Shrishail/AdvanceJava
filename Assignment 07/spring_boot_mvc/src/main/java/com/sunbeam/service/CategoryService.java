package com.sunbeam.service;

import com.sunbeam.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    String deleteDetails(Long id);
    String addCategory(Category category);
    Category getCategoryById(Long id);

    String updateRestaurant(Long id, Category transientCategory);

    Category displayCategoryDetails(Long id);
}

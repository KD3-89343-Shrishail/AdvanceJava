package com.sunbeam.dao;

import com.sunbeam.entities.Category;

public interface CategoryDao {
	String addCategory(Category newCategory);
	String deleteCategory(Long categoryId);
}

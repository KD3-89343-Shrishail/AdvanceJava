package com.sunbeam.service;

import com.sunbeam.Exceptions.CustomException;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.entities.Category;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        System.out.println("in category service method is getAllCategories "+categoryDao.findByStatusTrue());
        return categoryDao.findByStatusTrue();
    }

    @Override
    public String deleteDetails(Long id) {
        Category category = categoryDao.findById(id).orElseThrow(()-> new CustomException("Invalid Id"));
        category.setStatus(false);
        return "Category deleted successfully";
    }

    @Override
    public String addCategory(Category category) {
        category.setStatus(true);
        Category persistentCategory = categoryDao.save(category);
        return "Category added with category id "+persistentCategory.getId();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDao.findById(id).orElseThrow(() -> new CustomException("Invalid Id"));
    }

    @Override
    public String updateRestaurant(Long id, Category transientCategory) {
        Category category = getCategoryById(id);
        category.setName(transientCategory.getName());
        category.setDescription(transientCategory.getDescription());
        return "Updated restaurant successfully";
    }

    @Override
    public Category displayCategoryDetails(Long id) {
        return categoryDao.displayCategoryDetails(id);
    }


}

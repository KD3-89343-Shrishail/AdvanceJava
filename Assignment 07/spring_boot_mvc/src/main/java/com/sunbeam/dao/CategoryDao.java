package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Long> {

	@Query(value = "select c from Category c left join fetch c.products where c.id =:id")
	 Category displayCategoryDetails(Long id);

	//	List<Category>  findStatus;
	List<Category> findByStatusTrue();
}

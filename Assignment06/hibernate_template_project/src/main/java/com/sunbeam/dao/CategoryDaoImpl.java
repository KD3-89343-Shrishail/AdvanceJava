package com.sunbeam.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Category;
import com.sunbeam.utils.HibernateUtils;

public class CategoryDaoImpl implements CategoryDao {
	public String addCategory(Category newCategory) {
		String message = "adding category failed!!";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.persist(newCategory);
			tx.commit();
			message = "Category added successfully!!!";
			
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return message;	
	}

	@Override
	public String deleteCategory(Long categoryId) {
		String message = "Category not deleted!!";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Category category = session.get(Category.class, categoryId);
//			category.deleteProduct(category);
			session.remove(category);
			tx.commit();
			message = "Category deleted successfully!!!";
			
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return message;	
	}
}

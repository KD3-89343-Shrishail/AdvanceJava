package com.sunbeam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import com.sunbeam.utils.HibernateUtils;

public class ProductDaoImpl implements ProductDao{

	@Override
	public String addProductsToCategories(Long categoryId, List<Product> products) {
		String message = "adding products failed!!";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Category newCategory = session.get(Category.class, categoryId);
			products.forEach(p -> newCategory.AddProduct(p));
			tx.commit();
			message = "Products added successfully!!";
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return message;
	}

}

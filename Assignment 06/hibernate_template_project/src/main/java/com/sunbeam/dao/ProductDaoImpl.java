package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entity.Category;
import com.sunbeam.entity.Product;
import com.sunbeam.utils.HibernateUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		String message = "adding product is failed";

		Session session = HibernateUtils.getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {

			session.persist(product);

			tx.commit();
			message = "Product added successfully , " + "with generated ID " + product.getProductId();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return message;
	}

	@Override
	public Product getProductDetailsById(Long productId) {
		// TODO Auto-generated method stub
        Product product=null;
		Session session = HibernateUtils.getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
      product=session.get(Product.class, productId);
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

		return product;
	}

	@Override
	public List<Product> getProductDetailsByDateAndCategory(LocalDate date, Category category) {
		// TODO Auto-generated method stub
		
		List<Product> products = null;
		String jpql =  "select new " + "com.sunbeam.entity.Product(p.productId,p.name,p.price)"
				+ "  from Product p where p.manufactureDate<:date and category=:cat";
		
		Session session = HibernateUtils.getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class)
					.setParameter("date", date).setParameter("cat", category).getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}


		return products;
	}

	@Override
	public String changeProductPrice(String name, double newPrice) {
		// TODO Auto-generated method stub
		String mesg = "applying price failed !!!!!!!!!!";
		String jpql = "update Product p set " + "p.price=:nprice "
				+ "where p.name=:name";
		
		Session session = HibernateUtils.getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {

			int updateCount = session.createMutationQuery(jpql).setParameter("nprice", newPrice)
					.setParameter("name", name).executeUpdate();
			tx.commit();
			mesg = "applied new price  to " + updateCount + " no product";
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}


		return mesg;
	}

}

package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entity.User;
import com.sunbeam.entity.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public String registerUser(User user) {
		// TODO Auto-generated method stub

		String message = "User reg failed!!!!!!";
		Session session=HibernateUtils.getFactory().getCurrentSession();
		
		  Transaction tx = session.beginTransaction();
		  
		  try {
			  

				session.persist(user);
 
				tx.commit();
				 
				message = "User registered successfully , "
						+ "with generated ID " + user.getId();
			  
		  }catch (RuntimeException e) {
			// TODO: handle exception
			  
			  if(tx!=null) {
				  tx.rollback();
				  
				  
			  }
			  
			  throw e;
			  
		}
		
		return message;
	}

	@Override
	public User getUserDetailsById(Long userId) {
		// TODO Auto-generated method stub
		User user = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			user = session.get(User.class, userId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	
	}
	

	@Override
	public List<User> getAllUserDetails() {
		List<User> users = null;
		String jpql = "select u from User u";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public List<User> getUserDetailsByRoleAndDate(UserRole role1, LocalDate date1) {
		List<User> users = null;
		String jpql = "select u from User u where u.userRole=:role and u.dob>:date";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class)
					.setParameter("role", role1).setParameter("date", date1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public List<String> getUserLastNamesByRole(UserRole userRole) {
		List<String> lastNames = null;
		String jpql = "select u.lastName from User u where u.userRole=:role";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			lastNames = session.createQuery(jpql, String.class).setParameter("role", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		return lastNames;
	}

	@Override
	public List<User> getCompleteNameAndDobByRole(UserRole userRole) {
		List<User> users = null;
		String jpql = "select new " + "com.sunbeam.entities.User(u.firstName,u.lastName,u.dob)"
				+ "  from User u where u.userRole=:role";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("role", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		return users;
	}

	@Override
	public String changePassword(String email1, String oldPassword, String newPassword) {
		User user = null;
		String mesg = "Password updation failed!!!!!!";
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			user = session.createQuery(jpql, User.class).setParameter("em", email1).setParameter("pass", oldPassword)
					.getSingleResult();
			user.setPassword(newPassword);// modifying state of the persistent entity
			tx.commit();
			mesg = "Password updated !";
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		user.setPassword("1234567890");
		return mesg;
	}

	@Override
	public String applyDiscount(UserRole userRole, LocalDate dob, double discount) {
		String mesg = "applying discount failed !!!!!!!!!!";
		String jpql = "update User u set " + "u.subscriptionAmount=u.subscriptionAmount-:disc "
				+ "where u.userRole=:rl and u.dob < :date";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createMutationQuery(jpql).setParameter("disc", discount)
					.setParameter("rl", userRole).setParameter("date", dob).executeUpdate();
			tx.commit();
			mesg = "applied discount to " + updateCount + " no users";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to caller
			throw e;
		}
		return mesg;
	}

	public String deleteUserDetailsById(Long userId) {
		User user=null;
		String mesg = "deletion failed";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			user=session.get(User.class, userId);
			if (user != null)
			{
				session.remove(user);
				mesg="user details deleted....";
			}
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}
		return mesg;
	}
}

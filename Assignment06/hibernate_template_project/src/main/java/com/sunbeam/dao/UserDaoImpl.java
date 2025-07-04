package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.User;
import com.sunbeam.entities.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public String registerUser(User user) {
		String message = "User registration failed";
		
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			session.persist(user);
			tx.commit();
			message = "User registered succesfully, "
					+ "with generated ID "+user.getId();
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return message;
	}

	@Override
	public User getUserDetailsById(Long id) {
		User user = null;
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			user = session.get(User.class, id);
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return user;
		
	}

	@Override
	public List<User> getAllUserDetails() {
		List<User> users = null;
		String jpql = "select u from User u";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql ,User.class).getResultList();
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return users;	
	}

	@Override
	public List<User> getUserDetailsByRoleAndDate(UserRole role1, LocalDate date1) {
		List<User> users = null;
		String jpql = "select u from User u where u.userRole =:role and dob =:date";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class)
					.setParameter("role", role1)
					.setParameter("date", date1)
					.getResultList();
		}catch(RuntimeException e){
			if(tx != null) {
				tx.rollback();
			}		
			throw e;
		}
		return users;
	}

	@Override
	public List<String> getUserLastNameByRole(UserRole role1) {
		List<String> lastName = null;
		String jpql = "select u.lastName from User u where u.userRole=:role";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			lastName = session.createQuery(jpql, String.class)
					.setParameter("role", role1)
					.getResultList();
			
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}	
		return lastName;
	}

	@Override
	public List<User> getCompleteNameAndDobByRole(UserRole valueOf) {
		List<User> users = null;
		String jpql = "select new com.sunbeam.entities.User(u.firstName, u.lastName, u.dob)"
				+ "from User u where u.userRole =:role";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class)
					.setParameter("role", valueOf)
					.getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return users;
	}

	@Override
	public String changePassword(String email, String oldPassword, String newPassword) {
		User u = null;
		String message = "Password not changed!";
		
		String jpql = "select u from User u where email =:email AND password =:pass";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			u = session.createQuery(jpql, User.class)
				.setParameter("email", email)
				.setParameter("pass", oldPassword)
				.getSingleResult();
			u.setPassword(newPassword);
			tx.commit();
			message = "Password successfully updated!!";
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return message;
	}

	@Override
	public String applyDiscount(UserRole userRole, LocalDate dob, double discount) {
		String message = "Discount was not updated";
		String jpql = "update User u set u.subscriptionAmount = u.subscriptionAmount - :dis "
				+ "where u.userRole =:role and u.dob < :date";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createMutationQuery(jpql)
					.setParameter("dis", discount)
					.setParameter("role", userRole)
					.setParameter("date", dob)
					.executeUpdate();
			tx.commit();
			message = "Applied discount to "+updateCount+ " users";
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return message;
	}

	@Override
	public String deleteUserDetailsById(Long userId) {
		String message = "Deletion failed!!";
		User u = null;
		
		Session session = HibernateUtils.getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			u = session.get(User.class, userId);
			if(u != null) {
				session.remove(u);
			}
			tx.commit();
			message = "user details deleted";
		}catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return message;
	}
}

package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.utils.HibernateUtils;

public class DisplayAllUserDetails {
	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtils.getFactory()){
			UserDao userDao = new UserDaoImpl();
			
//			System.out.println();
			userDao.getAllUserDetails().forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

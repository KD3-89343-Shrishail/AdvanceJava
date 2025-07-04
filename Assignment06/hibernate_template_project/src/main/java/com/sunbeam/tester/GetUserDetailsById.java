package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.User;
import com.sunbeam.utils.HibernateUtils;

public class GetUserDetailsById {
	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtils.getFactory();Scanner sc = new Scanner(System.in)){
			
			UserDao userDao = new UserDaoImpl();
			System.out.println("Enter user id");
			long input = Long.valueOf(sc.nextLine());
			User user = userDao.getUserDetailsById(input);
			System.out.println();
			System.out.println(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

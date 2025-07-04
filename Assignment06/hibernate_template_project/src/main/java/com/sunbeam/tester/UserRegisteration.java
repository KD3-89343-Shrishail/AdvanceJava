package com.sunbeam.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.User;
import com.sunbeam.entities.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class UserRegisteration {
	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtils.getFactory()){
			Scanner sc = new Scanner(System.in);
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter details:  firstName, lastName, email, password, subscriptionAmount, \n"
					+ "			userRole, dob");
			
			User newUser = new User(sc.next(),sc.next() , sc.next(), sc.next(), sc.nextDouble(), UserRole.valueOf(sc.next().toUpperCase()), 
					LocalDate.parse(sc.next()));
			System.out.println(dao.registerUser(newUser));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

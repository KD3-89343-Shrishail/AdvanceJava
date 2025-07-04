package com.sunbeam.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class ApplyDiscount {
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// 1. create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter user role , dob n discount amount");
			// 2. call dao's method
			System.out.println(dao.applyDiscount
			(UserRole.valueOf(sc.next().toUpperCase())
					,LocalDate.parse(sc.next()),sc.nextDouble()));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

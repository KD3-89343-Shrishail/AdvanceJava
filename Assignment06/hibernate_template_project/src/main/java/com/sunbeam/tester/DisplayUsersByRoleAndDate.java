package com.sunbeam.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class DisplayUsersByRoleAndDate {
	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtils.getFactory(); Scanner sc = new Scanner(System.in)){
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter user role n date(dob) ");
			dao.getUserDetailsByRoleAndDate(UserRole.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()))
			.forEach(System.out::println);
		}
	}
}

package com.sunbeam.tester;

import java.util.Scanner;


import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entity.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class DisplayLastNamesByRole {

	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtils.getFactory();
				Scanner sc=new Scanner(System.in)) {
			//1. create dao instance
			UserDao dao=new UserDaoImpl();			
			System.out.println("Enter user role");
			//2. call dao's method
			dao.getUserLastNamesByRole(
					UserRole.valueOf(sc.next().toUpperCase()))					
			.forEach(nm ->System.out.println(nm));
		} /*
		   JVM calls - sf.close() => DBCP is closed 
		*/
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

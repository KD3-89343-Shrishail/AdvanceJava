package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.utils.HibernateUtils;

public class DeleteUserDetailsById {
	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtils.getFactory();
				Scanner sc=new Scanner(System.in)) {
			
			UserDaoImpl dao=new UserDaoImpl();
			
			System.out.println("Enter user id to delete(hard) details");
			
			System.out.println(dao.deleteUserDetailsById(sc.nextLong()));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

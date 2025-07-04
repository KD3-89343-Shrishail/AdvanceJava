package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.utils.HibernateUtils;

public class ChangePassword {
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory(); Scanner sc = new Scanner(System.in)) {
			
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter user email, old password, new password");
			
			System.out.println(dao.changePassword(sc.next(),
					sc.next(), sc.next()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

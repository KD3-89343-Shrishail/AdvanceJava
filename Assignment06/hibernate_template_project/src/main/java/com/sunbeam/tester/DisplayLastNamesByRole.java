package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class DisplayLastNamesByRole {
	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtils.getFactory();
				Scanner sc=new Scanner(System.in)){
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter User role");
			dao.getUserLastNameByRole(UserRole.valueOf(sc.next().toUpperCase())).forEach(System.out::println);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

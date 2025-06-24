package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.utils.HibernateUtils;

public class ChangeProductPrice {

	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// 1. create dao instance
			ProductDao dao=new ProductDaoImpl();
			
			System.out.println("Enter Product Name, new price");
			// 2. call dao's method
			System.out.println(dao.changeProductPrice(sc.next(),sc.nextDouble()));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

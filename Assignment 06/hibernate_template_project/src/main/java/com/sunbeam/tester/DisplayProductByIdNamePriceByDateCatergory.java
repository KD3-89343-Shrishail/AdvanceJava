package com.sunbeam.tester;

import java.time.LocalDate;
import java.util.Locale.Category;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entity.Product;
import com.sunbeam.entity.UserRole;
import com.sunbeam.utils.HibernateUtils;

public class DisplayProductByIdNamePriceByDateCatergory {

	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtils.getFactory();
				Scanner sc=new Scanner(System.in)) {
			//1. create dao instance
			ProductDao dao=new ProductDaoImpl();
			
			System.out.println("Enter Product details -Manifaturing date And catogory ");
			//2. create Product 

			
		
			dao.getProductDetailsByDateAndCategory( LocalDate.parse(sc.next()),com.sunbeam.entity.Category.valueOf(sc.next().toUpperCase())).forEach(
					product -> 
					System.out.println(product.getProductId()+"   "+product.getName()+"   "+product.getPrice()));
	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

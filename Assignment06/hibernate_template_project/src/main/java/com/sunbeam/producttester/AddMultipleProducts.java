package com.sunbeam.producttester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Product;
import com.sunbeam.utils.HibernateUtils;

public class AddMultipleProducts {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				SessionFactory sf = HibernateUtils.getFactory()) {
			
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter Category id ");
			Long categoryId = Long.valueOf(sc.nextLine());
			List<Product> products = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				System.out.println("Enter Product details, In similar order");
				System.out.println("Name, description, manufacture date(In YYYY-MM-DD), price(Double), "
						+ "available Quantity");
				
				String name = sc.nextLine();
				String description = sc.nextLine();
				LocalDate manufactureDate = LocalDate.parse(sc.nextLine());
				double price = Double.valueOf(sc.nextLine());
				int availableQuantity = Integer.valueOf(sc.nextLine());
				
				Product newProduct = new Product(name, description, manufactureDate, price, availableQuantity);
				products.add(newProduct);
				
			}
			System.out.println(dao.addProductsToCategories(categoryId, products));
			
			
		}
	}
}

package com.sunbeam.producttester;
import static com.sunbeam.utils.HibernateUtils.getFactory;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.CategoryDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.utils.HibernateUtils;

public class AddNewProduct {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf= getFactory()){
			CategoryDao dao = new CategoryDaoImpl();
			Category newCategory = new Category(sc.nextLine(), sc.nextLine());
			System.out.println(dao.addCategory(newCategory));
		}
	}
}

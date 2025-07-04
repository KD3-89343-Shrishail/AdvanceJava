package com.sunbeam.tester;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import com.sunbeam.utils.HibernateUtils;

public class TestHibernate {
	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtils.getFactory() ){
			System.out.println("Hibernate is up and running");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

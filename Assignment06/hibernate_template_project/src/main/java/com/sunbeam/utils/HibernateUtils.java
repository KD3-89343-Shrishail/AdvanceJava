package com.sunbeam.utils;

import org.hibernate.*;

import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("in static init block");
		factory = new Configuration()
				.configure()
				.buildSessionFactory();
	}
	
	public static SessionFactory getFactory(){
		return factory;
	} 
	
}

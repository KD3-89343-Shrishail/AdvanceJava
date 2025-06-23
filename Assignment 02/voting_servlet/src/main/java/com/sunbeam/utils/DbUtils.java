package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjavajdbc";
	private static final String DB_USER = "KD3-89222-sumit";
	private static final String DB_PASSWD = "manager";
	
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
		return con;
	}

}

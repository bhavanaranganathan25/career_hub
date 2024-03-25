package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
private static Connection conn;
	
	public static Connection getDBConn() {
	 String usernameDb="root";
	 String passwordDb="";
	 String urlDb="jdbc:mysql://localhost:3306/careerhub";
	 String driverName="com.mysql.jdbc.Driver"; 

		try {
			Class.forName(driverName);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver could not be loaded");
			e.printStackTrace();
		} 
		
		
		try {
			conn = DriverManager.getConnection(urlDb, usernameDb, passwordDb);
		} catch (SQLException e) {
			System.out.println("Connection could not be established");
			e.printStackTrace();
		}
		
		return conn; 
	}
	
	public static void dbClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

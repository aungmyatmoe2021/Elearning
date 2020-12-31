package com.elearning.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class is Founded");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("Class Error is "+e.getMessage());
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning_db", "root", "root1234");
			System.out.println("Connection Successful");
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println("SQL Error is "+e.getMessage());
		}
		
		return con;
	}
}

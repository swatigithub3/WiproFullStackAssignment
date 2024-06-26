package com.day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/wipro";
		String USERNAME = "root";
		String PASSWORD = "rps@2345";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, USERNAME, PASSWORD);
			System.out.println("Connected to the database: " + connection);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}

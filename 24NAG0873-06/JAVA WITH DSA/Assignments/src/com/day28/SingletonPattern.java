package com.day28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonPattern {
	private static SingletonPattern instance;
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/wipro";
	private String username = "root";
	private String password = "rps@2345";
	private SingletonPattern() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error connecting to the database", e);
		}
	}
	public static SingletonPattern getInstance() {
		if(instance == null) {
			synchronized(SingletonPattern.class) {
				if(instance == null) {
					instance = new SingletonPattern();
				}
			}
		}
		return instance;
	}
	public Connection getConnection() {
		return connection;
	}

}

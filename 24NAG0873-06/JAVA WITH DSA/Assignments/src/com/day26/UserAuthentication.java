package com.day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserAuthentication {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/wipro";
	static final String USERNAME = "root";
	static final String PASSWORD = "rps@2345";
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL,  USERNAME, PASSWORD);
			System.out.println("Connected to the database: " + connection);
			createTable(connection);
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter User ID: ");
			String userID = sc.nextLine();
			System.out.print("Enter Password:");
			String password = sc.nextLine();
			if(authenticateUser(connection, userID, hashPassword(password))) {
				System.out.println("Access Granted");
			} else {
				System.out.println("Access Denied");
			}
			sc.close();
		} catch(SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	private static void createTable(Connection connection) throws SQLException{
		String createTableSQL = "CREATE TABLE IF NOT EXISTS User("+ "UserID VARCHAR(50) NOT NULL, " + "Password VARCHAR(255) NOT NULL, " + " PRIMARY KEY(UserID))";
		PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL);
		preparedStatement.execute();
		System.out.println("User table created.");
	}
	private static boolean authenticateUser(Connection connection, String userID, String hashedPassword) throws SQLException{
		String selectSQL = "SELECT * FROM User WHERE UserID= ? AND Password= ?";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setString(1, userID);
		preparedStatement.setString(2, hashedPassword);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	private static String hashPassword(String password) throws NoSuchAlgorithmException{
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		byte[] hashedBytes = messageDigest.digest(password.getBytes());
		StringBuilder stringBuilder = new StringBuilder();
		for(byte b : hashedBytes) {
			stringBuilder.append(String.format("%02x", b));
		}
		return stringBuilder.toString();
	}

}

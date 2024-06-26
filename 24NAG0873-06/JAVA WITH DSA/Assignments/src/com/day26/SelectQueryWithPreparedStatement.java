package com.day26;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SelectQueryWithPreparedStatement {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/wipro";
	static final String USERNAME = "root";
	static final String PASSWORD = "rps@2345";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			conn = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD );
			String sql = "SELECT * FROM users WHERE username = ?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "Sthiti");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String username = resultSet.getString("username");
				String email = resultSet.getString("email");
				System.out.println("Username: " + username + ", Email: " + email);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!= null) {
					resultSet.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

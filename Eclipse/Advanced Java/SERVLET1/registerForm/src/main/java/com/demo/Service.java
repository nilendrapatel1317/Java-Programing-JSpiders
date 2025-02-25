package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;

public class Service {
	static Connection connection;
	static {
		String url = "jdbc:postgresql://localhost:5432/register_db?user=postgres&password=123";
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int saveStudent(Student s) {
		try {
			String query = "INSERT  INTO student values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getCity());
			
			int i = ps.executeUpdate();
			if(i > 0) {
				System.out.println("Student Added !!");
				return i;
			}
			else {
				System.out.println("Failed to Add Student !!");
				return i;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return 0;
	}
}

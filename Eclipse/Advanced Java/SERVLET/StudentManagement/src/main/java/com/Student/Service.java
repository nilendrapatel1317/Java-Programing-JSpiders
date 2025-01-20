package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Service {
    static Connection connection;

    static {
        try {
            // Database connection details
            String url = "jdbc:postgresql://localhost:5432/register_db";
            String user = "postgres";
            String password = "123";

            // Load the PostgreSQL Driver (Optional for modern drivers)
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }
    }

    public static int saveStudent(Student s) {
        if (connection == null) {
            System.err.println("Database connection is not initialized.");
            return 0;
        }

        String query = "INSERT INTO student (name, age, gender, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getGender());
            ps.setString(4, s.getEmail());

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Student Added Successfully!");
            } else {
                System.out.println("Failed to Add Student!");
            }
            return result;
        } catch (SQLException e) {
            System.err.println("SQL Error occurred while saving the student.");
            e.printStackTrace();
        }
        return 0;
    }
}

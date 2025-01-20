package com.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class FetchAllStudentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		String url = "jdbc:postgresql://localhost:5432/register_db?user=postgres&password=123";

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url);

			String query = "SELECT * FROM student";
			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res.setContentType("text/html");
				RequestDispatcher rd = req.getRequestDispatcher("/fetchAllStudents.jsp");
				rd.include(req, res);
			}

		} catch (Exception e) {
			res.setContentType("text/html");
			RequestDispatcher rd = req.getRequestDispatcher("/fetchAllStudents.jsp");
			rd.include(req, res);
			e.printStackTrace();
		}
	}
}

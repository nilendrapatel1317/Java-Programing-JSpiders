package com.loginform;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		String url = "jdbc:postgresql://localhost:5432/register_db?user=postgres&password=123";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url);
			
			String query = "SELECT * from register where email=? and password =?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res.setContentType("text/html");
				out.println("<h3 style='color:green'>User Logged In Successfully !!</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/homepage.html");
				rd.include(req, res);
			}
			else {
				res.setContentType("text/html");
				out.println("<h3 style='color:red'>Incorrect Email or Password !!</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				rd.include(req, res);
			}
			
			
		} catch (Exception e) {
			res.setContentType("text/html");
			out.println("<h3 style='color:red'>Exception Occured :"+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/login.html");
			rd.include(req, res);
			e.printStackTrace();
		}
	}

}

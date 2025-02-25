package com.registerform;

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
import java.sql.SQLException;


@WebServlet("/register")
public class registerServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String city = req.getParameter("city");
		
		String url = "jdbc:postgresql://localhost:5432/register_db?user=postgres&password=123";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url);
			
			String query = "INSERT  INTO register values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, city);
			
			int i = ps.executeUpdate();
			if(i>0) {
				res.setContentType("text/html");
				out.println("<h3 style='color:green'>User Registration Successfully !!</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.html");
				rd.include(req, res);
			}			
			
		} catch (Exception e) {
			res.setContentType("text/html");
			out.println("<h3 style='color:red'>Exception Occured :"+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/register.html");
			rd.include(req, res);
			e.printStackTrace();
		}
	}

}

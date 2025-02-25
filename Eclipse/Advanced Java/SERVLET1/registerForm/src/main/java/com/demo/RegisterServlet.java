package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		
		
		Student s1 = new Student(name,age,email,city);
		int i = Service.saveStudent(s1);
		if(i>0) {
			res.setContentType("text/html");
			out.println("<h3 style='color:green'>Student Registration Successfully !!</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.include(req, res);
		}
		else {
			res.setContentType("text/html");
			out.println("<h3 style='color:red'>"+email+" email already exists !!</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.include(req, res);			
		}
		
		
	}
}

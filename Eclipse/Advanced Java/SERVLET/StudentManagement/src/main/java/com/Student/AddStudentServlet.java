package com.Student;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		
		Student std = new Student(name, age, gender, email);
		int i = Service.saveStudent(std);
		if(i>0) {
			resp.setContentType("text/html");
			out.println("<h3 style='color:green'>Student Registration Successfully !!</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/addStudent.jsp");
			rd.include(req, resp);
		}
		else {
			resp.setContentType("text/html");
			out.println("<h3 style='color:red'>"+email+" email already exists !!</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/addStudent.jsp");
			rd.include(req, resp);			
		}
	}
}

package com.sum;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SqrServlet extends HttpServlet {
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int sum = (int) req.getAttribute("sum");
		int sqr = sum*sum;
		
		res.setContentType("text/html");		
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
	    out.println("<h1>Square is : " + sqr + "</h1>");
	    out.println("</body></html>");
	}
}

package demo_package;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(email);
		System.out.println(city);

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<h1 style='color:green;'>Registration Successfully !!</h1>");
		out.println("<p>Name : "+name+"</p>");
		out.println("<p>Age : "+age+"</p>");
		out.println("<p>Email : "+email+"</p>");
		out.println("<p>City : "+city+"</p>");

	}

}

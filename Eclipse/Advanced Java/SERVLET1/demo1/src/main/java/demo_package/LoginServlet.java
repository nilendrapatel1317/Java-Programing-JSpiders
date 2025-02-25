package demo_package;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println(email);
		System.out.println(password);

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<h1 style='color:green;'>Dashboard Page !!</h1>");
		out.println("<p>Email : "+email+"</p>");
	}
}

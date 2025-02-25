package demo_package;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/fetch")
public class FetchServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		
		System.out.println(email);

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<h1 style='color:green;'>User Found !!</h1>");
		out.println("<p>Email : "+email+"</p>");
	}
}

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (password.equals("root")) {
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
			rd.forward(request, response);
		} else {
			response.setContentType("text/html");
			out.println("<h3 style='color:red'> Invalid Username or Password</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}
	}

}

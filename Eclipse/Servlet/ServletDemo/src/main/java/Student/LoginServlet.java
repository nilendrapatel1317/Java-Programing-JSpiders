package Student;

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
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		
		if(password.equals("root")) {
			
			resp.setContentType("text/html");
			out.println("User Logged In !!");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.forward(req, resp);
		}
		else {
			resp.setContentType("text/html");
			out.println("Incorrect password !!");			
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.forward(req, resp);
		}
	}
}

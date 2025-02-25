package mock;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		
		if(password.equals(confirmPassword)) {
			Users user = new Users(name, username, age, gender, email, password);
			
			int addStatus = DatabaseServices.addUser(user);
			if(addStatus > 0) {
				resp.sendRedirect("login.jsp");
			}
			else {
				out.println("Failed to added user !!");
				RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
				rd.include(req, resp);
			}
		}
		else {
			out.println("ConfirmPassword Is Not Matched !!");
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.include(req, resp);
		}
		
		
	}
}

package mock;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Users user = new Users(username, password);
		
		Boolean loginSuccess = DatabaseServices.login(user);
		if (loginSuccess) {
            // Save user in session for persistence
            HttpSession session = req.getSession();
            session.setAttribute("loggedInUser", user);
            

            // Redirect to home page
        	resp.sendRedirect("homepage.jsp");
        } else {
            // Show error and redirect to login page
            out.println("Invalid Username or password. Please try again !!");
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.include(req, resp);
        }
		
		
	}
}

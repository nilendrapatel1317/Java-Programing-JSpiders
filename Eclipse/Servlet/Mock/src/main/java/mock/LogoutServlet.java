package mock;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the current session
		HttpSession session = request.getSession(false); // false means don't create a new session

		if (session != null) {
			session.invalidate();
		}

		// Redirect to the login page or index.jsp
		response.sendRedirect("index.jsp");
	}
}

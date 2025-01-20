
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/MySearcher")
public class SearchServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		
//		Way 1 : "resp.sendRedirect()" can be used within and outside the server.
		resp.sendRedirect("https://www.google.com/search?q=" + name);
		
//		Way 1 : "req.getRequestDispatcher()" can work within the server only
//		req.getRequestDispatcher("https://www.google.com/search?q=" + name).include(req, resp);
	}
}

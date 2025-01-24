package BankingSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.AccessFlag;

import javax.naming.InitialContext;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/openAccount")
public class OpenAccountServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		HttpSession session = req.getSession(false); // Use false to avoid creating a new session
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		if (loggedInUser == null) {
			// Redirect to login if session expired
			resp.sendRedirect("/BankingSystem/loginPage.jsp");
			return;
		}
		
		double balance = Double.parseDouble(req.getParameter("initialAmount"));
		int security_pin = Integer.parseInt(req.getParameter("securityPin"));

		Account account = new Account(0, balance, security_pin, false, loggedInUser.getId());
		long flag = BankingServices.openAccount(loggedInUser, account);

		if (flag != 0) {
			BankingServices.updatAccountNumber(loggedInUser, account);
            resp.sendRedirect("homePage.jsp");
			
		} else {
			out.println("<p>Failed to Open Account !!</p>");
			RequestDispatcher rd = req.getRequestDispatcher("openAccountPage.jsp");
			rd.include(req, resp);
		}
	}
}

package BankingSystem;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/creditMoney")
public class CreditMoneyServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		Account account = (Account) session.getAttribute("loggedInUserAccount");

		// Check if user is logged in
		if (loggedInUser == null) {
			resp.sendRedirect("/BankingSystem/loginPage.jsp");
			return;
		}

		// Validate input amount
		double amount = Double.parseDouble(req.getParameter("amount"));
		
		RequestDispatcher rd;

		// Perform debit operation
		int creditResult = BankingServices.creditMoney(account, amount);
		System.out.println(account);
		switch (creditResult) {
			case 1:
				// Success
				resp.sendRedirect("homePage.jsp");
				break;

			case -1:
				// Invalid amount
				out.println("<p class='w-100 text-center text-danger mt-3'>Invalid debit amount! Please enter a positive number.</p>");
				rd = req.getRequestDispatcher("creditMoneyPage.jsp");
				rd.include(req, resp);
				break;

			case -2:
				// Database error
				out.println("<p class='w-100 text-center text-danger mt-3'>Error processing request. Please try again later.</p>");
				rd = req.getRequestDispatcher("creditMoneyPage.jsp");
				rd.include(req, resp);
				break;

			default:
				// Unknown error
				out.println("<p class='w-100 text-center text-danger mt-3'>An unexpected error occurred. Please try again.</p>");
				rd = req.getRequestDispatcher("creditMoneyPage.jsp");
				rd.include(req, resp);
				break;
		}
	}
}

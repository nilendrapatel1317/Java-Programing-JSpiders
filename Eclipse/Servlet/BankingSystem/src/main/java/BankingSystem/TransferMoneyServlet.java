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

@WebServlet("/transferMoney")
public class TransferMoneyServlet extends HttpServlet {
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
		
		long receiverAccountNumber = Long.parseLong(req.getParameter("receiverAccountNumber"));
		double amount = Double.parseDouble(req.getParameter("amount"));
		
		RequestDispatcher rd;

		// Perform debit operation
		int creditResult = BankingServices.transferMoney(account, receiverAccountNumber, amount);
		System.out.println(account);
		switch (creditResult) {
			case 1:
				// Success
				resp.sendRedirect("bankingPage.jsp");
				break;

			case -1:
				// Invalid amount
				out.println("<p class='w-100 text-center text-danger mt-3'>Invalid debit amount! Please enter a positive number.</p>");
				rd = req.getRequestDispatcher("transferMoneyPage.jsp");
				rd.include(req, resp);
				break;

			case -2:
				// Database error
				out.println("<p class='w-100 text-center text-danger mt-3'>Insufficient balance !!</p>");
				rd = req.getRequestDispatcher("transferMoneyPage.jsp");
				rd.include(req, resp);
				break;
			case -3:
				// Database error
				out.println("<p class='w-100 text-center text-danger mt-3'>Invalid Recevier Account Number.</p>");
				rd = req.getRequestDispatcher("transferMoneyPage.jsp");
				rd.include(req, resp);
				break;
			case -4:
				// Recevier Account Not found
				out.println("<p class='w-100 text-center text-danger mt-3'>Invalid Recevier Account !!</p>");
				rd = req.getRequestDispatcher("transferMoneyPage.jsp");
				rd.include(req, resp);
				break;
			case -5:
				// Database error
				out.println("<p class='w-100 text-center text-danger mt-3'>Error processing request. Please try again later.</p>");
				rd = req.getRequestDispatcher("transferMoneyPage.jsp");
				rd.include(req, resp);
				break;
			case -6:
				// Database error
				out.println("<p class='w-100 text-center text-danger mt-3'>Can not transfer money to self account !!</p>");
				rd = req.getRequestDispatcher("transferMoneyPage.jsp");
				rd.include(req, resp);
				break;

			default:
				// Unknown error
				out.println("<p class='w-100 text-center text-danger mt-3'>An unexpected error occurred. Please try again.</p>");
				rd = req.getRequestDispatcher("transferMoneyPage.jsp");
				rd.include(req, resp);
				break;
		}
	}
}

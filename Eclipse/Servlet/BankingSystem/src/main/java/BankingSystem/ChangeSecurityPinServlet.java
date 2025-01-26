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

@WebServlet("/changeSecurityPin")
public class ChangeSecurityPinServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		// Retrieve user from session
		HttpSession session = req.getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		Account account = (Account) session.getAttribute("loggedInUserAccount");

		System.out.println(account);
		if (loggedInUser == null) {
			// Redirect to login if session expired
			resp.sendRedirect("/BankingSystem/loginPage.jsp");
			return;
		}

		// Retrieve updated details from form
		int currentPin = Integer.parseInt(req.getParameter("currentPin"));
		int newPin = Integer.parseInt(req.getParameter("newPin"));
		int confirmPin = Integer.parseInt(req.getParameter("confirmPin"));

		int storedPin = account.getSecurity_pin(); // Retrieve user's current password from the session or DB

		if (!(storedPin == currentPin)) {
			out.println("<p class='w-100 text-center text-danger mt-3'>Current Pin is incorrect!</p>");
			RequestDispatcher rd = req.getRequestDispatcher("changePinPage.jsp");
			rd.include(req, resp);
		} else if (!(newPin == confirmPin)) {
			out.println("<p class='w-100 text-center text-danger mt-3'>New Pin do not match!</p>");
			RequestDispatcher rd = req.getRequestDispatcher("changePinPage.jsp");
			rd.include(req, resp);
		} else {

			boolean changedStaus = BankingServices.changeSecurityPin(account, newPin);
			
			System.out.println(account);
			
			if (changedStaus) {
				resp.sendRedirect("homePage.jsp");
			} else {
				out.println(
						"<p class='w-100 text-center text-danger mt-3'>Failed to update security pin. Try again later!</p>");
				RequestDispatcher rd = req.getRequestDispatcher("changePinPage.jsp");
				rd.include(req, resp);
			}

		}
	}
}

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

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		// Retrieve user from session
		HttpSession session = req.getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		if (loggedInUser == null) {
			// Redirect to login if session expired
			resp.sendRedirect("/BankingSystem/loginPage.jsp");
			return;
		}

		// Retrieve updated details from form
		String currentPassword = req.getParameter("currentPassword");
		String newPassword = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");

		String storedPassword = loggedInUser.getPassword(); // Retrieve user's current password from the session or DB

		if (!storedPassword.equals(currentPassword)) {
			out.println("<p class='w-100 text-center text-danger mt-3'>Current password is incorrect!</p>");
			RequestDispatcher rd = req.getRequestDispatcher("changePasswordPage.jsp");
			rd.include(req, resp);
		} else if (!newPassword.equals(confirmPassword)) {
			out.println("<p class='w-100 text-center text-danger mt-3'>New passwords do not match!</p>");
			RequestDispatcher rd = req.getRequestDispatcher("changePasswordPage.jsp");
			rd.include(req, resp);
		} else {

			boolean changedStaus = BankingServices.changePassword(loggedInUser, newPassword);
			
			System.out.println(loggedInUser);

			if (changedStaus) {
				resp.sendRedirect("homePage.jsp");
			} else {
				out.println(
						"<p class='w-100 text-center text-danger mt-3'>Failed to update password. Try again later!</p>");
				RequestDispatcher rd = req.getRequestDispatcher("changePasswordPage.jsp");
				rd.include(req, resp);
			}

		}
	}
}

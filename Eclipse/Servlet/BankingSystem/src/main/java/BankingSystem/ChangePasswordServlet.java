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
			out.println("<div class='alert alert-danger text-center mt-3'>Current password is incorrect!</div>");
			RequestDispatcher rd = req.getRequestDispatcher("changePasswordPage.jsp");
			rd.include(req, resp);
		} else if (!newPassword.equals(confirmPassword)) {
			out.println("<div class='alert alert-danger text-center mt-3'>New passwords do not match!</div>");
			RequestDispatcher rd = req.getRequestDispatcher("changePasswordPage.jsp");
			rd.include(req, resp);
		} else {

			boolean changedStaus = BankingServices.changePassword(newPassword, loggedInUser.getEmail());

			if (changedStaus) {
				out.println("<div class='alert alert-success text-center mt-3'>Password changed successfully!</div>");
				// Update password in session
				loggedInUser.setPassword(newPassword);
				session.setAttribute("loggedInUser", loggedInUser);
				resp.sendRedirect("homePage.jsp");
			} else {
				out.println(
						"<div class='alert alert-danger text-center mt-3'>Failed to update password. Try again later!</div>");
				RequestDispatcher rd = req.getRequestDispatcher("changePasswordPage.jsp");
				rd.include(req, resp);
			}

		}
	}
}

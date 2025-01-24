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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        // Retrieve login credentials
        String email = req.getParameter("email").toLowerCase();
        String password = req.getParameter("password");

        // Create a User object
        User user = new User(email, password);

        // Call the login method in BankingServices
        Boolean loginSuccess = BankingServices.login(user);

        if (loginSuccess) {
            // Save user in session for persistence
            HttpSession session = req.getSession();
            session.setAttribute("loggedInUser", user);

            // Redirect to home page
            resp.sendRedirect("homePage.jsp");
//            rd.forward(req, resp);
        } else {
            // Show error and redirect to login page
            out.println("<p>Invalid email or password. Please try again!</p>");
            RequestDispatcher rd = req.getRequestDispatcher("loginPage.jsp");
            rd.include(req, resp);
        }
    }
}

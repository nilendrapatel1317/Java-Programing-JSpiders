package BankingSystem;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String email = req.getParameter("email").toLowerCase();
        String password = req.getParameter("password");

        User user = new User(name, email, password);

        int result = BankingServices.register(user);

        if (result > 0) {
            resp.sendRedirect("loginPage.jsp");
        } else {
            out.println("<p style='color:red;'>Email already exists! Please try another email.</p>");
            RequestDispatcher rd = req.getRequestDispatcher("registerPage.jsp");
            rd.include(req, resp);
        }

    }
}

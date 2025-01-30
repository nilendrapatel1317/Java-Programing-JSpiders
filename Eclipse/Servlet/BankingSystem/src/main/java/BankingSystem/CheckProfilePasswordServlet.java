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

@WebServlet("/checkProfilePassword")
public class CheckProfilePasswordServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        Account account = (Account) session.getAttribute("loggedInUserAccount");
        
        if (loggedInUser == null) {
            resp.sendRedirect("/BankingSystem/loginPage.jsp");
            return;
        }

        String profilePassword = req.getParameter("profilePassword");

        boolean profilePwdStatus = BankingServices.verifyProfilePassword(loggedInUser.getId(), profilePassword);
        if (profilePwdStatus) {
            resp.sendRedirect("deleteUserProfilePage.jsp");
        } else {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            out.println("<p class='w-100 text-center text-danger mt-3'>Incorrect Profile Password. Please try again!</p>");
            RequestDispatcher rd = req.getRequestDispatcher("verifyProfilePassword.jsp");
            rd.include(req, resp);
        }
    }
}

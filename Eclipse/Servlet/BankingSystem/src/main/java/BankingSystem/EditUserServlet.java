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

@WebServlet("/updateUserDetails")
public class EditUserServlet extends HttpServlet {
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
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String city = req.getParameter("city");
        long phone = Long.parseLong(req.getParameter("phone"));

        // Update the loggedInUser object
        loggedInUser.setName(name);
        loggedInUser.setAge(age);
        loggedInUser.setGender(gender);
        loggedInUser.setCity(city);
        loggedInUser.setPhone(phone);

        // Update user details in the database
        boolean isUpdated = BankingServices.editUser(loggedInUser);

        if (isUpdated) {
            // Update the session with the refreshed user data
            session.setAttribute("loggedInUser", loggedInUser);
            req.setAttribute("successMessage", "Details updated successfully!");
            resp.sendRedirect("homePage.jsp");
        } else {
            req.setAttribute("errorMessage", "Failed to update details. Please try again.");
            RequestDispatcher rd = req.getRequestDispatcher("editUserPage.jsp");
            rd.forward(req, resp);
        }
    }
}

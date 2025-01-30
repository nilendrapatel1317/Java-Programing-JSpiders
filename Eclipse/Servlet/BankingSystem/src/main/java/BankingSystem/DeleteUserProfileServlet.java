package BankingSystem;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DeleteUserProfileServlet")
public class DeleteUserProfileServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get the current session
        HttpSession session = request.getSession(false); // false means don't create a new session
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        
        if (session != null) {
        	
        	boolean deleteStatus = BankingServices.deleteUserProfile(loggedInUser.getId());
            // Remove the user object
            session.removeAttribute("loggedInUser");
            session.removeAttribute("loggedInUserAccount");

            // Invalidate the session
            session.invalidate();
        }

        // Redirect to the login page or index.jsp
        response.sendRedirect("/BankingSystem/index.jsp");
    }
}

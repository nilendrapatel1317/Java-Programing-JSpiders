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

@WebServlet("/checkSecurityPin")
public class CheckSecurityPinServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        Account account = (Account) session.getAttribute("loggedInUserAccount");
        
        if (loggedInUser == null) {
            resp.sendRedirect("/BankingSystem/loginPage.jsp");
            return;
        }

        int securityPin = Integer.parseInt(req.getParameter("securityPin"));
        String operation = req.getParameter("operation"); // Retrieve operation parameter

        boolean securityPinStatus = BankingServices.verifySecurityPin(loggedInUser.getAccountNumber(), securityPin);
        if (securityPinStatus) {
            switch (operation) {
                case "checkBalance":
                    resp.sendRedirect("checkBalancePage.jsp");
                    break;
                case "viewAccount":
                    resp.sendRedirect("viewAccountDetails.jsp");
                    break;
                case "debitMoney":
                    resp.sendRedirect("debitMoneyPage.jsp");
                    break;
                case "creditMoney":
                    resp.sendRedirect("creditMoneyPage.jsp");
                    break;
                case "transferMoney":
                    resp.sendRedirect("transferMoneyPage.jsp");
                    break;
                case "lockAccount":
                	BankingServices.secureAccount(account, true);
                	resp.sendRedirect("accountLockMsgPage.jsp");
                	break;
                case "unLockAccount":
                	BankingServices.secureAccount(account, false);
                	resp.sendRedirect("accountUnlockMsgPage.jsp");
                	break;
                default:
                    resp.sendRedirect("errorPage.jsp"); // Handle invalid operations
                    break;
            }
        } else {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            out.println("<p class='w-100 text-center text-danger mt-3'>Incorrect Security Pin. Please try again!</p>");
            RequestDispatcher rd = req.getRequestDispatcher("verifySecurityPin.jsp");
            rd.include(req, resp);
        }
    }
}

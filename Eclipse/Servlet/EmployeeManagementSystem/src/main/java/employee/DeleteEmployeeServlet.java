package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		int deleteStatus = EmployeeDatabaseServices.deleteEmployee(id);
		
		if(deleteStatus >0) {
			res.sendRedirect("/EmployeeManagementSystem/fetchAllEmployees");
		}

		else {
			out.println("<p class='text-danger'>Failed to Delete Employee</p>");
			RequestDispatcher rd = req.getRequestDispatcher("fetchAllEmployees.jsp");
			rd.include(req, res);
		}
		
	}
}

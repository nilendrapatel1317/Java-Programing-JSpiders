package employee;

import java.io.IOException;
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

@WebServlet("/fetchAllEmployees")
public class FetchAllEmployeesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String searchType = req.getParameter("searchType");
		String searchQuery = req.getParameter("searchQuery");

		List<Employee> employeeList = EmployeeDatabaseServices.viewAllEmp(searchType, searchQuery);

		// Set student list as a request attribute
		req.setAttribute("employeeList", employeeList);

		// Forward request to JSP
		RequestDispatcher rd = req.getRequestDispatcher("/fetchAllEmployees.jsp");
		rd.forward(req, res);
	}
}

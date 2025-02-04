package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateEmployee")
public class EditEmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");

		Employee emp = new Employee(id, name, age, gender, email);

		int updateStatus = EmployeeDatabaseServices.updateEmployee(emp);
		if(updateStatus > 0) {
			res.sendRedirect("/EmployeeManagementSystem/fetchAllEmployees");
		}
		else {
			out.println("<p class='text-danger'>Failed to update Employee</p>");
			RequestDispatcher rd = req.getRequestDispatcher("editEmployee.jsp");
			rd.include(req, res);
		}

	}
}

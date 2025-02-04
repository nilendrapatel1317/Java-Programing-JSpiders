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

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");

		Employee emp = new Employee(name, age, gender, email);

		int addEmpStatus = EmployeeDatabaseServices.addEmployee(emp);
		if(addEmpStatus > 0) {
			res.sendRedirect("index.jsp");
		}
		else {
			out.println("<p style='color:red; text-align: center;'>Email Already exits !!</p>");
			RequestDispatcher rd = req.getRequestDispatcher("/addEmployee.jsp");
			rd.include(req, res);
		}
		
	}
}

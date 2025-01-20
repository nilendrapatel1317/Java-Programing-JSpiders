package student;

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

@WebServlet("/searchStudentById")
public class SearchStudentByIdServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));

		String url = "jdbc:postgresql://localhost:5432/register_db?user=postgres&password=123";

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url);

			String query = "SELECT * FROM student where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				
				Student student = new Student(id, name, age, gender, email);
				
				req.setAttribute("id", student.getId());
				req.setAttribute("name", student.getName());
				req.setAttribute("age", student.getAge());
				req.setAttribute("gender", student.getGender());
				req.setAttribute("email", student.getEmail());
				
				RequestDispatcher rd = req.getRequestDispatcher("/singleStudent.jsp");
				rd.forward(req, res);

			}
			else {
				res.setContentType("text/html");
				out.println("<h5 style='color: red'>User Id Not Found</h5>");
				RequestDispatcher rd = req.getRequestDispatcher("/searchStudentById.jsp");
				rd.include(req, res);
			}

			// Close resources
			rs.close();
			ps.close();
			connection.close();

		} catch (Exception e) {
			res.setContentType("text/html");
			out.println("<h5 style='color: red'>Exception Error:"+e.getMessage()+"</h5>");
			RequestDispatcher rd = req.getRequestDispatcher("/searchStudentById.jsp");
			rd.include(req, res);
		}
		
	}
}

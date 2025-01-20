package student;

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

@WebServlet("/fetchAllStudents")
public class FetchAllStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String url = "jdbc:postgresql://localhost:5432/register_db?user=postgres&password=123";
		List<Student> studentList = new ArrayList<>();

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url);

			String query = "SELECT * FROM student";
			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String email = rs.getString("email");

				// Add the student to the list
				studentList.add(new Student(id, name, age, gender, email));

			}

			// Set student list as a request attribute
			req.setAttribute("studentList", studentList);

			// Close resources
			rs.close();
			ps.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// Forward to JSP page
		RequestDispatcher rd = req.getRequestDispatcher("/fetchAllStudents.jsp");
		rd.forward(req, res);
	}
}

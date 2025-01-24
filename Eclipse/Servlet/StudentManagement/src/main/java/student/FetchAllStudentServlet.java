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

		String searchType = req.getParameter("searchType");
		String searchQuery = req.getParameter("searchQuery");

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url);

			String query = "";
			PreparedStatement ps = null;

			if (searchQuery != null && !searchQuery.trim().isEmpty()) {
				switch (searchType) {
				case "id":
					// Search by ID
					query = "SELECT * FROM student WHERE id = ? ORDER BY id";
					ps = connection.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(searchQuery)); // Parse ID to integer
					break;
				case "name":
					// Search by Name
					query = "SELECT * FROM student WHERE LOWER(name) LIKE ? ORDER BY id";
					ps = connection.prepareStatement(query);
					ps.setString(1, "%" + searchQuery.toLowerCase() + "%");
					break;
				case "email":
					// Search by Email
					query = "SELECT * FROM student WHERE LOWER(email) LIKE ? ORDER BY id";
					ps = connection.prepareStatement(query);
					ps.setString(1, "%" + searchQuery.toLowerCase() + "%");
					break;
				default:
					// If no valid search type, return all students
					query = "SELECT * FROM student ORDER BY id";
					ps = connection.prepareStatement(query);
					break;
				}
			} else {
				// Query without filtering
				query = "SELECT * FROM student ORDER BY id";
				ps = connection.prepareStatement(query);
			}

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

package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeDatabaseServices {
	static Connection connection;

	static {
		String url = "jdbc:postgresql://localhost:5432/employee_management_system";
		String user = "postgres";
		String password = "123";

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Database connection successful!"); // Debugging message
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("SQL Exception: " + e.getMessage());
		}
	}

	public static int addEmployee(Employee emp) {
		try {
			// Check if email already exists
			String checkQuery = "SELECT COUNT(*) FROM Employee WHERE email = ?";
			PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
			checkStmt.setString(1, emp.getEmail());
			ResultSet rs = checkStmt.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {
				return 0; // Email already exists
			}

			// Insert if email does not exist
			String query = "INSERT INTO Employee(name, age, gender, email) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getAge());
			ps.setString(3, emp.getGender());
			ps.setString(4, emp.getEmail());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static List<Employee> viewAllEmp(String searchType, String searchQuery) {
		List<Employee> employeeList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String query = "";
			if (searchQuery != null && !searchQuery.trim().isEmpty()) {
				switch (searchType) {
				case "id":
					query = "SELECT * FROM Employee WHERE id = ? ORDER BY id";
					ps = connection.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(searchQuery)); // Convert ID to integer
					break;
				case "name":
					query = "SELECT * FROM Employee WHERE LOWER(name) LIKE ? ORDER BY id";
					ps = connection.prepareStatement(query);
					ps.setString(1, "%" + searchQuery.toLowerCase() + "%");
					break;
				case "email":
					query = "SELECT * FROM Employee WHERE LOWER(email) LIKE ? ORDER BY id";
					ps = connection.prepareStatement(query);
					ps.setString(1, "%" + searchQuery.toLowerCase() + "%");
					break;
				default:
					query = "SELECT * FROM Employee ORDER BY id";
					ps = connection.prepareStatement(query);
					break;
				}
			} else {
				query = "SELECT * FROM Employee ORDER BY id";
				ps = connection.prepareStatement(query);
			}

			rs = ps.executeQuery();
			while (rs.next()) {

				employeeList.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
						rs.getString("gender"), rs.getString("email")));
			}

			return employeeList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	public static int updateEmployee(Employee emp) {
		try {
			String query = "UPDATE Employee SET name = ? , age = ? , gender = ? WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getAge());
			ps.setString(3, emp.getGender());
			ps.setInt(4, emp.getId());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int deleteEmployee(long empId) {
		try {

			String query = "DELETE FROM Employee where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, empId);

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}

package mock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DatabaseServices {
	static Connection connection;

	static {
		String url = "jdbc:postgresql://localhost:5432/users";
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
	
	public static int addUser(Users user) {
		String addQuery = "INSERT INTO users (name,username,age,gender,email,password) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(addQuery);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getUsername());
			pstm.setInt(3, user.getAge());
			pstm.setString(4, user.getGender());
			pstm.setString(5, user.getEmail());
			pstm.setString(6, user.getPassword());
			
			return pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static boolean login(Users user) {
		String loginQuery = "SELECT * FROM users WHERE username = ? AND password = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(loginQuery)) {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setAge(rs.getInt("age"));
				user.setGender(rs.getString("gender"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}

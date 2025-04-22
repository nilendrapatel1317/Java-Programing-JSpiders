package userpost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPost {
	private static final String url = "jdbc:postgresql://localhost:5432/userpost?user=postgres&password=123";

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(url);

			String query = "SELECT users.name AS user_name, users.email, posts.title, posts.content FROM users JOIN posts ON users.id = posts.user_id";
			PreparedStatement pstm = con.prepareCall(query);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				String userName = resultSet.getString("user_name");
				String email = resultSet.getString("email");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");

				System.out.println("User: " + userName + " (" + email + ")");
				System.out.println("Post Title: " + title);
				System.out.println("Content: " + content);
				System.out.println("=================================");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}

package jdbcpost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class selectQuery {
	private static String url = "jdbc:postgresql://localhost:5432/demodb?user=postgres&password=123";

	public static void main(String[] args) throws ClassNotFoundException {

		try {
			// Load and Register Driver
			Class.forName("org.postgresql.Driver");

			// Establish Connection
			Connection con = DriverManager.getConnection(url);

//			===============================================================
//			Read Operation (SELECT)
//			===============================================================
//			executeQuery() used for SELECT , It will give data for query
			String readQuery = "select * from student";
			// Create statement
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(readQuery);
			System.out.println("Student: ");
			System.out.println("+--------+------------------+--------+----------+");
			System.out.println("| Id     | Name             | Age    | Gender   |");
			System.out.println("+--------+------------------+--------+----------+");
//			//READ data
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				System.out.printf("| %-6d | %-16s | %-6d | %-8s |%n", id, name, age, gender);
				System.out.println("+--------+------------------+--------+----------+");
			}

			// Close connection
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Only name is fetched");
			e.printStackTrace();
		}
	}
}

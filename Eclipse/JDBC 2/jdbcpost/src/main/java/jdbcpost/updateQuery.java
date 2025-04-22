package jdbcpost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateQuery {
	private static String url = "jdbc:postgresql://localhost:5432/demodb?user=postgres&password=123";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Load and Register Driver
		Class.forName("org.postgresql.Driver");

		// Establish Connection
		Connection con = DriverManager.getConnection(url);
		Scanner scn = new Scanner(System.in);

		// executeUpdate() is used for INSERT, DELETE, UPDATE
		// It will integer value 1 if query will successfully executed other wise exception

//		============================================================
//		Update Operation (UPDATE)
//		============================================================
		String updateQuery = "update student set name=? where id=?";
		PreparedStatement ps = con.prepareStatement(updateQuery);
		System.out.print("Enter student id whom to be update: ");
		int id= scn.nextInt();
		ps.setInt(2, id);
		System.out.print("Enter student new name: ");
		String name= scn.next();
		ps.setString(1, name);
		int i = ps.executeUpdate();

		if(i>0) {
			System.out.println("Student Updated");
		}
		else {
			System.out.println("Fail to Update ! ID is not found !");			
		}

		// Close connection
		ps.close();
		con.close();
	}
}

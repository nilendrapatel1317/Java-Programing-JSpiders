package jdbcpost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteQuery {
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
//		Delete Operation (DELETE)
//		============================================================
		String deleteQuery = "delete from student where id=?";
		PreparedStatement ps = con.prepareStatement(deleteQuery);
		System.out.print("Enter student id whom to be delete: ");
		int id= scn.nextInt();
		ps.setInt(1, id);
		int i = ps.executeUpdate();
//	
		if(i==1) {
			System.out.println("Student Deleted");
		}
		else {
			System.out.println("Fail to Delete ! ID is not found !");			
		}

		// Close connection
		ps.close();
		con.close();
	}
}

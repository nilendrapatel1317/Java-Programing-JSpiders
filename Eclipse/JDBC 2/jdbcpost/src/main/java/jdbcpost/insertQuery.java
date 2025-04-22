package jdbcpost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insertQuery {
	private static String url = "jdbc:postgresql://localhost:5432/demodb?user=postgres&password=123";
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException  {

		
		//Load and Register Driver
		Class.forName("org.postgresql.Driver");
		
		//Establish Connection
		Connection con = DriverManager.getConnection(url);
			
		
		Scanner scn = new Scanner(System.in);

		//executeUpdate() is used for INSERT, DELETE, UPDATE
		//It will integer value 1 if query will successfully executed other wise exception
//		============================================================
//		Insert Operation (INSERT)
//		============================================================
		String insertQuery = "insert into student values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		System.out.println("Enter student details !");
		System.out.print("Enter student id : ");
		int id= scn.nextInt();
		System.out.print("Enter student name : ");
		String name= scn.next();
		System.out.print("Enter student age : ");
		int age= scn.nextInt();
		System.out.print("Enter student gender : ");
		String gender= scn.next();
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setString(4, gender);

		int i = ps.executeUpdate();
		
		if(i==1) {
			System.out.println("Student Added");
		}
				
		//Close connection
		ps.close();
		con.close();
	}
}

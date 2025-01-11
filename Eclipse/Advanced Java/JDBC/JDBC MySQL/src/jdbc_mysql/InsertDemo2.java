package jdbc_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Load and Register Driver software
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "rocky");

		//Create Statement
		String query = "insert into student values ('Nandini',101)";
		PreparedStatement ps= con.prepareStatement(query);
		
		//Execute the query
		int i = ps.executeUpdate();
		if(i>0) {
			System.out.println("Success");
		}
		else {
			System.out.println("Fail");
		}
		
		//Close Connection
		ps.close();
		con.close();
		
	}
}

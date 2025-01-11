package jdbc_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "rocky");
//		System.out.println("Success");
		
		PreparedStatement ps= con.prepareStatement("insert into student values ('Vivek',101)");
		int i = ps.executeUpdate();
		if(i>0) {
			System.out.println("Success");
		}
		else {
			System.out.println("Fail");
		}
		
		
		
	}
}

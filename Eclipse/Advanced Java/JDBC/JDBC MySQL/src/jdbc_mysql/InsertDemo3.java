package jdbc_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "rocky");
//		System.out.println("Success");
		
		String name = "Dinesh";
		int id = 105;
		PreparedStatement ps= con.prepareStatement("insert into student values ('"+name +"','"+id+"')");
		int i = ps.executeUpdate();
		if(i>0) {
			System.out.println("Success");
		}
		else {
			System.out.println("Fail");
		}
		

	}
}

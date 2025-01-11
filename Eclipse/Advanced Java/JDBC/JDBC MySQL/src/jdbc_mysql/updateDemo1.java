package jdbc_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateDemo1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "rocky");
		
		String name = "Nilendra";
		int id = 123;
		PreparedStatement ps= con.prepareStatement("update student set name=? where id=?"); //positional parameters
		ps.setString(1, name);
		ps.setInt(2, id);
		int i = ps.executeUpdate();
		if(i>0) {
			System.out.println("Success");
		}
		else {
			System.out.println("Fail");
		}
		

	}
}

package jdbcpost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchQuery {
	private static String url = "jdbc:postgresql://localhost:5432/demodb?user=postgres&password=123";
	
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(url);

			String insertQuery = "insert into student values(?,?,?,?)";
			PreparedStatement insert_pstm = con.prepareStatement(insertQuery);
			
			insert_pstm.setInt(1, 105);
			insert_pstm.setString(2, "Vikash");
			insert_pstm.setInt(3, 25);
			insert_pstm.setString(4, "male");
			insert_pstm.addBatch();

			insert_pstm.setInt(1, 106);
			insert_pstm.setString(2, "Sumita");
			insert_pstm.setInt(3, 18);
			insert_pstm.setString(4, "female");
			insert_pstm.addBatch();
			
			String updateQuery = "update student set name = ? where id = ?";
			PreparedStatement update_pstm = con.prepareStatement(updateQuery);
			
			update_pstm.setString(1, "Rahul");
			update_pstm.setInt(2, 103);
			update_pstm.addBatch();

			update_pstm.setString(1, "Shivani");
			update_pstm.setInt(2, 104);
			update_pstm.addBatch();
			
			String deleteQuery = "delete from student where id=?";
			PreparedStatement delete_pstm = con.prepareStatement(deleteQuery);
			delete_pstm.setInt(1, 101);
			delete_pstm.addBatch();

			delete_pstm.setInt(1, 102);
			delete_pstm.addBatch();
			
			
			

			
			
			
			//Close connection
			insert_pstm.close();
			update_pstm.close();
			delete_pstm.close();
			con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

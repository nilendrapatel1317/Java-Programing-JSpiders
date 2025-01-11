package jdbcpost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchQuery2 {
	private static String url = "jdbc:postgresql://localhost:5432/demodb?user=postgres&password=123";
	
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(url);

			Statement stm =  con.createStatement();
			
			String insertQuery1 = "insert into student values(106,'Jojo',20,'female')";
			stm.addBatch(insertQuery1);
			
			String insertQuery2 = "insert into student values(106,'Neha',25,'female')";
			stm.addBatch(insertQuery2);
			
			String updateQuery1 = "update student set name='Neelesh' where id = 104";
			stm.addBatch(updateQuery1);
			
			String deleteQuery1 = "delete from student where id = 105";
			stm.addBatch(deleteQuery1);
		
			int[] i = stm.executeBatch();
			System.out.println(Arrays.toString(i));
			System.out.println("Data Saved");
		
			
			
			
			
			//Close connection
			con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package jdbcpost;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaData {
	private static String url = "jdbc:postgresql://localhost:5432/demodb?user=postgres&password=123";
	
	public static void main(String[] args) {
		
		try {
			Connection con = DriverManager.getConnection(url);
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverVersion());
			System.out.println(dbmd.getURL());
			System.out.println(dbmd.getUserName());
			System.out.println(dbmd.getTables(null, null, "%", null));
			
			System.out.println("===================================================================");
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM student");
			ResultSetMetaData rmd = rs.getMetaData();
			System.out.println(rmd.getColumnCount());
			System.out.println(rmd.getColumnClassName(3));
			System.out.println(rmd.getColumnName(1));
			System.out.println(rmd.getColumnName(2));
			System.out.println(rmd.getColumnName(3));
			System.out.println(rmd.getColumnName(4));
			System.out.println(rmd.getColumnDisplaySize(1));
			System.out.println(rmd.getColumnDisplaySize(2));
			System.out.println(rmd.getColumnTypeName(1));
			System.out.println(rmd.getColumnTypeName(2));
			System.out.println(rmd.getColumnTypeName(3));
			System.out.println(rmd.getColumnTypeName(4));
			System.out.println(rmd.getTableName(2));
			System.out.println(rmd.getPrecision(1));
			System.out.println(rmd.getScale(1));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}














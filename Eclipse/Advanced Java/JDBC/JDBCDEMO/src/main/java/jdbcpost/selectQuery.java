package jdbcpost;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class selectQuery {
	private static String url = "jdbc:postgresql://localhost:5432/emp_dept_db?user=postgres&password=123";

	public static void main(String[] args) {

		try {
			// Load and Register Driver
//			Class.forName("org.postgresql.Driver");

			// Establish Connection
			Connection con = DriverManager.getConnection(url);

//			===============================================================
//			Read Operation (SELECT)
//			===============================================================
//			executeQuery() used for SELECT , It will give data for query
			String readQuery = "SELECT * FROM emp join dept on emp.deptno = dept.deptno";
			// Create statement
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(readQuery);
//			displayEmpData(rs);
//			displayDeptData(rs);
			displayEmpDeptData(rs);

			// Close connection
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Only name is fetched");
			e.printStackTrace();
		}
	}

	public static void displayEmpData(ResultSet rs) throws SQLException {
		System.out.println("Employee Records: ");
		System.out.println("+--------+----------+-------------+--------+------------+----------+----------+--------+");
		System.out.println("| EMPNO  | ENAME    | JOB         | MGR    | HIREDATE   | SAL      | COMM     | DEPTNO |");
		System.out.println("+--------+----------+-------------+--------+------------+----------+----------+--------+");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		while (rs.next()) {
		    int empno = rs.getInt("empno");
		    String ename = rs.getString("ename");
		    String job = rs.getString("job");
		    int mgr = rs.getInt("mgr");
		    if (rs.wasNull()) {
		        mgr = 0; // If MGR is null, display as 0 or leave it blank
		    }
		    Date hiredate = rs.getDate("hiredate");
		    double sal = rs.getDouble("sal");
		    Double comm = rs.getObject("comm") != null ? rs.getDouble("comm") : null;
		    int deptno = rs.getInt("deptno");

		    System.out.printf("| %-6d | %-8s | %-11s | %-6s | %-10s | %-8.2f | %-8s | %-6d |%n",
		            empno, ename, job, (mgr == 0 ? "" : mgr),
		            (hiredate != null ? dateFormat.format(hiredate) : ""),
		            sal, (comm != null ? String.format("%.2f", comm) : ""), deptno);
		    System.out.println("+--------+----------+-------------+--------+------------+----------+----------+--------+");
		}
	}
	
	public static void displayDeptData(ResultSet rs) throws SQLException {
	    System.out.println("Department Records: ");
	    System.out.println("+--------+----------------+------------+");
	    System.out.println("| DEPTNO | DNAME          | LOC        |");
	    System.out.println("+--------+----------------+------------+");

	    while (rs.next()) {
	        int deptno = rs.getInt("deptno");
	        String dname = rs.getString("dname");
	        String loc = rs.getString("loc");

	        System.out.printf("| %-6d | %-14s | %-10s |%n", deptno, dname, loc);
	        System.out.println("+--------+----------------+------------+");
	    }
	}
	
	public static void displayEmpDeptData(ResultSet rs) throws SQLException {
	    System.out.println("Employee + Department Records: ");
	    System.out.println("+--------+----------+-------------+--------+------------+----------+----------+--------+----------------+------------+");
	    System.out.println("| EMPNO  | ENAME    | JOB         | MGR    | HIREDATE   | SAL      | COMM     | DEPTNO | DNAME          | LOC        |");
	    System.out.println("+--------+----------+-------------+--------+------------+----------+----------+--------+----------------+------------+");

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	    while (rs.next()) {
	        int empno = rs.getInt("empno");
	        String ename = rs.getString("ename");
	        String job = rs.getString("job");
	        int mgr = rs.getInt("mgr");
	        if (rs.wasNull()) {
	            mgr = 0; // If MGR is null, display as 0 or leave it blank
	        }
	        Date hiredate = rs.getDate("hiredate");
	        double sal = rs.getDouble("sal");
	        Double comm = rs.getObject("comm") != null ? rs.getDouble("comm") : null;
	        int deptno = rs.getInt("deptno");
	        String dname = rs.getString("dname");
	        String loc = rs.getString("loc");

	        System.out.printf("| %-6d | %-8s | %-11s | %-6s | %-10s | %-8.2f | %-8s | %-6d | %-14s | %-10s |%n",
	                empno, ename, job, (mgr == 0 ? "" : mgr),
	                (hiredate != null ? dateFormat.format(hiredate) : ""),
	                sal, (comm != null ? String.format("%.2f", comm) : ""), deptno, dname, loc);
	        System.out.println("+--------+----------+-------------+--------+------------+----------+----------+--------+----------------+------------+");
	    }
	}


	
}

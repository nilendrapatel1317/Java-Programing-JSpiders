package jdbcpost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Postgresql_CRUD_program {
	private static String jdbc_url = "jdbc:postgresql://localhost:5432/demodb?user=postgres&password=123";
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		Connection con=DriverManager.getConnection(jdbc_url);
		
		
//		createOperation(con);
		
		readOperation(con);
		
//		updateOperation(con);
		
//		deleteOperation(con);
		
		
	}

//	Create Operation
	public static void createOperation(Connection con) throws SQLException {

		System.out.println("Enter student details !!!");
		System.out.print("Enter student id : ");
		int id= scn.nextInt();
		System.out.print("Enter student name : ");
		String name= scn.next();
		System.out.print("Enter student age : ");
		int age= scn.nextInt();
		System.out.print("Enter student gender : ");
		String gender= scn.next();
		
		String insertQuery = "INSERT INTO student VALUES(?,?,?,?)"; //? - is also know as delimeter
		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setString(4, gender);	

		int i = ps.executeUpdate();
		
		if(i==1) {
			System.out.println("Student Added");
		}
	}

//	Read Operation 
	public static void readOperation(Connection con) throws SQLException {
		Statement st = con.createStatement();
		String readQuery = "SELECT * FROM student RODER BY id";
		ResultSet rs = st.executeQuery(readQuery);
		System.out.println("Student: ");
		System.out.println("+--------+------------------+--------+----------+");
		System.out.println("| Id     | Name             | Age    | Gender   |");
		System.out.println("+--------+------------------+--------+----------+");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String gender = rs.getString("gender");
			System.out.printf("| %-6d | %-16s | %-6d | %-8s |\n", id, name, age, gender);
			System.out.println("+--------+------------------+--------+----------+");
		}
	}

//	Update Operation
	public static void updateOperation(Connection con) throws SQLException {
		System.out.print("Enter student id whom to be update: ");
		int id= scn.nextInt();
		System.out.print("Enter student new name: ");
		String name= scn.next();
		
		String updateQuery = "UPDATE student SET name=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(updateQuery);
		ps.setString(1, name);
		ps.setInt(2, id);
		
		int i = ps.executeUpdate();

		if(i==1) {
			System.out.println("Student Updated");
		}
		else {
			System.out.println("Fail to Update ! ID is not found !");			
		}
	}

//	Delete Operation
	public static void deleteOperation(Connection con) throws SQLException {
		System.out.print("Enter student id whom to be delete: ");
		int id= scn.nextInt();
		
		String deleteQuery = "DELETE FROM student WHERE id=?";
		PreparedStatement ps = con.prepareStatement(deleteQuery);
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		if(i==1) {
			System.out.println("Student Deleted");
		}
		else {
			System.out.println("Fail to Delete ! ID is not found !");			
		}
		
	}

}

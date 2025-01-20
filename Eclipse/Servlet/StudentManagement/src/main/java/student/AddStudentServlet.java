package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		
		String url = "jdbc:postgresql://localhost:5432/register_db?user=postgres&password=123";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url);
			
			String query = "INSERT  INTO student(name,age,gender,email) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			ps.setString(4, email);
			
			int i = ps.executeUpdate();
			if(i>0) {		
				RequestDispatcher rd = req.getRequestDispatcher("/addConfirm.jsp");
				rd.forward(req, res);
			}			
			
		} catch (Exception e) {
			res.setContentType("text/html");
			out.println("<p style='color:red; text-align: center;'>Exception Occured :"+e.getMessage()+"</p>");
			RequestDispatcher rd = req.getRequestDispatcher("/addStudent.jsp");
			rd.include(req, res);
			e.printStackTrace();
		}
	}
}

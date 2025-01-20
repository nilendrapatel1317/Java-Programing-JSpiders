package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteAllStudents")
public class DeleteAllStudentsServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		

		String url = "jdbc:postgresql://localhost:5432/register_db?user=postgres&password=123";

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url);

			String query = "DELETE FROM student";
			PreparedStatement ps = connection.prepareStatement(query);

			int i = ps.executeUpdate();
			if (i>0) {				
				RequestDispatcher rd = req.getRequestDispatcher("/deleteAllStudentConfirm.jsp");
				rd.forward(req, res);

			}
			else {
				res.setContentType("text/html");
				out.println("<h5 style='color: red'>Students Record Not Found !!</h5>");
				RequestDispatcher rd = req.getRequestDispatcher("/deleteAllStudent.jsp");
				rd.include(req, res);
			}

			// Close resources
			ps.close();
			connection.close();

		} catch (Exception e) {
			res.setContentType("text/html");
			out.println("<h5 style='color: red'>Exception Error:"+e.getMessage()+"</h5>");
			RequestDispatcher rd = req.getRequestDispatcher("/deleteAllStudent.jsp");
			rd.include(req, res);
		}
		
	}
}

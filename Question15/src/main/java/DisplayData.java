

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

/**
 * Servlet implementation class DisplayData
 */
@WebServlet("/DisplayDataServlet")

public class DisplayData extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  String url = "jdbc:mysql:///Niranjana"; // Replace with your MySQL URL
	      String username = "root"; // Replace with your MySQL username
	      String password = "Nira@12345"; // Replace with your MySQL password

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer"); // Replace with your table name

            out.println("<html><body>");
            out.println("<h2>Data from Database</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Age</th></tr>");

            while (resultSet.next()) {
                int id = resultSet.getInt("cid");
                String name = resultSet.getString("cname");
                int age = resultSet.getInt("caddress");

                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td></tr>");
            }

            out.println("</table>");
            out.println("</body></html>");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

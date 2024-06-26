
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class DBConnection{
	 public static Connection getConnection() {
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
				String url= "jdbc:mysql://localhost:3306/login";
				String username="root";
				String password="123456";
	            return DriverManager.getConnection(url,username,password);
	        } catch (Exception e) {
	            e.printStackTrace();
	           System.out.println(e.getMessage());
	            return null;
	        }
	    }
}


public class JdbcMain extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		try {
        	
			 Connection con = DBConnection.getConnection();
		// out.println("hello");
		
			
				 System.out.println("connection ok");
				 String query = "SELECT tId, tName FROM table1";
		            PreparedStatement preparedStatement = con.prepareStatement(query);
		            ResultSet resultSet = preparedStatement.executeQuery();

		            out.println("<html><body>");
		            out.println("<h2>Database Records</h2>");
		            out.println("<ul>");

		            while (resultSet.next()) {
		                int id = resultSet.getInt("tId");
		                String name = resultSet.getString("tName");
		                out.println("<li>ID: " + id + ", Name: " + name + "</li>");
		            }

		            out.println("</ul>");
		            out.println("</body></html>");

		            con.close();
			 
			 
			
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<html><body><h2>Exception: " + e.getMessage() + "</h2></body></html>");
    }
	
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		doGet(arg0, arg1);
	}

}

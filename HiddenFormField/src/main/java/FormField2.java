import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
public class FormField2 extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter pw= resp.getWriter();
	String name1= req.getParameter("name123");
	String pas= req.getParameter("pass123");
	int pass1=Integer.parseInt(pas);
	pw.write("name is: "+name1);
	pw.write("<br>");
	pw.write("password is: "+pass1);
	
	try  {
   	 Connection connection = DBConnection.getConnection();
       String checkQuery = "SELECT * FROM hiddenform WHERE uname=?";
       try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
           checkStatement.setString(1, name1);
           ResultSet resultSet = checkStatement.executeQuery();

           if (resultSet.next()) {
               pw.println("<html><body>");
               pw.println("<h1>Username already registered</h1>");
               pw.println("</body></html>");
           } else {
               String insertQuery = "INSERT INTO hiddenform (uname, pword) VALUES (?, ?)";
               try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                   insertStatement.setString(1, name1);
                   insertStatement.setInt(2, pass1);
                   
                   insertStatement.executeUpdate();

                   pw.println("<html><body>");
                   pw.println("<h1>your data is sucessfully saved in our database</h1>");
                   pw.println("</body></html>");
               }
           }
       }
   } catch (Exception e) {
       e.printStackTrace();
   }
	
	
}
}
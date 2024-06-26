import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
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
public class MainPage2 extends HttpServlet {
        
    // JDBC connection details
    
    

   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String email1 = req.getParameter("email");
        try (Connection connection = DBConnection.getConnection()) {
            String email = req.getParameter("email");
            String checkQuery = "SELECT COUNT(*) FROM user WHERE email=?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setString(1, email);
            ResultSet checkResultSet = checkStatement.executeQuery();
            checkResultSet.next();
            int rowCount = checkResultSet.getInt(1);

            out.println("<html><body>");
            out.println("<h1>User Data</h1>");

            if (rowCount > 0) {
                // Email exists in the table, so retrieve and display all rows
                String query = "SELECT name, email, dob, gender FROM user";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                out.println("<table border=\"1\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>Name</th>");
                out.println("<th>Email</th>");
                out.println("<th>DOB</th>");
                out.println("<th>Gender</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String userEmail = resultSet.getString("email");
                    String dob = resultSet.getString("dob");
                    String gender=resultSet.getString("gender");

                    out.println("<tr>");
                    out.println("<td>" + name + "</td>");
                    out.println("<td>" + userEmail + "</td>");
                    out.println("<td>" + dob + "</td>");
                    out.println("<td>" + gender + "</td>");
                    out.println("</tr>");
                }

                out.println("</tbody>");
                out.println("</table>");
            } else {
                // Email does not exist in the table
                out.println("<p>Email not found in the user table. Please sign up first.</p>");
            }

            out.println("</body></html>");

        } catch (Exception e) {
            e.printStackTrace();
        }


//        try (Connection connection = DBConnection.getConnection()) {
//            String query = "SELECT name, email, dob, gender FROM user";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            out.println("<html><body>");
//            out.println("<h1>User Data</h1>");
//            out.println("<table border=\"1\">");
//            out.println("<thead>");
//            out.println("<tr>");
//            out.println("<th>Name</th>");
//            out.println("<th>Email</th>");
//            out.println("<th>DOB</th>");
//            out.println("<th>Gender</th>");
//            out.println("</tr>");
//            out.println("</thead>");
//            out.println("<tbody>");
//
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String email = resultSet.getString("email");
//                String dob = resultSet.getString("dob");
//                String gender= resultSet.getString("gender");
//
//                out.println("<tr>");
//                out.println("<td>" + name + "</td>");
//                out.println("<td>" + email + "</td>");
//                out.println("<td>" + dob + "</td>");
//                out.println("<td>" + gender + "</td>");
//                out.println("</tr>");
//            }
//
//            out.println("</tbody>");
//            out.println("</table>");
//            out.println("</body></html>");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
        
        
        
//        try  {
//        	 Connection connection = DBConnection.getConnection();
//            String query = "SELECT * FROM user WHERE email=?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//                preparedStatement.setString(1, email);
//                ResultSet resultSet = preparedStatement.executeQuery();
//
//                if (resultSet.next()) {
//                	 String name = resultSet.getString("name");
//                     String dob = resultSet.getString("dob");
//
//                     out.println("<html><body>");
//                     out.println("<h1>You Are Successfully Logged In</h1>");
//                     out.println("<table border=\"1\">");
//                     out.println("<thead>");
//                     out.println("<tr>");
//                     out.println("<th>Name</th>");
//                     out.println("<th>Email</th>");
//                     out.println("<th>DOB</th>");
//                     out.println("</tr>");
//                     out.println("</thead>");
//                     out.println("<tbody>");
//                     out.println("<tr>");
//                     out.println("<td>" + name + "</td>");
//                     out.println("<td>" + email + "</td>");
//                     out.println("<td>" + dob + "</td>");
//                     out.println("</tr>");
//                     out.println("</tbody>");
//                     out.println("</table>");
//                     out.println("</body></html>");
//                	
//                	
////                    out.println("<html><body>");
////                    out.println("<h1>You Are Successfully Logged In</h1>");
////                    out.println("</body></html>");
//                } else {
//                    out.println("<html><body>");
//                    out.println("<h1>Please Sign Up first and then try again</h1>");
//                    out.println("</body></html>");
//                }
            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        out.println("<a href='index.html'>" + "<button type=\"button\">Go Back</button>\r\n" + "</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");
       

        try  {
        	 Connection connection = DBConnection.getConnection();
            String checkQuery = "SELECT * FROM user WHERE email=?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
                checkStatement.setString(1, email);
                ResultSet resultSet = checkStatement.executeQuery();

                if (resultSet.next()) {
                    out.println("<html><body>");
                    out.println("<h1>Username or email id already registered</h1>");
                    out.println("</body></html>");
                } else {
                    String insertQuery = "INSERT INTO user (name, email, dob, gender) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                        insertStatement.setString(1, username);
                        insertStatement.setString(2, email);
                        insertStatement.setString(3, dob);
                        insertStatement.setString(4, gender);
                       // insertStatement.setString(4, gender);
                        insertStatement.executeUpdate();

                        out.println("<html><body>");
                        out.println("<h1>You Are Successfully Signed Up</h1>");
                        out.println("</body></html>");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("<a href='index.html'>" + "<button type=\"button\">Go Back</button>\r\n" + "</a>");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Not implemented for this example
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet calling");
    	String action = req.getParameter("action");
        switch (action) {
            case "login":
                doGet(req, resp);
                break;
            case "signup":
                doPost(req, resp);
                break;
            default:
                resp.getWriter().println("Invalid action in service");
        }
    }
}


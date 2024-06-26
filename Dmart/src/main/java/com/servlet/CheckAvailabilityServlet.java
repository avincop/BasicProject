package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.ConnectionProvider;

@WebServlet("/CheckAvailabilityServlet")
public class CheckAvailabilityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM items";
            
            // Prepare the SQL statement
            statement = ConnectionProvider.getConnection().prepareStatement(sql);
            
            // Execute the query
            resultSet = statement.executeQuery();
            
            // Generate HTML output
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Available Items</title>");
            out.println("<style>");
            out.println("table { border-collapse: collapse; width: 100%; }");
            out.println("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println(".home-btn { background-color: #4CAF50; color: white; padding: 10px 20px; text-decoration: none; }");
            out.println(".home-btn:hover { background-color: #45a049; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Available Items</h2>");
            out.println("<a href=\"front.html\" class=\"home-btn\">Home</a>");
            out.println("<table>");
            out.println("<tr><th>Item Code</th><th>Item Name</th><th>Item Price</th><th>Item Quantity</th><th>Total Price</th></tr>");
            while(resultSet.next()) {
                int itemCode = resultSet.getInt("item_code");
                String itemName = resultSet.getString("item_name");
                double itemPrice = resultSet.getDouble("item_price");
                int itemQuantity = resultSet.getInt("item_quantity");
                double totalPrice = resultSet.getDouble("total_price");
                out.println("<tr><td>" + itemCode + "</td><td>" + itemName + "</td><td>" + itemPrice + "</td><td>" + itemQuantity + "</td><td>" + totalPrice + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close all JDBC resources
            try {
                if(resultSet != null) resultSet.close();
                if(statement != null) statement.close();
                if(ConnectionProvider.getConnection()!= null) ConnectionProvider.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

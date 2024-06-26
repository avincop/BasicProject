<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*, java.security.*, java.util.*" %>

<%
try {
    // Get form data
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Connect to the database
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

    // Retrieve user data from the database
    String query = "SELECT * FROM users WHERE username=?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setString(1, username);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        String hashedPassword = rs.getString("password");

        // Compare hashed password with the provided password
        if (hashedPassword.equals(hashPassword(password))) {
            // Passwords match, authentication successful
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp");
        } else {
            // Passwords don't match, authentication failed
            response.sendRedirect("login.jsp?error=1");
        }
    } else {
        // Username not found
        response.sendRedirect("login.jsp?error=1");
    }

    rs.close();
    ps.close();
    con.close();
} catch (Exception e) {
    e.printStackTrace();
    // Handle any errors
    // You might want to display an error message on the login page
}
%>

<%
// Function to hash password (You can use stronger hashing algorithms)
private String hashPassword(String password) {
    String generatedPassword = null;
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    return generatedPassword;
}
%>

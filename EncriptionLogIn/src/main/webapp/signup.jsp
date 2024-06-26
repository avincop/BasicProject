<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.security.NoSuchAlgorithmException, java.security.MessageDigest" %>

<%
/* Plain-text password initialization. */  
String username=request.getParameter("newUsername");
String password = request.getParameter("newPassword");  
String encryptedPassword = null;  
try   
{  
    /* MessageDigest instance for MD5. */  
    MessageDigest m = MessageDigest.getInstance("MD5");  
    
    /* Add plain-text password bytes to digest using MD5 update() method. */  
    m.update(password.getBytes());  
    
    /* Convert the hash value into bytes */   
    byte[] bytes = m.digest();  
    
    /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
    StringBuilder s = new StringBuilder();  
    for(int i=0; i< bytes.length ;i++)  
    {  
        s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
    }  
    
    /* Complete hashed password in hexadecimal format */  
    encryptedPassword = s.toString();  
}   
catch (NoSuchAlgorithmException e)   
{  
    e.printStackTrace();  
}  

/* Display the unencrypted and encrypted passwords. */  
out.println("Plain-text password: " + password);  

out.println("Encrypted password using MD5: " + encryptedPassword);  

Connection con = null;
PreparedStatement ps = null;

try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "123456");

    // Insert user data into the database
    String query = "INSERT INTO table121 (username, password) VALUES (?, ?)";
    ps = con.prepareStatement(query);
    ps.setString(1, username);
    ps.setString(2, encryptedPassword);
    ps.executeUpdate();
    ps.close();
    con.close();

    // Redirect to login page
   
}catch (Exception e) {
        e.printStackTrace();
        // Handle any errors
        // You might want to display an error message on the signup page
    }


%>

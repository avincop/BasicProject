package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyListner implements ServletContextAttributeListener {
	
	
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		String nameString= event.getName();
		Object object= event.getValue();
		System.out.println(nameString+" "+object);
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("replaced");
		String nameString= event.getName();
		Object object= event.getValue();
		System.out.println(nameString+" "+object);
		
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("removed");
	}

}














// try {
//Class.forName("com.mysql.cj.jdbc.Driver");
//connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp");
//PreparedStatement pStatement= connection.prepareStatement("insert into emp12 values(?,?)");
//pStatement.setInt(1, 10);
//pStatement.setString(2, "Avinash");
//// get context
//ServletContext context= sce.getServletContext();
//context.setAttribute("con", connection);
//
//int i=pStatement.executeUpdate();
//
//if(i>0) {
//	System.out.println("record inserted");
//}
//else {
//	System.out.println("error");
//}
//
//} catch (ClassNotFoundException | SQLException e) {
//
//e.printStackTrace();
//}
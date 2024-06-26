package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Handler123 extends TagSupport{
	private String driver;
	private String username;
	private String url;
	private String password;
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out=pageContext.getOut();
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement("select * from table11");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String city=rs.getString("city");
				out.println("id is: "+id+ " " +"name is: "+ name+" "+"city is:"+city);
			}
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}
		return 1;
		
	}

}

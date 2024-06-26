package validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.StudentBean;

public class Validation {
	public int saveData(StudentBean bean) throws ClassNotFoundException, SQLException {
		if(bean.getName().startsWith("a")) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "123456");
			System.out.println("connection got");
			PreparedStatement psmt= connection.prepareStatement("insert into table12 values(?,?)");
			psmt.setInt(1, bean.getId());
			psmt.setString(2, bean.getName());
			int result=psmt.executeUpdate();
			return result;
			
		}
		else {
			return 0;
		}
	}

}

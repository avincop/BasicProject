package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.EmpBean;

public class EmpDataInsertion {
	public int saveData(EmpBean emp) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "123456");
		PreparedStatement ps=con.prepareStatement("insert into table12 values(?,?)");
		ps.setInt(1,emp.getId());
		ps.setString(2, emp.getName());
		int result=ps.executeUpdate();	
		return result;
	}

}

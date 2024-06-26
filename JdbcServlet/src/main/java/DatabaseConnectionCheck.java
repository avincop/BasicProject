import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class DatabaseConnectionCheck {

	public static void main(String[] args) {
		Connection connection;
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url= "jdbc:mysql://localhost:3306/login";
		String username="root";
		String password="123456";
        connection= DriverManager.getConnection(url,username,password);
        System.out.println("connection success");
        String query = "SELECT tId, tName FROM table1";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("tId");
            String name = resultSet.getString("tName");
            System.out.println(id+": id"+name+": name");
            
        }
        
        
        
	} catch (Exception e) {
		 e.printStackTrace();
         System.out.println(e.getMessage());
	}

	}

}

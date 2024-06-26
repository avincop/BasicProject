import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
@WebServlet("/servlet1")
public class FileUpload extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");  
		PrintWriter out = resp.getWriter(); 
				          
		MultipartRequest m=new MultipartRequest(req,"D:\\Advance Java");  
		out.print("successfully uploaded"); 
		
		
	}
			
	
	
	 
}

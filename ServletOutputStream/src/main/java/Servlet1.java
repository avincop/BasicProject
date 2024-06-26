import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpg");//video/mp4 for video file
		
		FileInputStream fis=new FileInputStream("D:\\tools\\im.jpg");
		int ch;
		ServletOutputStream sos= resp.getOutputStream();
		while ((ch=fis.read())!=-1) {
			sos.write(ch);			
		}
		
	}

}

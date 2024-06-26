import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPage extends HttpServlet {
	static File file;
	static FileWriter fw;
	{

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String filepath = "D:/tools/eclipse-jee-2023-06-R-win32-x86_64/eclipse/LoginPage.txt";
		String fileContent = new String(Files.readAllBytes(Paths.get(filepath)));
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		System.out.println("File content:\n" + fileContent);
		if (fileContent.contains(email)) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body>");

			out.println("<h1>You Are Succesfully LogedIn</h1>");
			out.println("</body>");
			out.println("</html>");
		} else {
			out.println("<html>");
			out.println("<head>");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body>");

			out.println("<h1>Please Sign Up first and then try again</h1>");
			out.println("</body>");
			out.println("</html>");
		}
		System.out.println("data added successful");
		out.println("<a href='index.html'>" + "        <button type=\"button\">Go Back</button>\r\n" + "    </a>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String filepath = "D:/tools/eclipse-jee-2023-06-R-win32-x86_64/eclipse/LoginPage.txt";
		String fileContent = new String(Files.readAllBytes(Paths.get(filepath)));
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		System.out.println("File content:\n" + fileContent);
		file = new File("LoginPage.txt");
		file.createNewFile();
		System.out.println(file.exists());
		System.out.println(file.getCanonicalPath());
		String username1 = req.getParameter("username");
		String email1 = req.getParameter("email");
		String dob1 = req.getParameter("dob");
		fw = new FileWriter(file, true);

		if (fileContent.contains(email1)) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body>");

			out.println("<h1>username or email id already registered</h1>");
			out.println("</body>");
			out.println("</html>");
		} else {
			fw.write(username1 + " " + email1 + " " + dob1);
			fw.write("\n");
			fw.flush();
			System.out.println("dopost complete");

			out.println("<html>");
			out.println("<head>");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body>");

			out.println("<h1>You Are Succesfully Signed Up  </h1>");
			out.println("</body>");
			out.println("</html>");
		}

		out.println("<a href='index.html'>" + "        <button type=\"button\">Go Back</button>\r\n" + "    </a>");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		switch (action) {
		case "login":
			doGet(req, resp);
			break;
		case "signup":
			doPost(req, resp);
			break;
		default:
			resp.getWriter().println("Invalid action in doGet");
		}

	}

}

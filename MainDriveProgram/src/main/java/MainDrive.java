import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainDrive extends HttpServlet {
	static ArrayList ar = new ArrayList(); // make a ArrayList static type

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String st = req.getParameter("name");
		PrintWriter out = resp.getWriter();
		if(ar.contains(st)) {
			ar.remove(st);// remove a value from ArrayList at resent added
			// Write HTML content to the response
			out.println("<html>");
			out.println("<head>");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>value successfully removed:" + ar + "</h1>");
			out.println("<a href='index.html'>" + "        <button type=\"button\">Go Back</button>\r\n" + "    </a>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			out.println("<html>");
			out.println("<head>");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>value does't contains</h1>");
			out.println("<a href='index.html'>" + "        <button type=\"button\">Go Back</button>\r\n" + "    </a>");
			out.println("</body>");
			out.println("</html>");
		}
		

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
//        Object st4;
//		Iterator itr= ar.iterator();
//		while (itr.hasNext()) {
//			 st4= itr.next();
//		}
		// Write HTML content to the response
		out.println("<html>");
		out.println("<head>");
		out.println("<title></title>");
		out.println("</head>");
		out.println("<body>");
	    out.println("<table border=\"1\">");
	    out.println("<thead>");
	    out.println("<tr>");
	    out.println("<th>Item</th>");
	    out.println(" </tr>");
	    out.println(" </thead>");
	    out.println("<tbody>");
	    out.println(" <c:forEach var=\"item\" items=\"${requestScope.dataList}\">");
	    out.println(" <tr>");
	    out.println("<td>" + ar + "</td>");
	    out.println(" </tr>");
	    out.println("</c:forEach>");
	    out.println("</tbody>");
	    out.println(" </table>");	    
		//out.println("<h1>your entry is:</h1>");
		out.println("<a href='index.html'>" + "        <button type=\"button\">Go Back</button>\r\n" + "    </a>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String st1 = req.getParameter("name"); // for get value from field name
		ar.add(st1); // add value in ArrayList get value from field name
		PrintWriter out = resp.getWriter();

		// Write HTML content to the response
		out.println("<html>");
		out.println("<head>");
		out.println("<title></title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>value successfully added:" + ar + "</h1>");
		out.println("<a href='index.html'>" + "        <button type=\"button\">Go Back</button>\r\n" + "    </a>");

		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String st2 = req.getParameter("name"); // for get value from field name
		String st3= req.getParameter("name1");
		PrintWriter out = resp.getWriter();
		if(ar.contains(st2)) {
			int i=ar.indexOf(st2);		
			ar.set(i, st3); // replace a value get from field name at resent added
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>value successfully update:" + ar + "</h1>");
			out.println("<a href='index.html'>" + "        <button type=\"button\">Go Back</button>\r\n" + "    </a>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			out.println("<html>");
			out.println("<head>");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>value does't contains</h1>");
			out.println("<a href='index.html'>" + "        <button type=\"button\">Go Back</button>\r\n" + "    </a>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String st = req.getParameter("number"); // get value from field number
		int num = Integer.parseInt(st);// parse string into integer
		switch (num) {
		// call doPost method if user give 1 input
		case 1: {
			doPost(req, resp);
			break;
		}
		// call doGet method if user give input
		case 2: {
			doGet(req, resp);
			break;
		}
		// call doPut method if user give 3 input
		case 3: {
			doPut(req, resp);
			break;
		}
		// call doDelete method if user give 4 input
		case 4: {
			doDelete(req, resp);
			break;
		}
		// show closing massage if user give 0 input
		case 0: {

			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>PrintWriter Example</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Thank Your! Program Closed</h1>");

			out.println("</body>");
			out.println("</html>");

			Thread thread = new Thread(() -> {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				System.exit(0);
			});
			thread.start();

		}
		}
	}
}

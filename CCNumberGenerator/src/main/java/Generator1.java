import java.io.IOException;
import java.io.PrintWriter;
import java.lang.module.ResolutionException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Generator1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		Printprintlnr pw= resp.getprintlnr();
//		String name= req.getParameter("fname");
//		pw.println("Hello Mr. "+name+"  ");
//		 long lowerBound = 8000000000L;
//	        long upperBound = 9999999999L;
//	        pw.println("<br>");
//	        pw.println("mobile number is ");
//	        pw.println("<br>");
//
//	        Random random = new Random();
//	        for(int i=0;i<20;i++) {
//	        	long generatedNumber = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound));
//		       pw.println("+91"+String.valueOf(generatedNumber));
//		       pw.println("<br>");
//	        }

		resp.setContentType("text/html");
		
		PrintWriter pw= resp.getWriter();
		String name = req.getParameter("fname");
		pw.println("Hello Mr. " + name + "  ");
		pw.println("<br>");
		pw.println("Mobile numbers are: ");
		pw.println("<br>");
		pw.println("<table border='1'>");
		long lowerBound = 8000000000L;
		long upperBound = 9999999999L;
		Random random = new Random();
		pw.println("<tr><th>Serial Number</th><th>Mobile Number</th></tr>");
		for (int i = 1; i <= 20; i++) {
			long generatedNumber = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound));
			pw.println("<tr><td>" + i + "</td><td>+91" + generatedNumber + "</td></tr>");
		}
		pw.println("</table>");

		pw.println("credit card number:");

		long lowerBound1 = 1000000000000000L;
		long upperBound1 = 9999999999999999L;
		Random random1 = new Random();

		pw.print("<table border='1'>");
		pw.print("<tr><th>Serial Number</th><th>Creadit Card Number</th></tr>");

		for (int j = 1; j <= 20; j++) {
			long generatedNumber1 = lowerBound1 + (long) (random1.nextDouble() * (upperBound1 - lowerBound1));
			String geneString = String.valueOf(generatedNumber1);

			StringBuilder formattedNumber = new StringBuilder();
			for (int i = 0; i < geneString.length(); i++) {
				if (i > 0 && i % 4 == 0) {
					formattedNumber.append("-");
				}
				formattedNumber.append(geneString.charAt(i));
			}

			String finalFormattedNumber = formattedNumber.toString();

			pw.print("<tr><td>" + j + "</td><td>" + finalFormattedNumber + "</td></tr>");
		}

		pw.print("</table>");

	}

}

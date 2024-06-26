import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the ServletInputStream from the request object
        ServletInputStream inputStream = request.getInputStream();

        // Read data from the input stream
        StringBuilder requestData = new StringBuilder();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            String chunk = new String(buffer, 0, bytesRead);
            requestData.append(chunk);
        }

        // Close the input stream
        inputStream.close();

        // Do something with the received data
        String receivedData = requestData.toString();
        System.out.println("Received data: " + receivedData);

        // Send response
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Data received successfully!");
    }
}

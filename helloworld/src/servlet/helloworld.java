package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
			printWriter.println("<h2>");
			printWriter.println("Hello World");
			printWriter.println("</h2>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
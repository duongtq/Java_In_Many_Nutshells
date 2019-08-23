package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/servlet"}, description = "A hello world servlet")
public class servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public servlet() {
		super();
	};
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h2>Servlet</h2>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}

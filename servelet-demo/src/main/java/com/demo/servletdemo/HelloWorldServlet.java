package com.demo.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public HelloWorldServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
			throws ServletException, IOException {
//		set content type since the data sent out is of html type text
		response.setContentType("text/html");

//		get the printwriter
		PrintWriter out = response.getWriter();

//		generate html content
		out.println("<html><body>");

		out.println("<h2>Hello World</h2>");
		out.println("<hr>");
		out.println("Time on server is: " + new java.util.Date());
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

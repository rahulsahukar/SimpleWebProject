package com.rahul.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.soap.InitParam;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "First Servlet", urlPatterns = { "/SimpleServlet" }, 
		initParams=@WebInitParam(name="user",value="sahukar"))
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("First Servlet!!!");
		String userName = request.getParameter("userName");;
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if(userName!="" && userName!=null){
			session.setAttribute("userName", userName);
			context.setAttribute("userName", userName);
		}
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Request - My name is "+userName+"</h1>");
		printWriter.println("<h1>Session - My name is "+ session.getAttribute("userName") +"</h1>");
		printWriter.println("<h1>Context - My name is "+ context.getAttribute("userName") +"</h1>");

		String initDefaultUser = getServletConfig().getInitParameter("user");
		printWriter.println("<h2>Default - My name is "+initDefaultUser+"</h2>");
		String initValue = getServletConfig().getInitParameter("default");
		printWriter.println("<h2>Init Value - My name is "+initValue+"</h2>");
	}

}

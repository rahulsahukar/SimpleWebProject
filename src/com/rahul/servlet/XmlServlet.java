package com.rahul.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String userName = request.getParameter("userName");
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("Hello "+userName+"!!!");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String userName = request.getParameter("userName");
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("Post - Hello "+userName+"!!!");
	}
}

package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.getWriter().println("All the best for the exam");
	}
	
	@Override
	public void init() {
		//*****************  here you can initiate instaces for servlet context
	}

	@Override
	public void destroy() {
	}
}

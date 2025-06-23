package com.sunbeam.servlets;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/announcements")
public class AnnouncementServelate  extends HttpServlet{

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processReuest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processReuest(req, resp);
	}
	
	protected void processReuest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ann = req.getParameter("ann");
		// store announcement in servlet context -- attribute
		ServletContext ctx = req.getServletContext();
		ctx.setAttribute("annmsg", ann);
		// go to result servlet
		resp.sendRedirect("result");
	}
	
	
	
	
	
	
	
     
}

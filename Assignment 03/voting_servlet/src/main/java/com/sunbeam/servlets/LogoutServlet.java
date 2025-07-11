package com.sunbeam.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

@WebServlet("/logout")

public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req,resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		resp.setContentType("text/html");
	    PrintWriter out=resp.getWriter();
	    
	    
	    out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Thank You!</h2>");
		
		String userName = "";
		Cookie[] arr = req.getCookies();
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname"))
					userName = c.getValue();
			}
		}
		out.println("Hello, " + userName + "<hr/>");

		// destroy the cookie
		Cookie c = new Cookie("uname", "");
		//c.setMaxAge(-1); // convert persistent cookie to temp cookie //use only one of the methods
		c.setMaxAge(0); // delete the cookie from browser
		resp.addCookie(c);
		
		HttpSession session=req.getSession();
		session.invalidate();
		
		out.println("<a href='index.html'>Login Again</a>");
		out.println("</body>");
		out.println("</html>");

	}	
}

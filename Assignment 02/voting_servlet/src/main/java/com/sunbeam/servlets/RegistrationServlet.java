package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
      
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Date birth = Date.valueOf(req.getParameter("birth"));
		
		

		try(UserDao userDao = new UserDaoImpl()) {
			
			User user = new User(0, firstName,lastName, email,password, birth, false, "voter");
			int cnt = userDao.save(user);
			System.out.println("User saved: " + cnt);
	
			if(cnt ==1) {
//				System.out.println("Registration Successful!!");
//				if(user.getRole().equals("voter")) {
//					resp.sendRedirect("login");
//				}
				
				
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Register</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Registration Successful</h2>");
				out.println("<a href='index.html'>Login here!</a>");
				out.println("</body>");
				out.println("</html>");
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Register</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Registration Failed</h2>");
				out.println("<a href='register.html'>Register Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		
	}
}

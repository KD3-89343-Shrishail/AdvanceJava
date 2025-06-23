package com.sunbeam.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addcandidate")
public class AddCandateServelate extends HttpServlet {
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
      
		String name=req.getParameter("name");
		String party=req.getParameter("party");
		int votes=Integer.parseInt(req.getParameter("votes"));
		
		

		try(CandidateDao candidateDao = new CandidateDaoImpl()) {
		
			Candidate c=new Candidate(0, name, party, votes);
			int cnt = candidateDao.save(c);
			System.out.println("User saved: " + cnt);
	
			if(cnt ==1) {
					resp.sendRedirect("result");

				
				
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
				out.println("<a href='newcandidate.html'>Register Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		
	}
}

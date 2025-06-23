package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list = new ArrayList<>();
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			list = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();	
			throw new ServletException(e); 	
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>All Candidate Information</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Candidates list</h2>");
		out.println("<table border=1> <thead> <tr> <th>Id</th> <th>Name</th><th>Party</th><th>votes</th></tr>");
		out.println("<tbody>");
		for (Candidate cand : list) {
			
			out.printf("<tr><td>%d</td><td>%s</td><td>%s</td><td>%d</td> </tr>",
					cand.getId(), cand.getName(), cand.getParty(),cand.getVotes());
		}
		out.println("</tbody>");
		out.println("</table>");
		
		out.println("<hr/>");
		out.println("<hr/>");
		
		
		out.println(" <a href='newcandidate.html'>Add New Candidate</a>");
		out.println("</body>");
		out.println("</html>");

	}
}

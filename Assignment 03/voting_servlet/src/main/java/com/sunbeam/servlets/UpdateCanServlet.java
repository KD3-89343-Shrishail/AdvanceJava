package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateCanServlet extends HttpServlet {

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
		String canId = req.getParameter("candid");
		int id = Integer.parseInt(canId);
		
		try(CandidateDao candDao = new CandidateDaoImpl()){
			

		Candidate  candidate= candDao.findById(id);
		
		if(candidate!=null) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Vote</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Edit Candidate</h2>");
			out.println("<form method= 'post'  action='addCandidate'>");
			
			
			out.printf("Id:<input type = 'text' name = 'candidate' value = '%d' readonly/>",candidate.getId() );
			
			out.println("<br/>");
			out.printf("Name:<input type='text' name = 'name' value= '%s' />", candidate.getName());
			
			out.println("<br/>");
			
			out.printf("Party:<input type='text' name = 'party' value='%s' />", candidate.getParty());
			
			out.println("<br/>");
			out.printf("Votes:<input type='text' name = 'votes' value='%d' readonly />", candidate.getVotes());
			
			out.println("<br/>");
			out.println("<input type='submit' value= 'edit'> </a>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	

			

	}
}

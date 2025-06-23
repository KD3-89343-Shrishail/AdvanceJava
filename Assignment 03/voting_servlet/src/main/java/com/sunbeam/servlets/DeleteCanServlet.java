package com.sunbeam.servlets;

import java.io.IOException;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteCanServlet extends HttpServlet {

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
		String canId=req.getParameter("candid");
		int id=Integer.parseInt(canId);
		
		try(CandidateDao candidateDao=new CandidateDaoImpl()){
			int count=candidateDao.deleteById(id);
			
			System.out.println("candidate deleted "+count);
			
			String msg = "Candiates deleted: " + count;
			req.setAttribute("msg", msg);
			
			RequestDispatcher rd=req.getRequestDispatcher("result");
			rd.forward(req, resp);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

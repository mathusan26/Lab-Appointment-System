package com.hms.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.dao.TechnicianDAO;
import com.hms.db.DBConnection;

@WebServlet("/deleteTech")
public class DeleteTechnicianServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				//get id(which is coming as string value) and convert into int	
				int id = Integer.parseInt(req.getParameter("id"));
				
				TechnicianDAO techDAO = new TechnicianDAO(DBConnection.getConn());
				HttpSession session = req.getSession();
				
				boolean f = techDAO.deleteTechnicianById(id);
				
				if(f==true) {
					session.setAttribute("successMsg", "Technician Deleted Successfully.");
					resp.sendRedirect("admin/technician/view_technician.jsp");
				}
				else {
					session.setAttribute("errorMsg", "Something went wrong on server!");
					resp.sendRedirect("admin/technician/view_technician.jsp");
				}
			}
			
			

}

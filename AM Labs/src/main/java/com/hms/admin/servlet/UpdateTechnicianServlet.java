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
import com.hms.entity.Technician;

@WebServlet("/updateTechnician")

public class UpdateTechnicianServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				try {

					String technicianName = req.getParameter("technicianName");
					int testFieldId = Integer.parseInt(req.getParameter("testField"));
					String address = req.getParameter("address");
					int phone = Integer.parseInt(req.getParameter("phone"));
					int age = Integer.parseInt(req.getParameter("age"));
				
					
					int id = Integer.parseInt(req.getParameter("technicianId"));


					Technician tech = new Technician(id,technicianName, testFieldId, address, phone, age);
					

					TechnicianDAO techDAO = new TechnicianDAO(DBConnection.getConn());

					boolean f = techDAO.updateTechnicianName(tech);

					HttpSession session = req.getSession();

					if (f == true) {
						session.setAttribute("successMsg", "Technicain update Successfully");
						resp.sendRedirect("admin/technician/view_technician.jsp");

					} else {
						session.setAttribute("errorMsg", "Something went wrong on server!");
						resp.sendRedirect("admin/technician/view_technician.jsp");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}


}

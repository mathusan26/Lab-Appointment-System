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

@WebServlet("/addTechnician")
public class AddTechnicianServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

					try {

						String technicianName = req.getParameter("technicianName");
						String testField = req.getParameter("testField");
						String address = req.getParameter("address");
						int phone = Integer.parseInt(req.getParameter("phone"));
						int age = Integer.parseInt(req.getParameter("age"));
					
						Technician tech = new Technician(technicianName, testField, address, phone, age);

						TechnicianDAO techDAO = new TechnicianDAO(DBConnection.getConn());

						boolean f = techDAO.addSTechnician(tech);

						HttpSession session = req.getSession();

						if (f == true) {
							session.setAttribute("successMsg", "Technicain added Successfully");
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



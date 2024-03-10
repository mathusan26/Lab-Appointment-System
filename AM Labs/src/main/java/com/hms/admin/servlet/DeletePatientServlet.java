package com.hms.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.db.DBConnection;
import com.hms.pat.PatientDAO;

@WebServlet("/deletePatient")
public class DeletePatientServlet extends HttpServlet{

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				//get id(which is coming as string value) and convert into int	
				int id = Integer.parseInt(req.getParameter("id"));
				
				PatientDAO patientDAO = new PatientDAO(DBConnection.getConn());
				HttpSession session = req.getSession();
				
				boolean f = patientDAO.deletePatientById(id);
				
				if(f==true) {
					session.setAttribute("successMsg", "Patient Deleted Successfully.");
					resp.sendRedirect("admin/patient/view_patient.jsp");
				}
				else {
					session.setAttribute("errorMsg", "Patient went wrong on server!");
					resp.sendRedirect("admin/patient/view_patient.jsp");
				}
			}
			
			

		}


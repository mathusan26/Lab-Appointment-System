package com.hms.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.dao.AppointmentDAO;
import com.hms.db.DBConnection;
import com.hms.entity.Appointment;

public class UpdateAppointmentStatusServlet extends HttpServlet{


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
					
			int id = Integer.parseInt(req.getParameter("technicianId"));

			Appointment tech = new Appointment(id);

			AppointmentDAO techDAO = new AppointmentDAO(DBConnection.getConn());

			boolean f = techDAO.cancelAppointment(id);

			HttpSession session = req.getSession();

			if (f == true) {
				session.setAttribute("successMsg", "Appointment Cancelled Successfully");
				resp.sendRedirect("admin/appointment/view_appointment.jsp");

			} else {
				session.setAttribute("errorMsg", "Something went wrong on server!");
				resp.sendRedirect("admin/appointment/view_appointment.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}

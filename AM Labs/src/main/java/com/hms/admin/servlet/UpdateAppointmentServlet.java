package com.hms.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.dao.AppointmentDAO;
import com.hms.db.DBConnection;
import com.hms.entity.Appointment;

@WebServlet("/updateAappointment")
public class UpdateAppointmentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				try {

					// get all data which is coming from doctor.jsp doctor details
				
					String dateAndTime = req.getParameter("dateAndTime");
					int statusId = Integer.parseInt(req.getParameter("statusId"));
					
					//here need to get id also...for updating the doctor details
					//doctors will update based on respective doctor's id
					int id = Integer.parseInt(req.getParameter("appoinmentId"));
					
					Appointment appoinment = new Appointment(dateAndTime,statusId,id);

					AppointmentDAO appoinmentDAO = new AppointmentDAO(DBConnection.getConn());

					boolean f = appoinmentDAO.updateAppointmentStatusORDate(appoinment);

					HttpSession session = req.getSession();

					if (f == true) {
						session.setAttribute("successMsg", "Appointment update Successfully");
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

package com.hms.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.dao.AppointmentDAO;
import com.hms.dao.TestDAO;
import com.hms.db.DBConnection;
import com.hms.entity.Appointment;
import com.hms.entity.Test;

@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	int patientId	= Integer.parseInt(req.getParameter("patientId"));
	String dateAndTime = req.getParameter("dateAndTime");
	int testId = Integer.parseInt(req.getParameter("testId"));
	String doctor = req.getParameter("doctor");
	int statusId = 6;
	
	
	
	TestDAO testDAO =new TestDAO(DBConnection.getConn());
	Test test = testDAO.getTestById(testId);
	
	Appointment appointment = new Appointment(patientId, dateAndTime, doctor, testId,statusId, test.getPrice());
	
	
	AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConn());
	boolean f = appointmentDAO.addAppointment(appointment);
	
	//get session
	HttpSession session = req.getSession();
	
	if(f==true) {
		
//		session.setAttribute("successMsg", "Appointment is recorded Successfully.");
		Appointment LastAppointment = appointmentDAO.getLastAppointment();
		resp.sendRedirect("payment.jsp?id="+LastAppointment.getId());
		
		
	}
	else {
		
		session.setAttribute("errorMsg", "Something went wrong on server!");
		resp.sendRedirect("user_appointment.jsp");
		
	}
	
	
	
	
		
	}

	
}

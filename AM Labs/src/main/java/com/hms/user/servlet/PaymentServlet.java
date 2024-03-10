package com.hms.user.servlet;

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

@WebServlet("/Payment")
public class PaymentServlet extends HttpServlet {
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			try {

				double price = Double.parseDouble(req.getParameter("price"));
				int id = Integer.parseInt(req.getParameter("id"));

//				Appointment appointment = new Appointment( id,price);

				AppointmentDAO appoDAO = new AppointmentDAO(DBConnection.getConn());

				boolean f = appoDAO.updateAppointmentPrice(id,price);

				HttpSession session = req.getSession();

				if (f == true) {
					
					session.setAttribute("successMsg", "Payment made Successfully");
					resp.sendRedirect("view_appointment.jsp");

				} else {
					session.setAttribute("errorMsg", "Something went wrong on server!");
					resp.sendRedirect("view_appointment.jsp");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}


		}
	


}

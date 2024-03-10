package com.hms.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.db.DBConnection;
import com.hms.entity.Patient_details;
import com.hms.pat.PatientDAO;

@WebServlet("/updatePatient")
public class UpdatePatientServlet extends HttpServlet{


		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {

				// get all data which is coming from doctor.jsp doctor details
				String patientName = req.getParameter("patientName");
				String dateOfBirth = req.getParameter("dateOfBirth");
				int age = Integer.parseInt(req.getParameter("age"));
				String address = req.getParameter("address");
				String gender = req.getParameter("gender");
				String email = req.getParameter("email");
				String phone = req.getParameter("phone");
				String password = req.getParameter("password");
				
				//here need to get id also...for updating the doctor details
				//doctors will update based on respective doctor's id
				int id = Integer.parseInt(req.getParameter("patientId"));
				
				Patient_details patient = new Patient_details( id,  patientName,  dateOfBirth,  email,  phone,  gender,
						 age,  address, password);

				PatientDAO patientDAO = new PatientDAO(DBConnection.getConn());

				boolean f = patientDAO.updatePatient(patient);

				HttpSession session = req.getSession();

				if (f == true) {
					session.setAttribute("successMsg", "Patient update Successfully");
					resp.sendRedirect("admin/patient/view_patient.jsp");

				} else {
					session.setAttribute("errorMsg", "Something went wrong on server!");
					resp.sendRedirect("admin/patient/view_patient.jsp");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

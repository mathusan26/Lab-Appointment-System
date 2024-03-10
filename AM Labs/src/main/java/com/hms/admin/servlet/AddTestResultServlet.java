package com.hms.admin.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.hms.dao.TestResultDAO;
import com.hms.db.DBConnection;
import com.hms.entity.TestResult;

@WebServlet("/addTestResult")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)

public class AddTestResultServlet extends HttpServlet{
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				int appointmentId = Integer.parseInt(req.getParameter("appointmentId"));
				int patientId = Integer.parseInt(req.getParameter("patientId"));
				int testId = Integer.parseInt(req.getParameter("testId"));
				int technicianId = Integer.parseInt(req.getParameter("technicianId"));
				int statusId = Integer.parseInt(req.getParameter("statusId"));
	
				InputStream inputStream = null; // input stream of the upload file
		         
		        // obtains the upload file part in this multipart request
		        Part filePart = req.getPart("testResult");
		        if (filePart != null) {
		            // prints out some information for debugging
		            System.out.println(filePart.getName());
		            System.out.println(filePart.getSize());
		            System.out.println(filePart.getContentType());
		             
		            // obtains input stream of the upload file
		            inputStream = filePart.getInputStream();
		        }
		

				TestResult test = new TestResult(patientId, appointmentId,  inputStream,  technicianId,  testId, statusId);
				
				TestResultDAO testResultDAO = new TestResultDAO(DBConnection.getConn());

				boolean f = testResultDAO.addTestResult(test);

				HttpSession session = req.getSession();

				if (f == true) {
					session.setAttribute("successMsg", "Test Result added Successfully");
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

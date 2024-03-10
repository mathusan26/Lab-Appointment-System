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

@WebServlet("/addPatient")
public class AddPatientServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {

				// PrintWriter out = resp.getWriter();

				// get all data/value which is coming from signup.jsp page for new User
				// registration
				String patientName = req.getParameter("patientName");
				int age =  Integer.parseInt(req.getParameter("age"));
				String dateOfBirth =  req.getParameter("dateOfBirth");
				String email = req.getParameter("email");
				String gender = req.getParameter("gender");
				String phone =  req.getParameter("age");
				String address = req.getParameter("address");
				String password = req.getParameter("password");

				// Set all data to User Entity
				Patient_details patient = new Patient_details( patientName,  dateOfBirth,  email,  phone,  gender,
						 age,  address, password);

				// Create Connection with DB
				PatientDAO patientDAO = new PatientDAO(DBConnection.getConn());
				
				//get session
				HttpSession session = req.getSession();
				

				// call userRegister() and pass user object to insert or save user into DB.
				boolean f = patientDAO.patientRegister(patient); // userRegister() method return boolean type value
				Patient_details createdPatient = patientDAO.LastCreatedPatient();
				String uniqueReference = "AMPAT" + createdPatient.getId();
				boolean g = patientDAO.updatePatientReference(createdPatient.getId(),uniqueReference);

				if (f == true && g== true) {

					session.setAttribute("successMsg", "Patient Added Successfully");
					resp.sendRedirect("admin/patient/view_patient.jsp");//which page you want to show this msg
					//System.out.println("register successfull");
					// out.println("success");

				} else {
					
					session.setAttribute("errorMsg", "Something went wrong!");
					resp.sendRedirect("admin/patient/view_patient.jsp");//which page you want to show this msg
					
					//System.out.println("Error! Something went wrong");
					// out.println("error");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}


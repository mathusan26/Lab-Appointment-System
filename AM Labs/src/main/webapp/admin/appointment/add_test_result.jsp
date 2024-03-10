<%@page import="com.hms.entity.Appointment"%>
<%@page import="com.hms.dao.AppointmentDAO"%>
<%@page import="com.hms.entity.Technician"%>
<%@page import="com.hms.dao.TechnicianDAO"%>
<%@page import="com.hms.entity.Patient_details"%>
<%@page import="com.hms.pat.PatientDAO"%>
<%@page import="com.hms.entity.Test"%>
<%@page import="com.hms.dao.TestDAO"%>
<%@page import="com.hms.entity.Status"%>
<%@page import="com.hms.dao.StatusDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- for jstl tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- end of jstl tag -->

<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test page</title>
<%@include file="../../component/allcss.jsp"%>

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px rgba(0,0,0,0.1);
	/*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}
</style>
<!-- end of customs css for this page -->

</head>
<body>
	<%@include file="navbar_appointment.jsp"%>


	<div class="container p-5">
		<div class="row">
			
			<div class="col-md-4 offset-md-4">
				<div class="card my-card">
					<div class="card-header text-center text-white my-bg-color">
						<!-- <p class="fs-4 text-center mt-1"><i class="fa-solid fa-users"></i> <br>User Login</p> -->
						<p class="fs-4 text-center text-white mt-2">
							<i class="fa-solid fa-user-doctor"></i> Add Test Result
						</p>
					</div>
					<div class="card-body">

						<!-- message print -->
						<!-- for success msg -->
						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fs-3">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<!-- for error msg -->
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-success fs-3">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<!-- End of message print -->

						<!-- table for doctor list -->

						<%
						//get specific doctor id with the help of request.getParameter() 
						//which is coming from url for doctor editing(which i pass through url when press edit doctor)...
						int id = Integer.parseInt(request.getParameter("id")); //this "id" is prefix name in URL
						AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConn());
						PatientDAO patientDAO =new PatientDAO(DBConnection.getConn());
						TechnicianDAO techDAO= new  TechnicianDAO(DBConnection.getConn());
						TestDAO testDAO= new  TestDAO(DBConnection.getConn());
						StatusDAO statusDAO= new  StatusDAO(DBConnection.getConn());
						Appointment appo = appointmentDAO.getAppointmentById(id);
						Patient_details patient = patientDAO.getPatientById(appo.getPatientId());
						//Technician tech = techDAO.getTechnicianById(id);//call getDoctorById(id) which return doctor of specific id
						Test test = testDAO.getTestById(appo.getTest());
						
						%>
						<div class="mb-3">
								<label class="form-label">Patient Name</label> <input
									name="patientName" type="text" placeholder="Enter Patient Name"
									class="form-control" disabled value="<%=patient.getPatientName()%>">

						</div>
						<div class="mb-3">
								<label class="form-label">Test Name</label> <input
									name="testName" type="text" placeholder="Enter Test Name" 
									class="form-control" disabled value="<%=test.getTestName()%>">

							</div>
						<form action="../../addTestResult" method="post" enctype="multipart/form-data">
							
							<div class="mb-3">
								<label class="form-label">Technician Name</label> <select
								 required="required" class="form-control" name="technicianId">
									<option selected="selected" disabled="disabled">---Select---</option>
									
									<%
									
									List<Technician> listOfTech = techDAO.getAllTechnician();
									for(Technician t : listOfTech)
									
									{%>
									<!-- actually we take id of doctor from doctor table -->
									<option value="<%= t.getId() %>"> <%= t.getTechnicianName()%> </option>
									
									<%
									}
									%>
									
									<!-- <option>Doctor name</option> -->
								</select>

							</div>
							<div class="mb-3">
								<label class="form-label">Status</label> <select
								 required="required" class="form-control" name="statusId">
									<option selected="selected" disabled="disabled">---Select---</option>
									
									<%
									
									List<Status> listOfStatus = statusDAO.getStatusForAppointment(1);
									for(Status t : listOfStatus)
									
									{%>
									<!-- actually we take id of doctor from doctor table -->
									<option value="<%= t.getId() %>"> <%= t.getStatusName()%> </option>
									
									<%
									}
									%>
									
									<!-- <option>Doctor name</option> -->
								</select>

							</div>
							
							
							
							<div class="mb-3">
								<label class="form-label">Upload Test Result</label> <input
									name="testResult" type="file" placeholder="Upload Test Result"
									class="form-control" >

							</div>
							
					
							<div class="mb-3">
								<input name="appointmentId" type="hidden" class="form-control"
									value="<%=appo.getId()%>">
							</div>
							<div class="mb-3">
								<input name="testId" type="hidden" class="form-control"
									value="<%=test.getId()%>">
							</div>
							<div class="mb-3">
								<input name=patientId type="hidden" class="form-control"
									value="<%=patient.getId()%>">
							</div>
							
							

							<button type="submit" class="btn btn-success text-white col-md-12">Submit</button>
						</form>
							

						<!-- end table for doctor list -->


					</div>

				</div>
			</div>
		</div>
	</div>



</body>
</html>
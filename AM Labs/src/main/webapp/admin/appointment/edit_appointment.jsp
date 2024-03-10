<%@page import="com.hms.entity.Doctor"%>
<%@page import="com.hms.entity.Test"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.db.DBConnection"%>
<%@page import="com.hms.dao.DoctorDAO"%>
<%@page import="com.hms.dao.TestDAO"%>
<%@page import="com.hms.entity.Patient_details"%>
<%@page import="com.hms.pat.PatientDAO"%>
<%@page import="com.hms.dao.StatusDAO"%>
<%@page import="com.hms.entity.Status"%>

<%@page import="com.hms.entity.Appointment"%>
<%@page import="com.hms.dao.AppointmentDAO"%>
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
<title>User Appointment Page</title>
<!-- all css include -->
<%@include file="../../component/allcss.jsp"%>

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px rgba(0,0,0,.125);
	/*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}

/* backgournd image css */

.my-bg-img{
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),url("img/hospital1.jpg");
	height: 20vh;
	width: 100%;
	background-size:cover;
	background-repeat: no-repeat;
	
}

/* backgournd image css */
</style>
<!-- end of customs css for this page -->

</head>
<body>
	<%@include file="navbar_appointment.jsp"%>

	<!-- start 1st Div -->

	<!-- end of 1st Div -->


	<!-- 2nd Div -->

	<div class="container p-3">
		<p class="fs-2"></p>

		<div class="row">
			
			<!-- col-1 -->
			<div class="col-md-4 p-5">
				<!-- for Background image -->
				<!-- <img alt="" src="img/picDoc.jpg" width="500px" height="400px"> -->
				<img alt="" src="img/doc3.jpg" width="370" height="">
			</div>
			
			<!-- col-2 -->
			<div class="col-md-8">
				<c:if test="${not empty userObj}">

				<div class="col-md-12 d-flex pb-3 justify-content-end">
					<!-- <div>
						<a aria-current="page" href="user_appointment.jsp" class="btn btn-success active"><i class="fa fa-book fa-1x"></i> ADD APPOINTMENT</a>
					</div> -->
					<div>
						<a aria-current="page" href="view_appointment.jsp" class="btn btn-success active"><i class="fa fa-calendar-check-o"></i> VIEW APPOINTMENT</a>
					</div>
				</div>

				</c:if>
				<div class="card my-card">
					<div class="card-body">
						<p class="text-center fs-3">Edit Appointment</p>

						<!-- message print -->
						<!-- for success msg -->
						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fs-5">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<!-- for error msg -->
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<!-- End of message print -->
						<%
						//get specific doctor id with the help of request.getParameter() 
						//which is coming from url for doctor editing(which i pass through url when press edit doctor)...
						int id = Integer.parseInt(request.getParameter("id")); //this "id" is prefix name in URL
						AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConn());
						TestDAO testDAO = new TestDAO(DBConnection.getConn());
						StatusDAO statusDAO = new StatusDAO(DBConnection.getConn());
						PatientDAO patientDAO = new PatientDAO(DBConnection.getConn());
						Appointment appointment = appointmentDAO.getAppointmentById(id);//call getDoctorById(id) which return doctor of specific id
						Test test = testDAO.getTestById(appointment.getTest());
						Status status = statusDAO.getStatusById(appointment.getStatus());
						Patient_details patient =patientDAO.getPatientById(appointment.getPatientId());
						%>

						<!-- boostrap form -->
						<div class="row">
							<div class="col-md-12">
								<label class="form-label">Patient Name </label> 
								<input type="text" required="required"	name="name" disabled class="form-control" value="<%=patient.getPatientName()%>">
							</div>
						</div>
						<form class="row g-3" action="../../updateAappointment" method="post">
							
							<!-- take user Id in hidden field -->
							<input type="hidden" name="patientId" value="1">
							
							<div class="col-md-6">
								<label class="form-label">Appointment Date</label> <input
								required="required"	name="dateAndTime" type="date" class="form-control" value="<%=appointment.getDateAndTime()%>">
							</div>
							
							<div class="col-md-6">
								<label class="form-label">Doctor Name</label> <input required="required"
									name="doctor" type="text" placeholder="Enter doctor name"
									class="form-control" disabled value="<%=appointment.getDoctor()%>">
							</div>
							
							<div class="col-md-6">
								<label class="form-label">Test</label> <input required="required"
									name="testId" type="text" placeholder="Enter doctor name"
									class="form-control" disabled value="<%=test.getTestName()%>">
							</div>
							
							<div class="col-md-6">
								<label class="form-label">Status</label> <select
								 required="required" class="form-control" name="statusId">
									<option selected="selected" disabled="disabled">---Select---</option>
									
									<%
									
									List<Status> listOfStatus = statusDAO.getStatusForAppointment(0);
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
								<input name="appoinmentId" type="hidden" class="form-control"
									value="<%=appointment.getId()%>">
							</div>
							

							<button type="submit" class="btn my-bg-color text-white col-md-12">Update</button>
					
						</form>

						<!-- end of boostrap form -->

					</div>
				</div>

			</div>



		</div>


	</div>

	<!-- 2nd Div -->















</body>
</html>
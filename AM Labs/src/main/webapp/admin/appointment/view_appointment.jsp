<%@page import="com.hms.dao.AppointmentDAO"%>
<%@page import="com.hms.entity.Appointment"%>
<%@page import="com.hms.dao.TestDAO"%>
<%@page import="com.hms.entity.Test"%>
<%@page import="com.hms.dao.StatusDAO"%>
<%@page import="com.hms.entity.Status"%>
<%@page import="com.hms.pat.PatientDAO"%>
<%@page import="com.hms.entity.Patient_details"%>
<%@page import="com.hms.dao.TestResultDAO"%>
<%@page import="com.hms.entity.TestResult"%>
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
<title>Patient page</title>
<%@include file="../../component/allcss.jsp"%>

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px rgba(0,0,0,0.2);
	/*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}
.clickLink{
pointer-events:none;
cursor: not-allowed;
}
</style>
<!-- end of customs css for this page -->

</head>
<body>
	<%@include file="navbar_appointment.jsp"%>


	<div class="container-float p-3">
		<div class="row">
			
			<div class="col-md-12">
				<div class="card my-card">
					<div class="card-body">
						<p class="fs-3 text-center text-danger">List of Appointments</p>

						<!-- message print -->
						<!-- for success msg -->
						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fs-3">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<!-- for error msg -->
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-3">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<!-- End of message print -->

						<!-- table for doctor list -->

						<table class="table table-striped">
							<thead>
								<tr class="table-info">
									<th scope="col">No</th> 
									<th scope="col">Patient Name</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Test</th>
									<th scope="col">Status</th>
									
									<th colspan="3" class="text-center" scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConn());
								TestDAO testDAO = new TestDAO(DBConnection.getConn());
								StatusDAO statusDAO = new StatusDAO(DBConnection.getConn());
								PatientDAO patientDAO = new PatientDAO(DBConnection.getConn());
								TestResultDAO resultDAO = new TestResultDAO(DBConnection.getConn());
								List<Appointment> listOfAppointment = appointmentDAO.getAllAppointment();
								int index =1;
								for (Appointment appinmentList : listOfAppointment) {
									Test test = testDAO.getTestById(appinmentList.getTest());
									Status status = statusDAO.getStatusById(appinmentList.getStatus());
									Patient_details patient = patientDAO.getPatientById(appinmentList.getPatientId());
									TestResult result = resultDAO.getResultByAppointmentId(appinmentList.getId());
									
								%>
								<tr>
									<%-- <th scope="row"><%= doctorLst.getId()%></th> --%>
									<td scope="row"><%= index %></td>
									<th><%=patient.getPatientName()%></th>
									<td><%=appinmentList.getDoctor()%></td>
									<td><%=appinmentList.getDateAndTime()%></td>
									<td><%=test.getTestName()%></td>
									<td><%=status.getStatusName()%></td>
								
										
									<td colspan="2" class="d-flex justify-content-evenly">
									<a class="btn btn-sm btn-primary <%=(status.getStatusName().toLowerCase().equals("cancel"))? "clickLink" :""%>"
										href="edit_appointment.jsp?id=<%=appinmentList.getId()%>">Edit</a>
										
									<a class="btn btn-sm btn-danger <%=(status.getStatusName().toLowerCase().equals("cancel"))? "clickLink" :""%> "onclick="return confirm(&quot;Click Ok to cancel <%=patient.getPatientName()%>'s appointment.&quot;)" href="../../cancelAppointment?id=<%= appinmentList.getId() %>">Cancel</a>
									
										
										<%
										if (result == null) {
										%> <a class="btn btn-sm btn-success <%=(status.getStatusName().toLowerCase().equals("cancel"))? "clickLink" :""%>" href="add_test_result.jsp?id=<%= appinmentList.getId() %>">Add Result</a> <%
 										} else {
										 %>  <a class="btn btn-sm btn-success <%=(status.getStatusName().toLowerCase().equals("cancel"))? "clickLink" :""%>" href="../../viewTestResult?id=<%= result.getId() %>">View Result</a> <%
										 }
										 %>
										
									</td>
										


								</tr>
								<% 
								index ++;
								}
								%>


							</tbody>
						</table>

						<!-- end table for doctor list -->


					</div>

				</div>
			</div>
		</div>
	</div>









</body>
</html>
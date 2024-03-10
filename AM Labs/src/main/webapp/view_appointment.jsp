<%@page import="com.hms.entity.Doctor"%>
<%@page import="com.hms.entity.Test"%>
<%@page import="com.hms.entity.Status"%>
<%@page import="com.hms.entity.TestResult"%>
<%@page import="com.hms.dao.DoctorDAO"%>
<%@page import="com.hms.dao.TestDAO"%>
<%@page import="com.hms.entity.Patient_details"%>
<%@page import="com.hms.pat.PatientDAO"%>
<%@page import="com.hms.dao.StatusDAO"%>
<%@page import="com.hms.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.db.DBConnection"%>
<%@page import="com.hms.dao.AppointmentDAO"%>
<%@page import="com.hms.dao.TestResultDAO"%>
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
<!-- for responsive -->
<!-- <meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!-- for responsive -->
<title>View Appointment Page</title>

<!-- all css include -->
<%@include file="../component/allcss.jsp"%>

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px rgba(0,0,0,.125);
	/*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}

/* backgournd image css */
.my-bg-img {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/hospital1.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

/* backgournd image css */
</style>
<!-- end of customs css for this page -->


</head>
<body>
	<% 
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		
		response.setHeader("Pragma","no-cache");

		response.setHeader("Expires", "0");
	%>
	<%@include file="component/navbar.jsp"%>

	<!-- if not login then log in first -->
	<c:if test="${empty userObj }">

		<c:redirect url="/user_login.jsp"></c:redirect>

	</c:if>

	<!-- start 1st Div -->

	<div class="container-fluid my-bg-img p-5">
		<!-- css background image -->
		<p class="text-center fs-2 text-white"></p>

	</div>

	<!-- end of 1st Div -->

	<!-- 2nd Div -->

	<div class="container-fluid p-3">
		<p class="fs-2"></p>

		<div class="row">



			<!-- col-2 -->
			<div class="col-md-9">
				<div class="col-md-12 d-flex pb-3 justify-content-end">
					<div>
						<a aria-current="page" href="user_appointment.jsp" class="btn btn-success active"><i class="fa fa-book fa-1x"></i> ADD APPOINTMENT</a>
					</div>
					<!--<div>
						<a aria-current="page" href="view_appointment.jsp" class="btn btn-success active"><i class="fa fa-calendar-check-o"></i> VIEW APPOINTMENT</a>
					</div> -->
				</div>
				<div class="card my-card">
					<div class="card-body">
						<p class="fw-bold text-center myP-color fs-4">Appointment
							List</p>

						<%-- <!-- message print -->
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
						<!-- End of message print --> --%>

						<table class="table table-striped">
							<thead>
								<tr class="my-bg-color text-white">
									<th scope="col">No</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Test</th>
									<th scope="col">Doctor</th>
									<th scope="col">Status</th>
									<th scope="col">Result</th>
								</tr>
							</thead>
							<tbody>
								<%
								Patient_details user = (Patient_details) session.getAttribute("userObj");
							
								TestDAO testDAO = new TestDAO(DBConnection.getConn());
								StatusDAO statusDAO = new StatusDAO(DBConnection.getConn());
								AppointmentDAO appDAO = new AppointmentDAO(DBConnection.getConn());
								TestResultDAO resultDAO = new TestResultDAO(DBConnection.getConn());

								List<Appointment> list = appDAO.getAllAppointmentByLoginUser(user.getId());
								for (Appointment apptList : list) {
									int index = 1;
									Test test =  testDAO.getTestById(apptList.getTest());
									Status status = statusDAO.getStatusById(apptList.getStatus());
									TestResult result = resultDAO.getResultByAppointmentId(apptList.getId());
									
								%>


								<tr>
									<%-- <th scope="row"><%= apptList.getId() %></th> --%>
									
									<%-- <td><%= apptList.getEmail()%></td> --%>
									<td><%=index%></td>
									<td><%=apptList.getDateAndTime()%></td>
									<td><%=test.getTestName()%></td>
									<td><%=apptList.getDoctor()%></td>
									<td><%=status.getStatusName()%></td>
									
									<td>
										
										<%
										if (result == null) {
										%> <a href="" class="btn btn-sm btn-warning">Pending</a> <%
 										} else {
										 %>  <a href="viewTestResult?id=<%= result.getId() %>" class="btn btn-sm btn-success">View Report</a> <%
										 }
										 %>
									</td>
									
									<%-- <td><%= apptList.getAddress()%></td> --%>
									<%-- <td><%= apptList.getUserId()%></td> --%>
									


								</tr>

								
								<%
								index++;
								}
								%>


							</tbody>
						</table>




					</div>
				</div>

			</div>

			<!-- col-1 -->
			<div class="col-md-3 p-3">
				<!-- for Background image -->
				<!-- <img alt="" src="img/picDoc.jpg" width="500px" height="400px"> -->
				<img alt="" src="img/wdoc.jpg" width="250" height="">
			</div>



		</div>


	</div>

	<!-- 2nd Div -->




</body>
</html>
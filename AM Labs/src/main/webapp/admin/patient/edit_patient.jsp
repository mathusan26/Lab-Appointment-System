<%@page import="com.hms.db.DBConnection"%>
<%@page import="com.hms.pat.PatientDAO"%>
<%@page import="com.hms.entity.Patient_details"%>


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
<title>Signup Page</title>
<!-- boostrap css -->
<%@include file="../../component/allcss.jsp"%>
<!-- end of boostrap css -->

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px rgba(0,0,0,.125);
	/*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}
</style>
<!-- end of customs css for this page -->

</head>
<body>
	<!-- navbar -->
	<%@include file="navbar_patient.jsp"%>
	<!-- end navbar -->

	<!-- User Register -->
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card my-card">
					<div class="card-header text-center text-white my-bg-color">
						<!-- <p class="fs-4 text-center mt-1"><i class="fa-solid fa-users"></i> <br>User Login</p> -->
						<p class="fs-4 text-center text-white mt-2">
							<i class="fa fa-user-plus"></i> Edit Patient details
						</p>
					</div>
					<div class="card-body">
						<!-- <p class="fs-4 text-center">User Register</p> -->

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

						<%
						//get specific doctor id with the help of request.getParameter() 
						//which is coming from url for doctor editing(which i pass through url when press edit doctor)...
						int id = Integer.parseInt(request.getParameter("id")); //this "id" is prefix name in URL
						PatientDAO patientDAO = new PatientDAO(DBConnection.getConn());
						Patient_details patient = patientDAO.getPatientById(id);//call getDoctorById(id) which return doctor of specific id
						%>

						<!-- boostrap form -->
						<form action="../../updatePatient" method="post">
							<div class="mb-2">
								<label class="form-label">Patient Name</label> <input
									name="patientName" type="text" placeholder="Enter full name"
									class="form-control" value="<%=patient.getPatientName()%>">

							</div>
							<div class="mb-2 row">
								<div class="col-md-6">
									<label class="form-label">Age</label> <input
									name="age" type="number" placeholder="Enter age"
									class="form-control" value="<%=patient.getAge()%>">
								</div>
								
								<div class="col-md-6">
									<label class="form-label">Gender</label> <select
									name="gender"  required class="form-control">
									
									<option <%= (patient.getGender().equals("male"))?"selected":"" %>  value="male"> male </option>
									<option <%= (patient.getGender().equals("female"))?"selected":"" %>  value="female"> female</option>
									</select>
								</div>
							</div>
							<div class="mb-2">
								<label class="form-label">Phone Number</label> <input
									name="phone" type="text" placeholder="Enter phone number"
									class="form-control" value="<%=patient.getPhone()%>">
							</div>
							<div class="mb-2">
								<label class="form-label">Date Of Birth</label> <input
									name="dateOfBirth" type="date" placeholder="Enter date of birth"
									class="form-control" value="<%=patient.getDateOfBirth()%>">
							</div>
							<div class="mb-2">
								<label class="form-label">Email address</label> <input
									name="email" type="email" placeholder="Enter Email"
									class="form-control" value="<%=patient.getEmail()%>">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>
							<div class="mb-2">
								<label class="form-label">Address</label> <textarea
									name="address" class="form-control"><%=patient.getAddress()%></textarea>
							</div>
								<div class="mb-2">
								<label class="form-label">Password</label> <input
									name="password" type="text" placeholder="Enter Password"
									class="form-control" value="<%=patient.getPassword()%>">
							</div>
							<div class="mb-3">
								<input name="patientId" type="hidden" class="form-control"
									value="<%=patient.getId()%>">
							</div>
							

							<button type="submit" class="btn my-bg-color text-white col-md-12">Update</button>
						</form>
						<!-- <br>Don't have an account? <a href="#!" class="text-decoration-none">create one</a> -->
						<!-- end of boostrap form -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End of User Register -->

</body>
</html>

<%@page import="java.util.List"%>
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
<title>Patient page</title>
<%@include file="../../component/allcss.jsp"%>

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px rgba(0,0,0,0.2);
	/*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}
</style>
<!-- end of customs css for this page -->

</head>
<body>
	<%@include file="navbar_patient.jsp"%>


	<div class="container-fluid p-3">
		<div class="row">
			
			<div class="col-md-12">
				<div class="card my-card">
					<div class="card-body">
						<div class="row">
							<div class="col-md-9">
								<p class="text-center fs-3  text-danger">List of Patients</p>
							</div>
							<div class="col-md-3 d-flex  justify-content-end" style="height: fit-content;">
								<a aria-current="page" href="add_patient.jsp" class="btn btn-success active"><i class="fa-solid fa-user-plus"></i> New Patient </a>
							</div>
						</div>
						<div class="row">
							<div class="col-md-9">
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
							</div>
						</div>

						<!-- table for doctor list -->

						<table class="table table-striped">
							<thead>
								<tr class="table-info">
									<th scope="col">No</th> 
									<th scope="col">Patient Id</th> 
									<th scope="col">Full Name</th>
									<th scope="col">DOB</th>
									<th scope="col">email</th>
									<th scope="col">gender</th>
									<th scope="col">Age</th>
									<th scope="col">Phone No</th>
									<th scope="col">Address</th>
									<th colspan="2" class="text-center" scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								PatientDAO patientDAO = new PatientDAO(DBConnection.getConn());
								List<Patient_details> listOfPatients = patientDAO.getAllPatient();
								int index =1;
								for (Patient_details patientLst : listOfPatients) {
								%>
								<tr>
									<%-- <th scope="row"><%= doctorLst.getId()%></th> --%>
									<td scope="row"><%= index %></td>
									<th><%=patientLst.getPatientReferenceNo()%></th>
									<td><%=patientLst.getPatientName()%></td>
									<td><%=patientLst.getDateOfBirth()%></td>
									<td><%=patientLst.getEmail()%></td>
									<td><%=patientLst.getGender()%></td>
									<td><%=patientLst.getAge()%></td>
									<td><%=patientLst.getPhone()%></td>
									<td><%=patientLst.getAddress()%></td>

									<td colspan="2" class="d-flex justify-content-evenly">
									<a class="btn btn-sm btn-primary"
										href="edit_patient.jsp?id=<%=patientLst.getId()%>">Edit</a>
									<a class="btn btn-sm btn-danger" onclick="return confirm(&quot;Click Ok to delete <%=patientLst.getPatientName()%>.&quot;)" href="../../deletePatient?id=<%= patientLst.getId() %>">Delete</a></td>



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
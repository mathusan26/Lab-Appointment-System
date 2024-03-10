<%@page import="com.hms.entity.Technician"%>
<%@page import="com.hms.dao.TechnicianDAO"%>
<%@page import="com.hms.dao.TestDAO"%>
<%@page import="com.hms.entity.Test"%>
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
	<%@include file="navbar_technician.jsp"%>


	<div class="container p-5">
		<div class="row">
			
			<div class="col-md-4 offset-md-4">
				<div class="card my-card">
					<div class="card-header text-center text-white my-bg-color">
						<!-- <p class="fs-4 text-center mt-1"><i class="fa-solid fa-users"></i> <br>User Login</p> -->
						<p class="fs-4 text-center text-white mt-2">
							<i class="fa-solid fa-user-doctor"></i> Add Technician
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
						//int id = Integer.parseInt(request.getParameter("id")); //this "id" is prefix name in URL
						//TechnicianDAO techDAO = new TechnicianDAO(DBConnection.getConn());
						//Technician tech = techDAO.getTechnicianById(id);//call getDoctorById(id) which return doctor of specific id
						%>
					
						<form action="../../addTechnician" method="post">
							<div class="mb-3">
								<label class="form-label">Technician Name</label> <input
									name="technicianName" type="text" placeholder="Enter Technician Name"
									class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">Working Test Field</label> <select
								 required="required" class="form-control" name="testField">
									<option selected="selected" disabled="disabled">---Select---</option>
									
									<%
									TestDAO testDAO = new TestDAO(DBConnection.getConn());
									List<Test> listOfTest = testDAO.getAllTest();
									for(Test t : listOfTest)
									
									{%>
									<!-- actually we take id of doctor from doctor table -->
									<option value="<%= t.getId() %>"> <%= t.getTestName()%> </option>
									
									<%
									}
									%>
									
									<!-- <option>Doctor name</option> -->
								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input
									name="age" type="number" placeholder="Enter Age"
									class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">Phone</label> <input
									name="phone" type="number" placeholder="Enter Phone Number"
									class="form-control">

							</div>
							
							<div class="mb-2">
								<label class="form-label">Address</label> <textarea
									name="address" class="form-control"></textarea>
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
<%@page import="com.hms.entity.Test"%>
<%@page import="com.hms.dao.TestDAO"%>
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
	<% 
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
			
		response.setHeader("Pragma","no-cache");
	
		response.setHeader("Expires", "0");
	%>
	<%@include file="navbar_test.jsp"%>


	<div class="container p-3">
		<div class="row">
			
			<div class="col-md-4 offset-md-4">
				<div class="card my-card">
					<div class="card-header text-center text-white my-bg-color">
						<!-- <p class="fs-4 text-center mt-1"><i class="fa-solid fa-users"></i> <br>User Login</p> -->
						<p class="fs-4 text-center text-white mt-2">
							<i class="fa-solid fa-vial-virus"></i> Add Test
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
						//TestDAO testDAO = new TestDAO(DBConnection.getConn());
						//Test test = testDAO.getTestById(id);//call getDoctorById(id) which return doctor of specific id
						%>
					
						<form action="../../addTest" method="post">
							<div class="mb-3">
								<label class="form-label">Test Name</label> <input
									name="test_name" type="text" placeholder="Enter Test Name"
									class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">Price</label> <input
									name="price" type="number" placeholder="Enter Test Price"
									class="form-control">

							</div>
							<div class="mb-3">
								<label class="form-label">Test Description</label> <input
									name="test_description" type="text" placeholder="Enter Test Description"
									class="form-control">

							</div>

							<button type="submit" class="btn btn-success text-white col-md-12">Save</button>
						</form>
							

						<!-- end table for doctor list -->


					</div>

				</div>
			</div>
		</div>
	</div>









</body>
</html>
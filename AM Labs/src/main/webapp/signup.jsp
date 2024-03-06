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
<%@include file="component/allcss.jsp"%>
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
	<%@include file="component/navbar.jsp"%>
	<!-- end navbar -->

	<!-- User Register -->
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card my-card">
					<div class="card-header text-center text-white my-bg-color">
						<!-- <p class="fs-4 text-center mt-1"><i class="fa-solid fa-users"></i> <br>User Login</p> -->
						<p class="fs-4 text-center text-white mt-2">
							<i class="fa fa-user-plus"></i> Patient Register
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

						<!-- boostrap form -->
						<form action="user_register" method="post">
							<div class="mb-2">
								<label class="form-label">Patient Name</label> <input
									name="patient_name" type="text" placeholder="Enter full name"
									class="form-control">

							</div>
							<div class="mb-2 row">
								<div class="col-md-6">
									<label class="form-label">Age</label> <input
									name="age" type="text" placeholder="Enter age"
									class="form-control">
								</div>
								<div class="col-md-6">
									<label class="form-label">Gender</label> <input
									name="gender" type="text" placeholder="Enter geder"
									class="form-control">
								</div>
							</div>
							<div class="mb-2">
								<label class="form-label">Phone Number</label> <input
									name="phone" type="text" placeholder="Enter phone number"
									class="form-control">
							</div>
							<div class="mb-2">
								<label class="form-label">Email address</label> <input
									name="email" type="email" placeholder="Enter Email"
									class="form-control">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>
							<div class="mb-2">
								<label class="form-label">Address</label> <textarea
									name="address" class="form-control"></textarea>
							</div>
							<div class="mb-2 row">
								<div class="col-md-6">
									<label class="form-label">Password</label> <input
									name="password" type="password" placeholder="Password"
									class="form-control">
								</div>
								<div class="col-md-6">
									<label class="form-label">Confirm Password</label> <input
									name="confirm_password" type="password" placeholder="Confirm Password"
									class="form-control">
								</div>
							</div>

							<button type="submit" class="btn my-bg-color text-white col-md-12">Register</button>
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
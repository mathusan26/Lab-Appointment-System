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
	box-shadow: 0px 0px 10px 1px rgba(0,0,0,0.2);
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
			
			<div class="col-md-8 offset-md-2">
				<div class="card my-card">
					<div class="card-body">
						<div class="row">
							<div class="col-md-9">
								<p class="fs-3 text-center text-danger">List of Test</p>
							</div>
							<div class="col-md-3 d-flex  justify-content-end" style="height: fit-content;">
								<a aria-current="page" href="add_test.jsp" class="btn btn-success active"><i class="fa-solid fa-vial-virus"></i> New Test </a>
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
									<!-- <th scope="col">ID</th> -->
									<th scope="col">No</th>
									<th scope="col">Test Name</th>
									<th scope="col">Test Description</th>
									<th scope="col">Test Price</th>
									<th colspan="2" class="text-center" scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								TestDAO testDAO2 = new TestDAO(DBConnection.getConn());
								List<Test> listOfTest = testDAO2.getAllTest();
								int index = 1;
								for (Test testLst : listOfTest) {
								%>
								<tr>
									<td scope="row"><%= index %></td>
									<td><%=testLst.getTestName()%></td>
									<td><%=testLst.getTestDescription()%></td>
									<td><%=testLst.getPrice()%></td>
									<td colspan="2" class="d-flex justify-content-evenly">
									 <a class="btn btn-sm btn-primary"
										href="edit_test.jsp?id=<%=testLst.getId()%>">Edit</a>
									<a class="btn btn-sm btn-danger" onclick="return confirm(&quot;Click Ok to delete <%=testLst.getTestName()%>.&quot;)" href="../../deleteTest?id=<%= testLst.getId() %>">Delete</a>
									<!-- Modal -->
									</td>


								</tr>
								<%
								index++;
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

	<!-- end of specialis modal -->









</body>
</html>
<%@page import="com.hms.entity.Technician"%>
<%@page import="com.hms.dao.TechnicianDAO"%>
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
	<%@include file="navbar_technician.jsp"%>


	<div class="container p-3">
		<div class="row">
			
			<div class="col-md-8 offset-md-2">
				<div class="card my-card">
					<div class="card-body">
						<div class="row">
							<div class="col-md-3">
								
							</div>
							<div class="col-md-6">
								<p class="fs-3 text-center text-danger">List of Technicians</p>
							</div>
							<div class="col-md-3 d-flex  justify-content-end" style="height: fit-content;">
								<a aria-current="page" href="add_technician.jsp" class="btn btn-success active"><i class="fa-solid fa-user-doctor"></i> New Technician </a>
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
									<th scope="col">Technician Name</th>
									<th scope="col">Test Field</th>
									<th scope="col">Address</th>
									<th scope="col">Age</th>
									<th scope="col">Phone</th>
									<th colspan="2" class="text-center" scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								TechnicianDAO techDAO = new TechnicianDAO(DBConnection.getConn());
								List<Technician> listOfTech = techDAO.getAllTechnician();
								int index = 1;
								for (Technician techLst : listOfTech) {
								%>
								<tr>
									<td scope="row"><%= index %></td>
									<td><%=techLst.getTechnicianName()%></td>
									<td><%=techLst.getTestField()%></td>
									<td><%=techLst.getAddress()%></td>
									<td><%=techLst.getAge()%></td>
									<td><%=techLst.getPhone()%></td>

									<td colspan="2" class="d-flex justify-content-evenly">
										<a class="btn btn-sm btn-primary"
										href="edit_technician.jsp?id=<%=techLst.getId()%>">Edit</a>
										<a class="btn btn-sm btn-danger" onclick="return confirm(&quot;Click Ok to delete <%=techLst.getTechnicianName()%>.&quot;)" href="../../deleteTech?id=<%= techLst.getId() %>">Delete</a>
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









</body>
</html>
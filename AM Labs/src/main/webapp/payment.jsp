<%@page import="com.hms.entity.Doctor"%>
<%@page import="com.hms.entity.Test"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.db.DBConnection"%>
<%@page import="com.hms.dao.AppointmentDAO"%>
<%@page import="com.hms.dao.TestDAO"%>
<%@page import="com.hms.entity.Appointment"%>
<%@page import="com.hms.pat.PatientDAO"%>
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
<title>Payment portal</title>
<!-- all css include -->
<%@include file="../component/allcss.jsp"%>

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
body{background: #f5f5f5}
.rounded{border-radius: 1rem}
.nav-pills .nav-link{color: #555}
.nav-pills .nav-link.active{color: white}
input[type="radio"]{margin-right: 5px}
.bold{font-weight:bold}

/* backgournd image css */
</style>
<!-- end of customs css for this page -->

</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container py-5">
    <!-- For demo purpose -->
    <div class="row mb-4">
        <div class="col-lg-8 mx-auto text-center">
            <h1 class="display-6">A.M Medi Payment</h1>
        </div>
    </div> <!-- End -->
    <div class="row">
        <div class="col-lg-6 mx-auto">
            <div class="card ">
                <div class="card-header">
                    <!-- Credit card form content -->
                    <div class="tab-content">
                        <!-- credit card info-->
                        <div id="credit-card" class="tab-pane fade show active pt-3">
	                        <%
							//get specific doctor id with the help of request.getParameter() 
							//which is coming from url for doctor editing(which i pass through url when press edit doctor)...
							int id = Integer.parseInt(request.getParameter("id")); //this "id" is prefix name in URL
							AppointmentDAO appointmentDAO = new AppointmentDAO(DBConnection.getConn());
							Appointment appoint = appointmentDAO.getAppointmentById(id);//call getDoctorById(id) which return doctor of specific id
							%>
						
                            <form action="Payment" method="post">
                            
                            	<div class="form-group"> <label for="">
                                        <h6>Invoiced Amount</h6>
                                    </label> <input name="" type="number" placeholder="Price" disabled class="form-control" value="<%=appoint.getPrice()%>"> </div>
					
					
                                <div class="form-group"> <label for="username">
                                        <h6>Card Owner</h6>
                                    </label> <input type="text" name="username" placeholder="Card Owner Name" required class="form-control "> </div>
                                <div class="form-group"> <label for="cardNumber">
                                        <h6>Card number</h6>
                                    </label>
                                    <div class="input-group"> <input type="text" name="cardNumber" placeholder="Valid card number" class="form-control" maxlength="16"  pattern="^4[0-9]{12}(?:[0-9]{3})?$)|(^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$)|(3[47][0-9]{13})|(^3(?:0[0-5]|[68][0-9])[0-9]{11}$)|(^6(?:011|5[0-9]{2})[0-9]{12}$)|(^(?:2131|1800|35\d{3})\d{11}$" required>
                                        <div class="input-group-append"> <span class="input-group-text text-muted" style="height: 100%;"> <i class="fab fa-cc-visa mx-1"></i> <i class="fab fa-cc-mastercard mx-1"></i> <i class="fab fa-cc-amex mx-1"></i> </span> </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-8">
                                        <div class="form-group"> <label><span class="hidden-xs">
                                                    <h6>Expiration Date</h6>
                                                </span></label>
                                            <div class="input-group"> <input type="number" placeholder="MM" name="" class="form-control" min="1" max="12" required> <input type="number" placeholder="YY" name="" class="form-control" min="24" required> </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group mb-4"> <label data-toggle="tooltip" title="Three digit CV code on the back of your card">
                                                <h6>CVV <i class="fa fa-question-circle d-inline"></i></h6>
                                            </label> <input type="text" required class="form-control" maxlength="3"> </div>
                                    </div>
                                    <div class="mb-3">
										<input name="id" type="hidden" class="form-control"
											value="<%=id%>">
										<input name="price" type="hidden" class="form-control" value="<%=appoint.getPrice()%>">
									</div>
                                </div>
                                <div class="card-footer d-flex justify-content-center"> <button type="submit" class="subscribe btn btn-primary btn-block shadow-sm"> Confirm Payment </button>
                            </form>
                        </div>
                    </div> <!-- End -->
                </div>
            </div>
        </div>
    </div>















<!-- footer -->
<%@include file="component/footer.jsp" %>
<!-- end footer -->

</body>
</html>
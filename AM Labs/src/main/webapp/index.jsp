<%@page import="com.hms.db.DBConnection"%>
<%@page import="java.sql.Connection"%>
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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0 ">
<meta name="description" content="laboratory appointment management">
<meta name="keywords" content="laboratory appointment, doctor appointment">
<meta name="author" content="Mathusan">
<title>A.M Medi Labs</title>

<link rel="shortcut icon" href="img/favicon.png" type="image/x-icon">

<title>Home Page</title>
<%@include file="component/allcss.jsp"%>


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
	<% 
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		
		response.setHeader("Pragma","no-cache");

		response.setHeader("Expires", "0");
	%>
	<%@include file="component/navbar.jsp"%>


	<!-- carousel code -->

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="3" aria-label="Slide 4"></button>
			<!-- <button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="4" aria-label="Slide 5"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="5" aria-label="Slide 6"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="6" aria-label="Slide 7"></button> -->
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/test-1.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/test-2.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/test-3.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/test-4.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>

		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<!-- end of carousel code -->



	<!-- First Div Container -->
	<div class="container p-3">
		<p class="text-start mt-2 mb-0 fs-2 primary-color">Popular Tests</p>
		<p class="text-start mt-2 mb-2 fs-5 secondary-color">Discover Our Popular Lab Tests, Unlock Key Health Insights with Trusted Diagnostic Services.</p>
		<div class="row">
			<!-- 1st col -->
			<div class="col-md-8 p-1 pt-5">

				<div class="row">
					<div class="col-md-6">
						<div class="card my-card">
							<div class="card-body">
								<p class="fs-5 myP-color">Fasting Blood Sugar Test</p>
								<p>This measures your blood sugar after an overnight fast (not eating). 
								A fasting blood sugar level of 99 mg/dL or lower is normal, 100 to 125 
								mg/dL indicates you have prediabetes, and 126 mg/dL or higher indicates 
								you have diabetes.</p>
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="card my-card">
							<div class="card-body">
								<p class="fs-5 myP-color">Full Blood Count Test</p>
								<p>A full blood count (FBC) is a common blood test that can provide 
								information about a range of conditions. A full blood count looks at the 
								different cells in your blood, including red blood cells, white blood 
								cells and platelets.</p>
							</div>
						</div>
					</div>

					<div class="col-md-6 mt-2">
						<div class="card my-card">
							<div class="card-body">
								<p class="fs-5 myP-color">Microalbumin (Urine) Test</p>
								<p>This test looks for minuscule amounts of albumin in your urine.Albumin 
								is a protein needed for tissue growth and healing. It can leak into your 
								urine when your kidneys aren't working as they should. The test can find 
								out if diabetes has damaged your kidneys.</p>
							</div>
						</div>
					</div>

					<div class="col-md-6 mt-2">
						<div class="card my-card">
							<div class="card-body">
								<p class="fs-5 myP-color">Dengue Antigen Test</p>
								<p>The dengue antigen test also called the dengue NS1, 
								is done to detect the present of infection by the dengue virus. An 
								antigen is protein which is present on the surface of the virus, 
								and this test will help confirm the presence of an infection by 
								detecting this protein.</p>
							</div>
						</div>
					</div>
				</div>


			</div>
			<!-- End of 1st col -->

			<!-- 2nd col -->
			
				<div class="col-md-4 p-1 pt-5">
					<img class="" alt="" src="img/micro-scope.jpg" height="440px"
						width="470px">
				</div>
			
			<!-- End of 2nd col -->

		</div>
	</div>
	<!-- End of First Div Container -->

	
	<div class="container-fluid how-it-work">
		<p class="text-start mt-2 mb-0 fs-2 white-text">How It Works</p>
		<p class="text-start mt-2 mb-2 fs-5 white-text">Uncover the Seamless Process for Easy Navigation and Health Solutions.</p>

		<div class="row justify-content-center">
			<div class="col-lg-4 col-md-6 d-flex" data-aos="fade-up" data-aos-delay="600">
				<div class="work-box">
					<div class="work-icon">
						<img src="img/icons/work-icon-07.svg" alt="Img">
					</div>
					<h4>1. Request your test kit</h4>
					<p>Take the first step to better health – request your test kit. Simple, convenient, and tailored to empower your wellness journey.</p>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 d-flex" data-aos="fade-up" data-aos-delay="700">
				<div class="work-box bg-green">
					<div class="work-icon">
						<img src="img/icons/work-icon-06.svg" alt="Img">
					</div>
					<h4>2. Collect Your Sample</h4>
					<p> Collect your sample at your convenience with our easy-to-follow instructions. Streamlined and hassle-free, empowering your health from the comfort of home</p>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 d-flex" data-aos="fade-up" data-aos-delay="800">
				<div class="work-box bg-pink">
					<div class="work-icon">
						<img src="img/icons/work-icon-05.svg" alt="Img">
					</div>
					<h4>3. Receive results in days</h4>
					<p>Expect your test results within days, ensuring a prompt and efficient turnaround. Stay informed and take control of your health journey</p>
				</div>
			</div>
		</div>
	</div>
	<!-- Second Div Container -->

	<div class="container p-2">
		<p class="text-center fs-2 myP-color">Our Technicians</p>
		<div class="row">
			<div class="col-md-3">
				<div class="card my-card">
					<div class="card-body text-center">
						<img alt="" src="img/tech/technician-f.png" height="300px" width="230px">
						<p class="fw-bold fs-5">Mrs. Maria</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card my-card">
					<div class="card-body text-center">
						<img alt="" src="img/tech/technician-m.png" height="300px" width="230px">
						<p class="fw-bold fs-5">Mr. John</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card my-card">
					<div class="card-body text-center">
						<img alt="" src="img/tech/technician-f.png" height="300px" width="230px">
						<p class="fw-bold fs-5">Miss. Jennifer</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card my-card">
					<div class="card-body text-center">
						<img alt="" src="img/tech/technician-m.png" height="300px" width="230px">
						<p class="fw-bold fs-5">Mr. Brad</p>
					</div>
				</div>
			</div>

		</div>

	</div>

	<!-- Second Div Container -->





	<!-- footer -->
	<%@include file="component/footer.jsp"%>
	<!-- end footer -->
</body>
</html>
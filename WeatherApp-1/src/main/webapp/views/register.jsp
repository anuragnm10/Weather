<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body style="overflow: hidden; height: 100vh;">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">TrueWeather</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home">Home</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<form action="register" method="post" style="height: 100vh;">
		<section class="h-100 h-custom" style="background-color: #8fc4b7;">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-lg-8 col-xl-6">
						<div class="card rounded-3">
							<div class="card-body p-4 p-md-5">
								<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Registration
									Info</h3>

								<form class="px-md-2">

									<div class="form-outline mb-4">
										<input type="text" id="form3Example1q" class="form-control"
											name="name" /> <label class="form-label"
											for="form3Example1q">Name</label>
									</div>

									<div class="form-outline mb-4">
										<input type="email" id="form3Example1q" class="form-control"
											name="email" /> <label class="form-label"
											for="form3Example1q">Email Id</label>
									</div>

									<div class="form-outline mb-4">
										<input type="password" id="form3Example1q"
											class="form-control" name="password" /> <label
											class="form-label" for="form3Example1q">Password</label>
									</div>
									<input type="radio" id="user" name="type" value="user" required>
									<label for="user">User</label> <input
										type="radio" id="admin" name="type" value="admin" required> <label
										for="admin">Admin</label><br/><br/>
									<button type="submit" class="btn btn-success btn-lg mb-1">Submit</button>

								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
</body>
</html>
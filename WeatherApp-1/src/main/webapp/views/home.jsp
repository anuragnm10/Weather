<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</head>
<body>
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
						href="register">Register</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<Form action="loginpage" method="POST">
		<section class="vh-100" style="background-color: #3c4963;">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">

								<h3 class="mb-5">Sign in</h3>

								<div class="form-outline mb-4">
									<input type="email" id="typeEmailX-2" name="email"
										class="form-control form-control-lg" /> <label
										class="form-label" for="typeEmailX-2">Email</label>
								</div>

								<div class="form-outline mb-4">
									<input type="password" id="typePasswordX-2" name="password"
										class="form-control form-control-lg" /> <label
										class="form-label" for="typePasswordX-2">Password</label>
								</div>

								<button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>


							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</Form>
</body>
</html>
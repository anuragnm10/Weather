<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
						aria-current="page" href="/logout">logout</a></li>

					<li style="margin-left: 150vh;" class="nav-item"><a
						class="nav-link active">Welcome ${sessionScope.user.name }</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br>
	<div>
		<form style="margin-left: 16vh" method="get" action="/search">
			<input style="margin-left: 5px; margin-top: 5px; border-radius: 9px"
				type="text" name="query" placeholder="Search..."> <a
				class="fa fa-search"
				style="color: black; margin-left: -25px; text-decoration: none"></a>&nbsp;
			<select style="margin-left: 5px" name="category">
				<option value="weather">Current Weather</option>
				<option value="forecast">3 Days Forecast</option>
			</select>
		</form>
	</div>
	<br>
	<c:if test="${not empty error }">
		<h4 style="margin-left: 16.5vh" class="error-message">${error },
			Please try again!</h4>
	</c:if>
	<c:if test="${empty error }">
		<%
		String selectOption = request.getParameter("category");

		if (selectOption != null && selectOption.equals("weather")) {
		%>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">City</th>
						<th scope="col">Weather</th>
						<th scope="col">Temperature(°C)</th>
						<th scope="col">Feels Like(°C)</th>
						<th scope="col">Min Temp(°C)</th>
						<th scope="col">Max Temp(°C)</th>
						<th scope="col">Humidity(%)</th>
						<th scope="col">Wind Speed(Mph)</th>
						<th scope="col">Update</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${weather }" var="weather">
						<tr>
							<td>${weather.city }</td>
							<td>${weather.weather }</td>
							<td>${weather.temperature }</td>
							<td>${weather.feelsLike }</td>
							<td>${weather.minTemp }</td>
							<td>${weather.maxTemp }</td>
							<td>${weather.humidity }</td>
							<td>${weather.windSpeed }</td>
							<td><a style="margin: 7.5%" href="/search/${weather.city }"><i
									class="fa fa-refresh" style="color: black"></i></a>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<%
		} else if (selectOption != null && selectOption.equals("forecast")) {
		%>
		<h3 style="margin-left: 16.5vh">City: ${City }</h3>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Date</th>
						<th scope="col">Time</th>
						<th scope="col">Temperature(°C)</th>
						<th scope="col">Feels Like(°C)</th>
						<th scope="col">Min Temp(°C)</th>
						<th scope="col">Max Temp(°C)</th>
						<th scope="col">Pressure(hPa)</th>
						<th scope="col">Humidity(%)</th>
						<th scope="col">Weather</th>
						<th scope="col">Description</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sortedForecast }" var="forecast">

						<tr>
							<td>${forecast.date }</td>
							<td>${forecast.time }</td>
							<td>${forecast.temperature }</td>
							<td>${forecast.feelsLike }</td>
							<td>${forecast.tempMin }</td>
							<td>${forecast.tempMax }</td>
							<td>${forecast.pressure }</td>
							<td>${forecast.humidity }</td>
							<td>${forecast.weather }</td>
							<td>${forecast.description }</td>
						</tr>


					</c:forEach>

				</tbody>
			</table>
		</div>

		<%
		}
		%>
	</c:if>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #d5f4e6;
	font-family: Arial, sans-serif;
}

.container {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>
	<div class="container mt-5">
		<h2>User Registration</h2>
		<form id="registrationForm" action="Controller" method="post">
			<input type="hidden" name="command" value="do_registration" />
			<div class="form-group">
				<label for="username">Login</label> <input type="text"
					class="form-control" id="username" name="login" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password" required>
			</div>
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name" required>
			</div>
			<div class="form-group">
				<label for="dob">Date of Birth</label> <input type="date"
					class="form-control" id="dob" name="birthDate" required>
			</div>
			<div class="form-group">
				<label for="country">Country of Residence</label> <select
					class="form-control" id="country" name="residence" required>
					<option value="">Select a country</option>
					<option value="Russia">Russia</option>
					<option value="USA">USA</option>
					<option value="Germany">Germany</option>
					<option value="France">France</option>
					<!-- Add other countries as needed -->
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
		</form>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
		document.addEventListener("DOMContentLoaded", function() {
		});
	</script>

</body>
</html>
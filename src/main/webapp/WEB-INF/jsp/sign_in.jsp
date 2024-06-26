<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authorization</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	font-family: Arial, sans-serif;
	background-image: linear-gradient(#FFFFFF, rgb(255, 122, 89));
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	background-color: #ffffff;
	padding: 100px;
	border-radius: 8px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	width: 400px;
}

.form-group {
	margin-bottom: 5px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 10px;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 15px;
	border-radius: 4px;
	border: 1px solid #ccc;
	font-size: 16px;
}

button {
	padding: 15px 25px;
	background-color: #007BFF;
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 32px;
}

button:hover {
	background-color: #0056b3;
}

.register-link {
	margin-top: 15px;
	text-align: center;
}

.error-message {
	color: #a94442;
}
</style>
</head>
<body>

	<div class="container ">

		<form class="form-signin" action="Controller" method="post">
			<input type="hidden" name="command" value="do_auth" />
			<h2 class="form-signin-heading text-java text-center">LOGIN TO
				ACCOUNT</h2>
			<div class="error-message" id="error-message">
				<c:if test="${not (param.authError eq null) }">
					<c:out value="${param.authError}" />
				</c:if>
			</div>
			<div class="form-group">
				<label for="inputEmail" class="sr-only">Email address</label> <input
					type="email" id="inputEmail" class="form-control"
					placeholder="Email address" name="login" required autofocus>
				<label for="inputPassword" class="sr-only">Password</label> <input
					type="password" id="inputPassword" class="form-control"
					placeholder="Password" name="password" required>
				<div class="checkbox mb-3">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Enter</button>
		</form>
		<p>
			Not register yet? <a
				href="Controller?command=go_to_registration_page">Registration</a>
		</p>

	</div>
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			const form = document.getElementById('login-form');

			form.addEventListener('submit', function(event) {
				event.preventDefault();

				const login = document.getElementById('login').value;
				const password = document.getElementById('password').value;

				if (!login || !password) {
					alert('Please fill in all fields.');
					return;
				}

				console.log('Login:', login);
				console.log('Password:', password);

				form.reset();
			});
		});
	</script>

</body>
</html>
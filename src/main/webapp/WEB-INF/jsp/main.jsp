<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>News Website</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

header {
	background-color: #000;
	color: #fff;
	padding: 10px 20px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

nav ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

nav ul li {
	display: inline;
	margin-right: 20px;
}

.video-container {
	position: relative;
	width: 100%;
	padding-bottom: 56.25%;
	height: 0;
}

.video-container iframe {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}

footer {
	background-color: #333;
	color: #fff;
	padding: 10px 20px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

form {
	margin: 20px auto;
	max-width: 600px;
	padding: 20px;
	background-color: #f4f4f4;
	border-radius: 5px;
}

form label, form textarea, form input[type="submit"] {
	display: block;
	margin-bottom: 10px;
	width: 100%;
	box-sizing: border-box;
}

form textarea {
	height: 100px;
}

form input[type="submit"] {
	background-color: #333;
	color: #fff;
	border: none;
	padding: 10px;
	cursor: pointer;
}
</style>
</head>
<body>

	<header>
		<nav>
			<ul>
				<li><a href="#top">Top</a></li>
				<li><a href="#sport">Sport</a></li>
				<li><a href="#political">Political</a></li>
				<li><a href="Controller?command=go_to_business_page">Business</a>
				<li><a href="Controller?command=show_the_weather">Weather</a></li>
				<li><a href="Controller?command=go_to_goodnews_page">Good News</a></li>
				<li><a href="#live">Live</a></li>
			</ul>
		</nav>
		<div>
			<c:if test="${not (param.authError eq null) }">
			     <c:out value="${param.authError}" />
			</c:if>
			<a href="Controller?command=go_to_adding_page" class="btn btn-lg btn-danger btn-custom">Add news</a>
		
			<a href="Controller?command=do_logout" class="btn btn-lg btn-danger btn-custom">Logout</a>
		</div>
	</header>

	<div class="video-container">
		<iframe src="https://www.youtube.com/embed/BHY0FxzoKZE"
			frameborder="0" allowfullscreen></iframe>
	</div>

	<form id="comment-form">
		<label for="comment">Leave a comment:</label>
		<textarea id="comment" name="comment" required></textarea>
		<input type="submit" value="Submit">
	</form>

	<footer>
		<ul>
			<li><a href="#about">About</a></li>
			<li><a href="#contact">Contact</a></li>
			<li><a href="#help">Help</a></li>
		</ul>
		<img src="img/shh_Logo.svg" alt="Logotype">
	</footer>

</body>
</html>
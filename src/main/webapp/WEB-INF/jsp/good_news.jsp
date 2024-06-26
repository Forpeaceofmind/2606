<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Good News Only</title>
<link rel="stylesheet" href="css/goodnews.css">
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
				<li><a href="Controller?command=go_to_goodnews_page">Good
						News</a></li>
				<li><a href="#live">Live</a></li>
			</ul>
		</nav>
		<div>

			<a href="Controller?command=go_to_sign_in_page">Sign in</a> <a
				href="Controller?command=go_to_registration_page">Sign up</a>

		</div>
	</header>


	<div id="news-container">
		<!-- Good news articles will be loaded here dynamically -->
	</div>

	<footer>
		<ul>
			<li><a href="#about">About</a></li>
			<li><a href="#contact">Contact</a></li>
			<li><a href="#help">Help</a></li>
		</ul>
		<img src="logotype.png" alt="Logotype">
	</footer>

	<script src="js/goodnews.js"></script>
</body>
</html>
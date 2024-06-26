<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

			<a href="Controller?command=go_to_sign_in_page">Sign in</a> <a
				href="Controller?command=go_to_registration_page">Sign up</a>

		</div>
	</header>

	<div style="text-align: center;">
		<iframe
			src="https://radar.weather.gov/?settings=v1_eyJhZ2VuZGEiOnsiaWQiOm51bGwsImNlbnRlciI6Wy05NSwzN10sImxvY2F0aW9uIjpudWxsLCJ6b29tIjo0fSwiYW5pbWF0aW5nIjpmYWxzZSwiYmFzZSI6InN0YW5kYXJkIiwiYXJ0Y2MiOmZhbHNlLCJjb3VudHkiOmZhbHNlLCJjd2EiOmZhbHNlLCJyZmMiOmZhbHNlLCJzdGF0ZSI6ZmFsc2UsIm1lbnUiOnRydWUsInNob3J0RnVzZWRPbmx5IjpmYWxzZSwib3BhY2l0eSI6eyJhbGVydHMiOjAuOCwibG9jYWwiOjAuNiwibG9jYWxTdGF0aW9ucyI6MC44LCJuYXRpb25hbCI6MC42fX0%3D"
			width="100%" height="600px" frameborder="0"></iframe>
	</div>



	<footer>
		<nav>
			<ul>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
				<li><a href="#help">Help</a></li>
			</ul>
		</nav>
		<img src="img/shh_Logo.svg" alt="Logotype">
	</footer>

</body>
</html>


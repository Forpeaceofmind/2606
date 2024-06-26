<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Business News</title>
<link rel="stylesheet" href="css/businessnews.css">
</head>
<body style="background-color: olive">

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


	<table class="news-table">
		<tr class="light">
			<td>
				<h2>Today's Business News</h2>
				<p>Title: Lorem Ipsum</p>
				<p>Brief: Lorem ipsum dolor sit amet, consectetur adipiscing
					elit. Sed eget ligula ac sapien porta vehicula. Duis vel ligula nec
					ex convallis...</p>
				<p>
					Video Link: <a href="https://www.youtube.com/watch?v=BHY0FxzoKZE">Watch
						Video</a>
				</p> <img src="business_image.jpg" alt="Business News Image">
				<p>Date: April 30, 2024</p>
			</td>
		</tr>
		<tr class="dark">
			<td>
				<h2>Today's Political News</h2>
				<p>Title: Lorem Ipsum</p>
				<p>Brief: Lorem ipsum dolor sit amet, consectetur adipiscing
					elit. Sed eget ligula ac sapien porta vehicula. Duis vel ligula nec
					ex convallis...</p>
				<p>
					Video Link: <a href="https://www.youtube.com/watch?v=BHY0FxzoKZE">Watch
						Video</a>
				</p> <img src="political_image.jpg" alt="Political News Image">
				<p>Date: April 30, 2024</p>
			</td>
		</tr>
		<tr class="light">
			<td>
				<h2>Today's Sport News</h2>
				<p>Title: Lorem Ipsum</p>
				<p>Brief: Lorem ipsum dolor sit amet, consectetur adipiscing
					elit. Sed eget ligula ac sapien porta vehicula. Duis vel ligula nec
					ex convallis...</p>
				<p>
					Video Link: <a href="https://www.youtube.com/watch?v=BHY0FxzoKZE">Watch
						Video</a>
				</p> <img src="sport_image.jpg" alt="Sport News Image">
				<p>Date: April 30, 2024</p>
			</td>
		</tr>
		<tr class="dark">
			<td>
				<h2>Today's Weather News</h2>
				<p>Title: Lorem Ipsum</p>
				<p>Brief: Lorem ipsum dolor sit amet, consectetur adipiscing
					elit. Sed eget ligula ac sapien porta vehicula. Duis vel ligula nec
					ex convallis...</p>
				<p>
					Video Link: <a href="https://www.youtube.com/watch?v=BHY0FxzoKZE">Watch
						Video</a>
				</p> <img src="weather_image.jpg" alt="Weather News Image">
				<p>Date: April 30, 2024</p>
			</td>
		</tr>
	</table>
	<footer>
		<ul>
			<li><a href="#about">About</a></li>
			<li><a href="#contact">Contact</a></li>
			<li><a href="#help">Help</a></li>
		</ul>
		<img src="logotype.png" alt="Logotype">
	</footer>

	<script src="js/businessnews.js"></script>
</body>
</html>
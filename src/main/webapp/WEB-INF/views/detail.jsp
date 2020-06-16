<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<title>Detail Page</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/hipster/resources/assets/detail/css/style.css">
</head>
<body>

	<div class="wrapper d-flex align-items-stretch">
		<nav id="sidebar">
			<div class="custom-menu">
				<button type="button" id="sidebarCollapse" class="btn btn-primary">
					<i class="fa fa-bars"></i> <span class="sr-only">Toggle Menu</span>
				</button>
			</div>
			<h1>
				<a href="http://localhost:8080/hipster/item/lists/001" class="logo">품목</a>
			</h1>
			<ul class="list-unstyled components mb-5">
				<li class="active"><a href="#"><span
						class="fa fa-home mr-3"></span> Homepage</a></li>
				<li><a href="#"><span class="fa fa-user mr-3"></span>
						Dashboard</a></li>
				<li><a href="#"><span class="fa fa-sticky-note mr-3"></span>
						Friends</a></li>
				<li><a href="#"><span class="fa fa-sticky-note mr-3"></span>
						Subcription</a></li>
				<li><a href="#"><span class="fa fa-paper-plane mr-3"></span>
						Settings</a></li>
				<li><a href="#"><span class="fa fa-paper-plane mr-3"></span>
						Information</a></li>
			</ul>

		</nav>

		<!-- Page Content  -->
		<div id="content" class="p-4 p-md-5 pt-5">
			<h2 class="mb-4">Sidebar #04</h2>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum.</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum.</p>
		</div>
	</div>

	<script src="/hipster/resources/assets/detail/js/jquery.min.js"></script>
	<script src="/hipster/resources/assets/detail/js/popper.js"></script>
	<script src="/hipster/resources/assets/detail/js/bootstrap.min.js"></script>
	<script src="/hipster/resources/assets/detail/js/main.js"></script>
</body>
</html>
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

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/hipster/resources/assets/detail/css/style.css">
</head>
<body>
	
	
	<%
		int count =(int)request.getAttribute("cursor_count");
		String pd_image_thumnail[] =(String [])request.getAttribute("pd_image_thumnail");
	%>
	
	<% for(int i=0; i<count; i++){%>
	<div class="card" style="width: 18rem;">
		<img class="card-img-top" src=<%=pd_image_thumnail[i]%> alt="Card image cap">
		<div class="card-body">
			<h5 class="card-title">Card title </h5>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
			<a href="#" class="btn btn-primary">Go somewhere</a>
		</div>
	</div>
	<%}%>


	
	<h1><%=pd_image_thumnail[0]%> </h1>


	<script src="/hipster/resources/assets/detail/js/jquery.min.js"></script>
	<script src="/hipster/resources/assets/detail/js/popper.js"></script>
	<script src="/hipster/resources/assets/detail/js/bootstrap.min.js"></script>
	<script src="/hipster/resources/assets/detail/js/main.js"></script>
</body>
</html>
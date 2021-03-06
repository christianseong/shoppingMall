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

<link rel="stylesheet"
	href="/hipster/resources/assets/detail/css/listItemCustom.css" />
</head>
<body>


	<%
		int count = (int) request.getAttribute("cursor_count");
		String pd_image_thumnail[] = (String[]) request.getAttribute("pd_image_thumnail");
		String pd_name[] = (String[]) request.getAttribute("pd_name");
		String pd_brand[] = (String[]) request.getAttribute("pd_brand");
	%>


	<div class="col-md-4 offset-md-4 mt-5 border border-success pt-3">
		<div class="input-group mb-3">
			<input type="text" class="form-control" placeholder="Search ......"
				aria-label="Recipient's username">
			<div class="input-group-append">
				<span class="input-group-text"><i class="fa fa-search"></i></span>
			</div>
		</div>

		<%
			for (int i = 0; i < count; i++) {
		%>
		<div class="card" style="width: 10rem; hieght: 5rem;">
			<img class="card-img-top" src=<%=pd_image_thumnail[i]%>
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title"><%=pd_brand[i]%>
				</h5>
				<p class="card-text"><%=pd_name[i]%></p>
			</div>
		</div>
		<%
			}
		%>






		<script src="/hipster/resources/assets/detail/js/jquery.min.js"></script>
		<script src="/hipster/resources/assets/detail/js/popper.js"></script>
		<script src="/hipster/resources/assets/detail/js/bootstrap.min.js"></script>
		<script src="/hipster/resources/assets/detail/js/main.js"></script>
</body>
</html>
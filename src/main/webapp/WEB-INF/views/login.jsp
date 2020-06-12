<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>로그인</title>
</head>
<body>
<h1>
	이것은 로그인 입니다
</h1>

<P>  당신의 이메일은 ${userId} </P>
<img src="${profile_image} "/>
<img src="${thumbnail_image} "/>

<p>${access_token}</p>


</body>
</html>

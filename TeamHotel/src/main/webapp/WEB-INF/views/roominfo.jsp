<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:set var="path" value="${pageContext.request.contextPath}"/>
 <link href="${path}/resources/css/Roominfo.css" rel="stylesheet" >
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>Roominfo</title>
</head>
<h1 align=center><a href="/hotel/">NCS7 HOTEL</a></h1>
<h2>객실정보</h2>
<body>
	<a href="/hotel/superior">슈페리얼</a><br><br>
	<a href="/hotel/gorgeous">골져스</a><br><br>
	<a href="/hotel/suite">스위트</a>
	
</body>
</html>
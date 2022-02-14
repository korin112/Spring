<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:set var="path" value="${pageContext.request.contextPath}"/>
 <link href="${path}/resources/css/Roominfo.css" rel="stylesheet" >
<head>
<meta charset="UTF-8">
<title>Suite</title>
</head>
<h1><a href="/hotel/">NCS7 HOTEL</a></h1>
<h2>Suite</h2>
<h3>스위트</h3>
<h3 style="text-align:left;"><a href="/hotel/roominfo">이전</a></h3>
<hr>
<body style="text-align:center;">
	
		<a href="/hotel/gorgeous/ROS">Royal Suite</a> &nbsp;&nbsp;
		<a href="/hotel/superior/GBS">Grandbleu Suite</a>&nbsp;&nbsp;
		<a href="/hotel/superior/JUS">Junior Suite</a>
		
<hr>		
<button type="button" onclick="location.href='/reservation'">예약하기</button>
</body>
</html>
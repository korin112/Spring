<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>	${mobile }<br>	${address }</h1>

<form method="GET" action="/exercise/view">
 <!-- form에서는 name으로 데이터전송 data controller로 올려보내기-->
<input type=text name="nickname">
<input type=submit value="SEND">
</form>

</body>
</html>

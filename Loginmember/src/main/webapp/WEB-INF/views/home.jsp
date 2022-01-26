<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>

<body>
<form method="POST" action="/login/logout">
<c:if test="${userid==null}">
<a href="/login/login">로그인</a> <a href="/login/signon">회원가입</a>
</c:if>
<c:if test="${userid!=null }">
${userid} &nbsp;&nbsp; <input type=submit value="로그아웃">
</c:if>
<input type=hidden id=logout name=logout value="${userid}">
</form>
</body>
</html>

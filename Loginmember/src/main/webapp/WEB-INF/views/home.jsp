<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:if test="${userid==null}">
<a href="/login/login">로그인</a> <a href="/login/signon">회원가입</a>
</c:if>
<c:if test="${userid!=null }">
${userid} &nbsp;&nbsp; <a href='/login/logout'>로그아웃</a>
</c:if>
</body>
</html>

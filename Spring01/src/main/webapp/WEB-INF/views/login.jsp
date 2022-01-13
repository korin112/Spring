<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Login
</h1>
<table>
			<tr>
				<td>아이디 : </td>
				<td><input type=text name=name id=name></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type=text name=age id=age></td>
			</tr>
			<tr>
			<td><input type=button value='로그인'> </td>
			<td><input type=button value='취소'> </td>
			</tr>
</table>
<img src="animal/cat1.jfif" width='500px'>
</body>
</html>

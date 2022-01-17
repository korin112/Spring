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
<!-- <form method=get action="/edu/doLogin" id=frmLogin> -->
<table>
			<tr>
				<td>아이디 : </td>
				<td><input type=text name=userid id=userid value="${userid}" } ></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type=password name=password id=password value="${password}" }></td>
			</tr>
			<tr>
			<td><input type=submit id=btnLogin value='로그인'> </td>
			<td><input type=reset value='취소' onclick='document.location=/edu/'> </td>
			
			</tr>
</table>
<!-- </form> -->
<img src="animal/cat1.jfif" width='300px'>
<a href=/edu/signon>회원가입</a>
</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
$(document)
.on('click','#btnLogin',function(){
	document.location="/edu/doLogin/"+$('#userid').val()+"/"+$('#password').val();
	return false;
})
</script>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/login/login_check">
<table>
			<tr>
				<td>아이디 : </td>
				<td><input type=text name=userid id=userid ></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type=password name=passcode id=passcode ></td>
			</tr>
			<tr>
			<td><input type=submit id=btnLogin value='로그인'> </td>
			<td><input type=reset value='취소' onclick='document.location=/login/'> </td>
			</tr>
</table>
</form>
</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
</script>
</html>
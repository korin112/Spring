<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
			<tr>
				<td>아이디 : </td>
				<td><input type=text name=userid id=userid value="${userid}"  ></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type=password name=password id=passcode value="${passcode}" ></td>
			</tr>
			<tr>
			<td><input type=submit id=btnLogin value='로그인'> </td>
			<td><input type=reset value='취소' onclick='document.location=/login/'> </td>
			
			</tr>
</table>
</body>
</html>
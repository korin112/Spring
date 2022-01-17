<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- String name=member.getRealname(); -->
<!-- 		if(name.equals("")) {	 -->
<!-- 		return "signon"; -->
<!-- 		} else { -->
<!-- 			return "login"; -->

name : ${m.realname }<br>	<!-- 클래스 이름을 사용해야함 -->
gender : ${m.gender }<br>
idname : ${m.idname }<br>
passcode : ${m.passcode }<br>
passcode1 : ${m.passcode1 }<br>
interest : ${m.interest }
</body>
</html>
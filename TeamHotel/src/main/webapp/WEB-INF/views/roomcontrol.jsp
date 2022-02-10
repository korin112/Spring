<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>roomControl</title>
</head>
<body>
<h1><a href="/hotel/">NCS7 HOTEL</a></h1>
<form id=frmRoom action="/hotel/addRoom">
객실코드 : <input type=text name=room_code><br>
객실명 : <input type=text name=name><br>
객실타입 : <input type=text name=type><br>
숙박인원 : <input type=text name=howmany><br>
숙박료 : <input type=text name=howmuch><br>
<input type=submit value='추가'>
</form>
<select>
<c:forEach items="${}" var="">
<option value="${}">${}</option>
</c:forEach>
</select>

</body>
</html>
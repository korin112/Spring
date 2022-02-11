<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>typeControl</title>
</head>
<body>
<h1><a href="/hotel/">NCS7 HOTEL</a></h1>
<form id=frmRoom action="/hotel/addType">
타입 : <input type=text name=type_code><br>
객실명 : <input type=text name=name><br>
<input type=submit value='추가'>
</form>

<select>
<c:forEach items="${}" var="">
<option value="${}">${}</option>
</c:forEach>
</select>

</body>
</html>
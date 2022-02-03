<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지원 정보</title>
</head>
<style>
table { border-collapse:collapse}
th,td {border:1px solid black;}
</style>

<body>
<table>
<thead>
	<tr>
	<th>부서ID</th><th>부서이름</th><th>상위부서</th><th>부서장이름</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${alemp}" var="emp"> <!-- alEmp에서 나올게 없을때까지 하나씩 꺼내서 emp에 넣음 --> 
	<tr>
		<td>${emp.dep_id}</td>	<!-- emp안에있는 객체들을 꺼내는거임 -->
		<td>${emp.dep_name}</td>
		<td>${emp.dname}</td>
		<td>${emp.mname}</td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
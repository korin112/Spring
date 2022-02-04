<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나라 정보</title>
</head>
<style>
table { border-collapse:collapse}
th,td {border:1px solid black;}
</style>

<body>
<table>
<thead>
	<tr>
		<th>country_id</th><th>iso_code</th><th>country_name</th><th>country_region</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${alcountry}" var="country"> <!-- alEmp에서 나올게 없을때까지 하나씩 꺼내서 emp에 넣음 --> 
	<tr>
		<td>${country.country_id}</td>	<!-- emp안에있는 객체들을 꺼내는거임 -->
		<td>${country.country_iso_code}</td>
		<td>${country.country_name}</td>
		<td>${country.country_region}</td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
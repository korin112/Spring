<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<form method="GET" action="/exercise/calc">

<input type=text name="x1" size=3> <input type=text name="op" size=1> 
<input type=text name="x2" size=3> = 
<input type=submit value="SEND">

<%-- <c:if test="${result==null}"> --%>
<!-- <h1>값없음</h1> -->
<%-- </c:if> --%>

<%-- <c:if test="${result!=null}"> --%>
<%-- <h1>RESULT : ${result}</h1> --%>
<%-- </c:if> --%>

</form>
</body>
<script>

</script>
</html>
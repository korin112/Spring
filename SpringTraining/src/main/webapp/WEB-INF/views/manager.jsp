<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상사별 직원명단조회</title>
</head>
<style>
table { border-collapse:collapse}
th,td {border:1px solid black;}
</style>
<body>
<h1>상사별 직원명단조회</h1>
상사명 : <select id=selMan>
<c:forEach items="${manager}" var="man">
<option value="${man.eid1}">${man.ename}</option>
</c:forEach>
</select><br><br>
<table id=tblMan>

</table>
</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
$(document)
.on('change','#selMan',function(){
	let mid=$('#selMan').val();
	$.ajax({
		url:"/exercise/managerlist",
		data:{mid:mid},
		method:"GET",
		datatype:"json",
		beforeSend:function(){
			$('#tblMan').empty();
		},
		success:function(data){
			for(i=0; i<data.length; i++){
				let str='<tr><td>'+data[i]['ename']+'</td></tr>';
				$('#tblMan').append(str);
			}
		}
	});
	
})
	
	

</script>
</html>
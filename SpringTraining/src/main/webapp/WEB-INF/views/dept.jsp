<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서별 직원명단조회</title>
</head>
<style>
table { border-collapse:collapse}
th,td {border:1px solid black;}
</style>
<body>
<h1>부서별 직원명단조회</h1>
부서명 : <select id=selDep>
<c:forEach items="${dept}" var="dep">
<option value="${dep.department_id}">${dep.department_name}</option>
</c:forEach>
</select><br><br>
<table id=tblDep>

</table>
</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
$(document)
.on('change','#selDep',function(){
	let depid=$('#selDep').val();
	$.ajax({
		url:"/exercise/deptlist",
		data:{depid:depid},
		method:"GET",
		datatype:"json",
		beforeSend:function(){
			$('#tblDep').empty();
		},
		success:function(data){
			for(i=0; i<data.length; i++){
				let str='<tr><td>'+data[i]['eid']+'</td><td>'
								  +	data[i]['ename']+'</td><td>'
								  +	data[i]['mobile']+'</td><td>'
								  +	data[i]['salary']+'</td></tr>';
				$('#tblDep').append(str);
			}
		}
	});
	
})
	
	

</script>
</html>
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
<table id=tblEMP >
<thead>
<input type=text id=txtKeyword>
<button id=btnShow>직원명단조회</button><br>
	<tr>
	<th>사번</th><th>이름</th><th>전화번호</th><th>매니저아이디</th><th>입사일자</th>
	</tr>
</thead>
<tbody>
<!-- 	<tr> -->
<!-- 		<td></td>	 -->
<!-- 		<td></td> -->
<!-- 		<td></td> -->
<!-- 		<td></td> -->
<!-- 		<td></td> -->
<!-- 	</tr> -->
</tbody>
</table>
</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
$(document)
.on('click','#btnShow',function(){
	$.ajax({ url:"/exercise/empview",
			 data:{kw:$('#txtKeyword').val()},	// data 보내는거임
			 method:"POST",
			 datatype:"json",
			 beforeSend:function(){
				 $('#tblEMP').empty(); 
			 },
			 success:function(txt){
// 				 console.log(txt)
// 				 $('#tblEMP').empty();
				 for(i=0; i<txt.length; i++){
					 let str='<tr><td>'+txt[i]['empid']+'</td>'+
					 		     '<td>'+txt[i]['empname']+'</td>'+
					 			 '<td>'+txt[i]['pnumber']+'</td>'+
					 			 '<td>'+txt[i]['mid']+'</td>'+
					 			 '<td>'+txt[i]['hdate']+'</td></tr>';
					$('#tblEMP').append(str);
				 }
			 }
	});
})

</script>
</html>
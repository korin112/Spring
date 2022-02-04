<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실관리</title>
</head>
<body>
<table>
	<tr>
		<td>
			<select id= selRoom style='width:200px' size=10>
			<c:forEach items="${roomlist}" var="RL"> 
			<option value=${RL.roomcode}>${RL.name}, ${RL.type}, ${RL.howmany}, ${RL.howmuch}</option>
			</c:forEach>
			</select>
		</td>
	<td>
		<form id=frmRoom action="/exercise/addRoom">
		<table>
<input type=hidden id=roomcode name=roomcode>
			<tr>
				<td align=right> 객실명 : </td>
				<td><input type=text name=roomname></td>
			</tr>
			<tr>
				<td align=right> 타입 : </td>
				<td>
					<select id=roomtype name=roomtype>
					<option value=''>-</option>
					<c:forEach items="${types}" var="roomtype">
					<option value=${roomtype.typecode}>${roomtype.typename}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align=right> 숙박가능인원 : </td>
				<td><input type=text name=howmany></td>
			</tr>
			<tr>
				<td align=right> 숙박비 : </td>
				<td><input type=text name=howmuch></td>
			</tr>
			<tr>
				<td colspan=2 align=center>
				<input type=submit value='추가'>
				<input type=button value="삭제" id=btnDelete>
				</td>
			</tr>
		</table>		
	</form>
</table>
</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
$(document)
.on('click','#btnDelete',function(){
	let url="/exercise/deleteRoom?roomcode="+$('#roomcode').val();
	document.location=url;
	console.log(url);
})
.on('click','#selRoom option',function(){
	console.log($(this).val()+','+$(this).text());
	$('#roomcode').val($(this).val());
	let str=$(this).text();
	let ar=str.split(',');
	$('input[name=roomname]').val($.trim(ar[0]));
	$('input[name=howmany]').val($.trim(ar[2]));
	$('input[name=howmuch]').val($.trim(ar[3]));
	let roomtype=$.trim(ar[1]);
	$('#roomtype').val('');
	$('#roomtype option').each(function(){
		if($(this).text()==roomtype){
			$(this).prop('selected','selected');
			return false;
		}
	});
	return false;
})

</script>
</html>
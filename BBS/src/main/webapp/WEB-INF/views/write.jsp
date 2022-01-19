<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<style>
td, th{
	border:1px solid black;
}
</style>
<body align=center>
<form method=post action="/ncs7/write" id=frmWrite>
<table style="border-collapse:collapse" align=center>
	<tr>
		<td>제목</td>
		<td><input type=text id=title name=title></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type=text id=name name=name></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea id=content name=content></textarea></td>
	</tr>
	<tr>
		<td colspan=2><input type=submit id=btnSubmit name=btnSubmit value='작성완료'>
					  <input type=reset id=btnReset name=btnReset value='비우기'>
					  <input type=button id=btnCancel name=btnCancel value='목록보기'>
		</td>
	</tr>
</table>
</form>
</body>
<script src='https:/code.jquery.com/jquery-3.5.0.js'></script>
<script>
$(document)
.on('submit','#frmWrite',function(){
	$('#title').val($.trim($('#title').val()));	// title 좌우 공백 지우고 쌩 title만 저장함
	$('#name').val($.trim($('#name').val()));
	$('#content').val($.trim($('#content').val()));
	if($('#title').val()=='' || $('#name').val()=='' || $('#content').val()==''){
		alert('비어있는 입력란이 있습니다');
		return false;
	}
	return true;
})
.on('click','#btnCancel',function(){
	document.location='/ncs7/list';
	return false;
})
</script>
</html>
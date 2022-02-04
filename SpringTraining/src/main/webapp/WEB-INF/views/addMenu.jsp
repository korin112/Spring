<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴추가</title>
</head>
<body>
<table>
<tr>
		<td>
			<select id= selMenu style='width:200px' size=10>
			<c:forEach items="${MenuList }" var="ML"> 
			<option value=${ML.code}>${ML.menuname },${ML.price }</option>
			</c:forEach>
			</select>
		</td>
<td>
<form action="/exercise/addMenu" id="frmAddMenu">
<input type=hidden id=code name=code>
<!-- primary key를 저장하려고 hidden 사용한거임 -->
<table>
<tr>
<td align=right> 메뉴명 : </td>
<td><input type=text name=menu_name id=mname></td>
</tr>
<tr>
<td align=right> 가격  : </td>
<td><input type=number name=price id=price step=500></td>
</tr>
<tr>
	<td colspan=2 align=center>
	<input type=submit value="추가">
	<input type=button value="삭제" id=btnDelete>
	<input type=reset value="비우기" id=reset>
	</td>
</tr>
</table>
</form>
</table>

</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>

$(document)
.on('submit','#frmAddMenu',function(){
	if($('mname').val() ==''||
			$('price').val() ==''){
		alert('두 값이 입력되어야 합니다.');
		return false;
	}
	return true;
})
.on('click','#selMenu option',function(){
// 	console.log($(this).val()+','+$(this).text());
	$('#code').val($(this).val());
	let str=$(this).text();
	let ar=str.split(',');
	$('input[name=menu_name]').val($.trim(ar[0]));
	$('input[name=price]').val($.trim(ar[1]));
	return false;
})
.on('click','#btnDelete',function(){
	let url="/exercise/deleteMenu?code="+$('#code').val();
	document.location=url;
	console.log(url);
})
.on('click','#reset',function(){
	$('#code,#mname,#price').val('');
})


</script>
</html>
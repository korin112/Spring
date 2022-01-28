<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴추가</title>
</head>
<body>
<form action="/exercise/addMenu" id="frmAddMenu">
메뉴명 :	<input type=text name=menu_name id=mname><br>
가격  :	<input type=number name=price id=price><br>
	<input type=submit value="추가">
</form>
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
</script>
</html>
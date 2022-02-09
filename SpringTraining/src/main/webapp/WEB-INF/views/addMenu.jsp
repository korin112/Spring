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
<%-- 			<c:forEach items="${MenuList }" var="ML">  --%>
<%-- 			<option value=${ML.code}>${ML.menuname },${ML.price }</option> --%>
<%-- 			</c:forEach> --%>
			</select>
		</td>
<td>
<!-- <form action="/exercise/addMenu" id="frmAddMenu"> -->
<input type=text id=code name=code>
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
	<input type=button value="추가" id=btnAdd>
	<input type=button value="삭제" id=btnDelete>
	<input type=button value="비우기" id=btnEmpty>
	</td>
</tr>
</table>
<!-- </form> -->
</table>

</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>

$(document)
.ready(function(){ 						//ja.toString이 들어옴
	loadMenu();
})

.on('click','#btnAdd',function(){
	$.ajax({
		url:"/exercise/addMenu",
		data:{code:$('#code').val(),
			  menu_name:$('#mname').val(),
			  price:$('#price').val()},
		method:"GET",
		datatype:'json',
		beforeSend:function(){},
		success:function(data){
			loadMenu();
		}
	});
	return false;
})

// .on('submit','#frmAddMenu',function(){
// 	if($('mname').val() ==''||
// 			$('price').val() ==''){
// 		alert('두 값이 입력되어야 합니다.');
// 		return false;
// 	}
// 	return true;
// })
.on('click','#selMenu option',function(){
// 	console.log($(this).val()+','+$(this).text());
	$('#code').val($(this).val());
	let str=$(this).text();
	console.log(str);
	let ar=str.split(',');
	$('input[name=menu_name]').val($.trim(ar[0]));
	$('input[name=price]').val($.trim(ar[1]));
	return false;
})
.on('click','#btnDelete',function(){
	let url="/exercise/deleteMenu?code="+$('#code').val();
	document.location=url;
})
// .on('click','#reset',function(){
// 	$('#code,#mname,#price').val('');
// })
function loadMenu(){
	$('#code,#mname,#price').val();
	$.ajax({ url:"/exercise/menuadd1",
		data: {},
		method:"GET",
		datatype:"json",
		success:function(txt){	//model로 받아오는걸 ajax호출로 하는거임
			$('#selMenu').empty();
			for(i=0; i<txt.length; i++){
				let str='<option value='+txt[i]['code']+'>'+txt[i]['menuname']+', '+txt[i]['price']+'</option>';
				console.log(str);
				$('#selMenu').append(str);
			}
		}
});
}

</script>
</html>
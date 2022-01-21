<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head> 
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
	<title>Cafe Management</title>
</head>
<style>

</style>
<body align=center>
<h1>
	주문관리  
</h1>
<table style='border-collapse:collapse;' align=center >
	<tr>
		<td style='border:1px solid black;'>
			<table>
			<tr style='height:30px;'><td align=center>메뉴목록<button id=btnMenu>메뉴관리</button></td></tr>
			<tr><td><select id=selMenu style='width:224px' size=10>
<c:forEach var="menu" items="${ml}"> 	
		<option value="${menu.code}">${menu.name},${menu.price}</option>		
</c:forEach>
			</select></td></tr>
			<tr><td>메뉴명&nbsp;<input type=text id=menuname name=menuname readonly size=10>
				<input type=hidden id=code name=code>
			</td></tr>
			<tr><td>수량&nbsp;&nbsp;&nbsp;&nbsp;<input type=number id=qty name=qty min=1 style='width:60px'></td></tr>
			<tr><td>금액&nbsp;&nbsp;&nbsp;&nbsp;<input type=number id=price name=price readonly style='width:100px'>
				<input type=hidden id=net name=net>
			</td></tr>
			<tr><td align=right><button id=btnAdd >추가</button>&nbsp;<button id=btnReset>비우기</button></td></tr>
			</table>
		</td>
		<td style='border:1px solid black;'>
			<table>
			<tr style='height:30px;'><td align=center>주문내역</td></tr>
			<tr><td><select id=selOrder style='width:224px' size=10></select></td></tr>
			<tr><td>총액&nbsp;<input type=number id=total name=total style='width:100px;' readonly></td></tr>
			<tr><td>모바일&nbsp;<input type=text id=mobile name=mobile size=12></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td align=right><button id=btnOrder>주문완료</button>&nbsp;<button id=btnCancel>주문취소</button>
			</table>
		</td>
		<td style='border:1px solid black;' valign=top>
			<table>
			<tr style='height:30px;'><td align=center>매출내역</td></tr>
			<tr><td><select id=selSales style='width:224px;' size=17></select></td></tr>
			</table>
		</td>	
	</tr>
</table>
<div style='display:none; width:600px;' id='dlgMenu' >
<table>
<tr>
	<td valign=top>
		<select id="selMenu1" size=10 style='width:200px'></select>
	</td>
	<td valign=top>
		<table>
		<tr><td>Code&nbsp;<input type=text id=d_code name=d_code size=3 readonly></td></tr>
		<tr><td>Name&nbsp;<input type=text id=d_name name=d_name size=20></td></tr>
		<tr><td>Price&nbsp;<input type=number id=d_price name=d_price style='width:100px' step=500></td></tr>
		<tr><td align=right><button id=btnDone>완료</button>&nbsp;<button id=btnEmpty>비우기</button></td></tr>
		</table>
	</td>
</tr>
</table>
</div>
</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<script>
$(document)
.on('click','#btnOrder',function(){
	if($('#mobile').val()==''){
		if(confirm('모바일번호를 입력하시겠습니까?')) return false;
		$('#mobile').val('Guest');
	}
	$('#selOrder option').each(function(){
		let str='<option>'+$('#mobile').val()+' '+$(this).text()+'</option>';	
		$('#selSales').append(str);
	});
	$('#total,#mobile').val('');
	$('#selOrder').empty();
	//AJAX호출로 DB에 주문내역 저장
	return false;
})

.on('click','#btnCancel',function(){
	if(confirm('모든 주문을 취소할까요?')){
		$('#total,#mobile').val('');
		$('#selOrder').empty();
	}
	return false;
})

.on('click','#btnAdd',function(){
	let str='<option value='+$('#code').val+'>'+$('#menuname').val()+' x'+$('#qty').val()+' '+$('#price').val()+'</option>';
	$('#selOrder').append(str);
	$('#code,#menuname,#price,#net,#qty').val('');
	getSum();
	return false;
})

.on('keydown','#qty',function(event,ui){
	if(event.keyCode==13){	// 엔터를 눌렀을때 나오는 keycode
		$('#btnAdd').trigger('click');
	}
	return false;
})

.on('keydown','#d_code,#d_name,#d_price',function(event,ui){
   if(event.keyCode==13){
      $('#btnDone').trigger('click');
      return false;
   }      
})

.on('click','#selMenu option',function(){
	$('#code').val($(this).val());
	let txt=$(this).text();	
	let ar=txt.split(',');
	$('#menuname').val($.trim(ar[0]));
	$('#price,#net').val($.trim(ar[1]));
	$('#qty').val(1);
	return false;
})

.on('change','#qty',function(){
	let qty=parseInt($(this).val());
	let net=parseInt($('#net').val());
	$('#price').val(qty*net);
	return false;
	
})

.on('click','#selMenu1 option',function(){
	$('#d_code').val($(this).val()); // this = selmenu1에서 클릭한 option 중 1
	let txt=$(this).text();	// name,price의 text
	let ar=txt.split(',');
	$('#d_name').val($.trim(ar[0]));
	$('#d_price').val($.trim(ar[1]));
	return false;
})
.on('click','#btnReset',function(){
	$('#menuname,#qty,#price').val('');
})
.on('click','#btnEmpty',function(){
	$('#d_code,#d_name,#d_price').val('');
// 	$('input[id^="d_"]').val('');	// id가 d_로 시작하는 input tag에 빈문자열을 넣어라 하지만 이건 위험함 나도 모르는 d_로 시작한거 쓸 수도 있으니
	return false; // prevent code from bubbling
})

.on('click','#btnMenu',function(){
	$('#dlgMenu').dialog({
		modal:true,
		width:500,
		open:function(){
			loadMenu('selMenu1');
		},
		close:function(){
			loadMenu('selMenu');
		}
	});
	return false;
})

.on('click','#btnDone',function(){
	if($('#d_code').val()==''){ // insert or nothing
		if($('#d_name').val()!='' && $('#d_price').val()!=''){
			operation="insertMenu";
		} else{
			alert('메뉴이름과 가격이 입력되어야 합니다.');
			return false;
		  }
	} 
	else{	//delete or update
		if($('#d_name').val()!='' && $('#d_price').val!=''){
			operation="updateMenu";
		} else{
			operation="deleteMenu";
		  }
	}
	let oParam={code:$('#d_code').val(),name:$('#d_name').val(),price:$('#d_price').val()};	// 3개 값을 보내야함
	$.post('/cafe/'+operation,oParam,function(txt){
		if(txt=="ok"){			//return 값이 ok냐 fail이냐로 나눠서 실행
			$('#selMenu1').empty();
			loadMenu('selMenu1');
		} else {
			alert(operation+' was failed');
		}
	},'text'); // json 아니고 ajax
	return false;
})
;


function loadMenu(selTarget){	//중복되는 코드를 한 묶음으로 만듦
	$('#'+selTarget).empty();
	$.post('/cafe/list',{},function(txt){	// post방식으로 ajax 실행
		for(i=0; i<txt.length; i++){
			let mo=txt[i];
			let str='<option value='+mo['code']+'>'+mo['name']+','+mo['price']+'</option>';
			$('#'+selTarget).append(str);
			
		}
	},'json'); //'json' 타입으로 보내줘야됨
}
function getSum(){
	let total=0;
	$('#selOrder option').each(function(){
		let str=$(this).text();
		let ar=str.split(' ');
		total+=parseInt(ar[2]);
	});
	$('#total').val(total);
}

</script>
</html>

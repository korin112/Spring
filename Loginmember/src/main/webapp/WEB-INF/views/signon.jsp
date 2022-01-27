
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signon</title>
</head>
<style>
table{
	border-collapse:collapse;
	border:1px solid black;
}
td{
	border:1px solid black;
}
</style>
<body>
<form method="post" action="/login/insertLogin">
		<table align=center>
			<tr>
				<td align=left>실명</td>
				<td align=left><input type=text id=name name=name></td>
			</tr>
			<tr>
				<td align=left>성별</td>
				<td align=left size=40px><input type=radio id=male name=gender
					value=male>남성 <input type=radio id=female name=gender
					value=female>여성</td>
			</tr>

			<tr>
				<td align=left>로그인아이디</td>
				<td align=left><input type=text id=userid name=userid></td>
				<td><input type=button id=btnsign name=btnsign value=중복확인></td>
			</tr>
			<tr>
				<td align=left>비밀번호</td>
				<td align=left><input type=password id=passcode name=passcode
					id=passcode size=20></td>
			</tr>
			<tr>
				<td align=left>비밀번호 확인</td>
				<td align=left><input type=password id=passcode1 name=passcode1
					id=passcode1 size=20></td>
			</tr>

			<tr>
				<td align=left>관심분야</td>
				<td valign=top>
				<input type=checkbox value=정치 id=politics name=interest>정치&nbsp;
				 <input type=checkbox value=경제	 id=economics name=interest>경제&nbsp;
				  <input type=checkbox value=사회 id=society name=interest>사회&nbsp; 
				  <input type=checkbox value=문화 id=culture name=interest>문화&nbsp;<br>
					<input type=checkbox value=역사 id=history name=interest>역사&nbsp;
					<input type=checkbox value=연예 id=entertainment name=interest>연예&nbsp;
					<input type=checkbox value=스포츠 id=sport name=interest>스포츠&nbsp;
					<input type=checkbox value=예술 id=art name=interest>예술&nbsp;
				</td>
			</tr>
			<tr>
				<td colspan=2><input type=submit value='가입완료'>
					&nbsp;&nbsp; <input type=reset value='취소' id=cancel1 onclick='document.location=/login/'></td>
			</tr>
		</table>
	</form>
</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
let flag2='';
$(document)
.on('click','#btnsign',function(){
	$.post("/login/sign_check",{},function(txt){
	console.log(txt);
	let flag="";
		for(var i=0; i<txt.length; i++){
			if($('#userid').val()==txt[i]['userid']){
				flag="ok";
				break;
			}
			else{
				flag="fail";
			}
		}
		if(flag=="ok"){
			alert("중복된 아이디입니다");
			flag2='false';
		} else{
			alert("사용가능한 아이디입니다");
		}
	},'json');
})

.on('submit',function(){
	if(flag2=='false'){
		alert('아이디 중복확인');
		return false;
	}
	if ($('#name').val() == '') {
		alert('이름을 확인해주세요.');
		return false;
	} else if ($('input[name=gender]:checked').val() == undefined) {
		alert('성별을 체크해주세요');
		return false;
	}else if ($('#userid').val() == '') {
		alert('로그인아이디를 확인해주세요')
		return false;
	} else if ($('#passcode').val() == '') {
		alert('비밀번호를 확인해주세요')
		return false;
	} else if ($('#passcode1').val() == '') {
		alert('비밀번호확인을 확인해주세요')
		return false;
	} else if ($('#passcode').val() != $('#passcode1').val()) {
		alert('비밀번호가 같지 않습니다');
		return false;
	} else if ($('input[name=interest]:checked').val() == undefined) {
		alert('관심분야를 확인해주세요');
		return false;
	}else {
		alert('회원가입이 완료되었습니다.');
		return true; 
	}
})

</script>
</html>

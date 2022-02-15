<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<c:set var="path" value="${pageContext.request.contextPath}"/>
 <link href="${path}/resources/css/Homeinfo.css" rel="stylesheet" >
<title>예약</title>
</head>
<body>

<jsp:include page="header.jsp" />
<div id=div_body style="margin-bottom:-250px; height:906px;">
<h1 align=center style="font-size:48px; font-weight:bold; letter-spacing:11px; margin-left:-95px;">객실예약</h1> <!-- ${name} -->
<h2 align=center; style="color:#ccc; margin-left:778px; letter-spacing:12px; font-size:24px;">Reservation</h2>


<form action="/hotel/bookcheck" id="frmbook">
<div style=" height:500px; width: 33%; margin-left:620px; margin-top:75px">
<table>
<tr><td>roomcode : <input type=text id=roomcode name=roomcode align=left></td></tr>

<tr><td style="padding:5px 0px 5px 0px;">날짜 : <input type=date id=start_dt name=start_dt>~<input type=date id=end_dt name=end_dt></td></tr>
<div class="input-group input-group-sm mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm" style="width:110px;">인원</span>
  </div>
  <input type="text" type=number id=howmany name=howmany class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
     
</div>
<div class="input-group input-group-sm mb-3">
     <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm" style="width:110px;">가격</span>
  </div>
  <input type="text" type=number id=howmuch name=howmuch class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
</div>

<div class="input-group input-group-sm mb-3">
     <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm" style="width:110px;">예약자</span>
  </div>
  <input type="text" type=text id=booker name=booker class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
</div>

<div class="input-group input-group-sm mb-3">
     <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-sm" style="width:110px;">예약자번호</span>
    
  </div>
  <input type="text" type=text id=mobile name=mobile class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
</div>

<tr><td>
<div class="d-grid gap-2 d-md-flex justify-content-md-end">  
  <input class="btn btn-primary" type="submit" id=btnGo value="예약" style="width:182px; letter-spacing:9px;">
</div>
</td></tr>
   </table>
</div>
</form>
</div>
</body>
<jsp:include page="footer.jsp" />
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script src='https://code.jquery.com/ui/1.13.0/jquery-ui.js'></script>
<script>
$(document)
.on('submit',function(){
   alert(($('#howmany').val()));
})
</script>
</html>
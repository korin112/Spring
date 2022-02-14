<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
*{ margin: 0; padding: 0; box-sizing: border-box; } li{ list-style-type: none; } /* 보여줄 구간의 높이와 넓이 설정 */ #slideShow{ width: 500px; height: 300px; position: relative; margin: 50px auto; overflow: hidden; /*리스트 형식으로 이미지를 일렬로 정렬할 것이기 때문에, 500px 밖으로 튀어 나간 이미지들은 hidden으로 숨겨줘야됨*/ } .slides{ position: absolute; left: 0; top: 0; width: 2500px; /* 슬라이드할 사진과 마진 총 넓이 */ transition: left 0.5s ease-out; /*ease-out: 처음에는 느렸다가 점점 빨라짐*/ } /* 첫 번째 슬라이드 가운데에 정렬하기위해 첫번째 슬라이드만 margin-left조정 */ .slides li:first-child{ margin-left: 100px; } /* 슬라이드들 옆으로 정렬 */ .slides li:not(:last-child){ float: left; margin-right: 100px; } .slides li{ float: left; } .controller span{ position:absolute; background-color: transparent; color: black; text-align: center; border-radius: 50%; padding: 10px 20px; top: 50%; font-size: 1.3em; cursor: pointer; } /* 이전, 다음 화살표에 마우스 커서가 올라가 있을때 */ .controller span:hover{ background-color: rgba(128, 128, 128, 0.11); } .prev{ left: 10px; } /* 이전 화살표에 마우스 커서가 올라가 있을때 이전 화살표가 살짝 왼쪽으로 이동하는 효과*/ .prev:hover{ transform: translateX(-10px); } .next{ right: 10px; } /* 다음 화살표에 마우스 커서가 올라가 있을때 이전 화살표가 살짝 오른쪽으로 이동하는 효과*/ .next:hover{ transform: translateX(10px); }


</style>
<body>
	<div id="slideShow">
		<ul class="slides">
			<li><img src="https://new.stjohns.co.kr/uploads/room/2021/07/b62fd722965492931762e00fddfbb073.png" width="1100" height="300" alt=""></li>
			<li><img src="https://new.stjohns.co.kr/uploads/room/2021/07/0a0489a2dacb993e999da3445cc29304.JPG" width="1100" height="300" alt=""></li>
			<li><img src="https://new.stjohns.co.kr/uploads/room/2021/07/a5fcffd4dec1431e512ad3938de3b944.jpg" width="1100" height="300" alt=""></li>
			<li><img src="https://new.stjohns.co.kr/uploads/room/2021/07/69580eba4eeb2b5ca9a317a9f0bb28a8.png" width="1100" height="300" alt=""></li>
			<li><img src="https://new.stjohns.co.kr/uploads/room/2021/07/e8746b1694da0485f73b64ed1e05d839.jpg" width="1100" height="300" alt=""></li>
		</ul>
		<p class="controller">
			<!-- &lang: 왼쪽 방향 화살표 &rang: 오른쪽 방향 화살표 -->
			<span class="prev">&lang;</span> <span class="next">&rang;</span>
		</p>
	</div>
</body>
<script>



</script>
</html>
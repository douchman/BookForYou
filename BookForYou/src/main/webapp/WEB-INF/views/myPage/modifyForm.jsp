<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
	font-family: 'Noto Serif KR', serif;
}

.area-divide-50{
	height: 50px;
}

.area-divide-25{
	height: 25px;
}


.txt-head{
	color: #4682B4;
}

.txt-item{
	color: #1E90FF;
}

label{

font-size: 12pt;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../common/header2.jspf"%>

	<div id="wrapper" class="container row col-md-6 col-md-offset-3" align="center">
	
	
	
	<h2 class="txt-head">[ ${sessionLogin.usrnickname } ]님 정보 수정</h2>
	
		<div class="area-divide-50"></div>
		<!-- FORM! -->
		<form id="frm1" method="post" action="">
		<div class="col-md-6 col-md-offset-3">
			<div class="row" style="text-align: left;">
				<h4 class="txt-item col-md-4">별명</h4>
			</div>
			<div class="row">
				<input class="form-control col-md-4" style="width: 320px; margin-right: 20px;" id="usrnickname" name="usrnickname" type="text" value="${sessionLogin.usrnickname }">
				<input id="chkNickname" class="btn btn-primary col-md-3" type="button" value="중복확인"> 		
			</div> 
			
			<div class="area-divide-25"></div>
			
			<div class="row" style="text-align: left;">
				<h4 class="txt-item col-md-4">패스워드</h4>
			</div>
			<div class="row">
				<input class="form-control col-md-4" id="pw" name="pw" type="password" > 		
			</div>
			
			<div class="area-divide-25"></div>
			
			<div class="row" style="text-align: left;">
				<h4 class="txt-item col-md-6">패스워드 확인</h4>
			</div>
			
			<div class="row">
				<input class="form-control col-md-4" id="pwok" name="pwok" type="password" > 		
			</div>
			<div class="area-divide-25"></div>
			<!-- 패스워드 유효검사 메시지  -->	
			<div class="pwChkMsg" style="text-align: left;">
				<span id="pwChkMsg"></span>
			</div>
			
			
			<div class="area-divide-25"></div>
			
			<div class="row" style="text-align: left;">
				<h4 class="txt-item col-md-6">연령대 설정</h4>
			</div>
		
			
			<div class="btn-group col-md-8">
					<input id="ageValue" name="age" type="hidden" value="${sessionLogin.age}">
					<button id="btnAge" type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false"><span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<!-- javascript:void(0); 페이지 상단으로 이동하는 것 방지 차원 -->
						<li><a href="javascript:void(0);" onclick="setAge(10, this);">20대 미만</a></li>
						<li><a href="javascript:void(0);" onclick="setAge(20, this);">20대</a></li>
						<li><a href="javascript:void(0);" onclick="setAge(30, this);">30대</a></li>				
						<li><a href="javascript:void(0);" onclick="setAge(40, this);">40대</a></li>
						<li><a href="javascript:void(0);" onclick="setAge(50, this);">50대 이상</a></li>
					</ul>
			</div>
				
			
		
			<div class="area-divide-50"></div>
			
			<div class="row" style="text-align: left;">
				<h4 class="txt-item col-md-6">관심사 설정</h4>
			</div>
			
			<div class="area-divide-25"></div>

			<input type="hidden" id="favorite1" name="favorite" value="${sessionLogin.favorite}">
			<div class="row">
				<div class="row">
					<div class="col-md-6" style="margin-top: 5px;">
						<label class="item-txt"> #1 회원님의 관심사</label>
					</div>
					<div class="btn-group col-md-6">

						<button id="fav1" type="button"
							class="btn btn-default dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false">
							분류 선택 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">

					<li><a href="javascript:void(0);" onclick="setFav(0,1,this,0)">총류/사전</a></li>
					<li><a href="javascript:void(0);" onclick="setFav(0,1,this,1)">철학/심리학/윤리</a></li>
					<li><a href="javascript:void(0);" onclick="setFav(0,1,this,2)">종교</a></li>
					<li><a href="javascript:void(0);" onclick="setFav(0,1,this,3)">사회과학</a></li>
					<li><a href="javascript:void(0);" onclick="setFav(0,1,this,4)">자연과학</a></li>
					<li><a href="javascript:void(0);" onclick="setFav(0,1,this,5)">기술과학</a></li>
					<li><a href="javascript:void(0);" onclick="setFav(0,1,this,6)">예술</a></li>
					<li><a href="javascript:void(0);" onclick="setFav(0,1,this,7)">언어</a></li>
					<li><a href="javascript:void(0);" onclick="setFav(0,1,this,8)">문학</a></li>
					<li><a href="javascript:void(0);" onclick="setFav(0,1,this,9)">역사/지리/관광</a></li>

						</ul>
					</div>
				</div>
			</div>
			
			<div class="area-divide-25"></div>
			
			<input type="hidden" id="favorite2" name="favorite2" value="${sessionLogin.favorite2}">
			<div class="row">
				<div class="row">
					<div class="col-md-6" style="margin-top: 5px;">
						<label class="item-txt"> #2 회원님의 관심사</label>
					</div>
					<div class="btn-group col-md-6">

						<button id="fav2" type="button"
							class="btn btn-default dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false">
							분류 선택 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">

							<li><a href="javascript:void(0);" onclick="setFav(0,2,this,0)">총류/사전</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,2,this,1)">철학/심리학/윤리</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,2,this,2)">종교</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,2,this,3)">사회과학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,2,this,4)">자연과학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,2,this,5)">기술과학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,2,this,6)">예술</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,2,this,7)">언어</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,2,this,8)">문학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,2,this,9)">역사/지리/관광</a></li>


						</ul>
					</div>
				</div>
			</div>
			
			<div class="area-divide-25"></div>

			<input type="hidden" id="favorite3" name="favorite3" value="${sessionLogin.favorite3}">
			<div class="row">
				<div class="row">
					<div class="col-md-6" style="margin-top: 5px;">
						<label class="item-txt"> #3 회원님의 관심사</label>
					</div>
					<div class="btn-group col-md-6">

						<button id="fav3" type="button"
							class="btn btn-default dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false">		
							분류 선택 <span class="caret"></span>
						</button>		
						<ul class="dropdown-menu" role="menu">					
						<li><a href="javascript:void(0);" onclick="setFav(0,3,this,0)">총류/사전</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,3,this,1)">철학/심리학/윤리</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,3,this,2)">종교</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,3,this,3)">사회과학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,3,this,4)">자연과학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,3,this,5)">기술과학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,3,this,6)">예술</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,3,this,7)">언어</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,3,this,8)">문학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,3,this,9)">역사/지리/관광</a></li>

						</ul>
					</div>
				</div>
			</div>
			
			<div class="area-divide-50"></div>
			
			<div class="col-md-4 col-md-offset-4">
				<input class="btn btn-info" type="submit" value="수정 하기"> 
			</div>
					
		</div>
		</form>
		
	</div>

	<%@ include file="../common/footer.jspf"%>
	<script src='<c:url value="/resources/js/modifyForm.js?ver=1" />'></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form>
		<div class="col-md-6 col-md-offset-3">
			<div class="row" style="text-align: left;">
				<h4 class="txt-item col-md-4">별명</h4>
			</div>
			<div class="row">
				<input class="form-control col-md-4" id="usrnickname" name="usrnickname" type="text" value="${sessionLogin.usrnickname }"> 		
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
				<span id="pwChkMsg">비밀번호 일치여부 확인 메시지</span>
			</div>
		
			<div class="area-divide-25"></div>
			
			<div class="row" style="text-align: left;">
				<h4 class="txt-item col-md-6">관심사 설정</h4>
			</div>
			
			<div class="area-divide-25"></div>

			<div class="row">
				<input type="hidden" id="favorite1" name="favorite" value="">

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

							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">예술</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">종교</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">과학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">사랑</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">공포</a></li>

						</ul>
					</div>
				</div>
			</div>
			
			<div class="area-divide-25"></div>

			<div class="row">
				<input type="hidden" id="favorite1" name="favorite" value="">

				<div class="row">
					<div class="col-md-6" style="margin-top: 5px;">
						<label class="item-txt"> #2 회원님의 관심사</label>
					</div>
					<div class="btn-group col-md-6">

						<button id="fav1" type="button"
							class="btn btn-default dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false">
							분류 선택 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">

							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">예술</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">종교</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">과학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">사랑</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">공포</a></li>

						</ul>
					</div>
				</div>
			</div>
			
			<div class="area-divide-25"></div>

			<div class="row">
				<input type="hidden" id="favorite1" name="favorite" value="">

				<div class="row">
					<div class="col-md-6" style="margin-top: 5px;">
						<label class="item-txt"> #3 회원님의 관심사</label>
					</div>
					<div class="btn-group col-md-6">

						<button id="fav1" type="button"
							class="btn btn-default dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false">
							분류 선택 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">

							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">예술</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">종교</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">과학</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">사랑</a></li>
							<li><a href="javascript:void(0);" onclick="setFav(0,1,this)">공포</a></li>

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
</body>
</html>
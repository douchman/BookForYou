<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.inputfield {
	margin-bottom: 30px;
}

.chkinput {
	margin-right: 15px;
}

.itemtxt {
	color: #1E90FF;
}

.span-radio {
	font-size: 15pt;
	margin-right: 40px;
}

.span-radio .radio-gender {
	width: 15px;
	height: 15px;
	margin-right: 5px;
}


@-webkit-keyframes fadein { /* Safari and Chrome */
    from {
        opacity:0;
    }
    to {
        opacity:1;
    }
}


.head{
	-webkit-animation : fadein 3s;
	animation-delay : 10ms;
}

.head .head-title{
	color: #4682B4;
	margin-bottom: 50px;
}

.head .head-sub{
	color: #808080;
}

.head .sub{
	color: #808080;
	margin-bottom: 80px;
}


.e1{
	-webkit-animation : fadein 3s;
	animation-delay : 30ms;
}

.e2{
	-webkit-animation : fadein 3s;
	animation-delay : 50ms;
}
.e3{
	-webkit-animation : fadein 3s;
	animation-delay : 70ms;
}
.e4{
	-webkit-animation : fadein 3s;
	animation-delay : 90ms;
	
}

.e4>input{

margin-bottom: 10px;
	
}

.e5{
	-webkit-animation : fadein 3s;
	animation-delay : 110ms;
}

.e6{
	-webkit-animation : fadein 3s;
	animation-delay : 130ms;
}

.e7{
	-webkit-animation : fadein 3s;
	animation-delay : 50ms;
}

#brandlogo{

	padding-bottom: 45px;
}
</style>

<meta charset="UTF-8">
<title>BookForYou - 필수입력사항</title>
</head>
<body>
	<%@ include file="../common/header2.jspf"%>




<form method="post">
	<div class="container">

	
		<div class="head" align="center">
			<h1 class="head-title"> <img src='<c:url value="/resources/img/textlogo_resize.png"/>'>  와 함께하기 1단계 </h1>
		
			<h4 class="head-sub"> 회원님의 정보를 입력해주세요. </h4>
			<br><br>
			<h4 class="head-sub sub"> 모든 정보를 입력하시면 다음으로 넘어갑니다. </h4>
		</div>


		<div class="row e1">
			<h4 class="itemtxt col-md-2 col-md-offset-4">ID(Email)</h4>
			<br>
		</div>
		<div class="row inputfield e1">
			<input id="usrid" type="email" name="usrid" value="${member.usrid }"
				class="chkinput col-md-4 form-control col-md-offset-4"
				placeholder="아이디(이메일)" aria-describedby="basic-addon1"
				style="width: 300px; font-size: 12pt;"> 
				
				<input type="button"class="btn btn-primary" value="중복확인">
		</div>


		<div class="row e2">
			<h4 class="itemtxt col-md-2 col-md-offset-4">닉네임</h4>
			<br>
		</div>
		<div class="row inputfield e2">
			<input id="usrnickname" type="text" name="usrnickname" value="${member.usrnickname}"
				class="chkinput col-md-4 form-control col-md-offset-4"
				placeholder="2 ~ 8  글자" aria-describedby="basic-addon1"
				style="width: 300px; font-size: 12pt;"> 
				
				<input type="button"class="btn btn-primary" value="중복확인">
		</div>


		<div class="row e3">
			<h4 class="itemtxt col-md-2 col-md-offset-4">패스워드</h4>
			<br>
		</div>
		<div class="row inputfield e3">
			<input id="pw" name="pw" type="text" class="col-md-4 form-control col-md-offset-4"
				placeholder="숫자, 영문, 특수문자 포함" aria-describedby="basic-addon1"
				style="width: 300px; font-size: 12pt;">
		</div>


		<div class="row e4">
			<h4 class="itemtxt col-md-2 col-md-offset-4">패스워드 확인</h4>
			<br>
		</div>

		<div class="row inputfield e4">
			<input id="pwOk" type="text"
				class="col-md-4 form-control col-md-offset-4" placeholder="패스워드 재입력"
				aria-describedby="basic-addon1"
				style="width: 300px; font-size: 12pt;">
				
			<!-- 패스워드 유효검사 메시지  -->	
			<div class="row pwChkMsg">
				<span class="col-md-4 col-md-offset-4" id="pwChkMsg"></span>
			</div>
		</div>



		<div class="row e5">
			<h4 class="itemtxt col-md-2 col-md-offset-4">성별 구분</h4>
			<br>
		</div>

		<div class="row inputfield e5">

			<div class="col-md-4 col-md-offset-4">
				<span class="span-radio"><input class="radio-gender"
					name="gender" type="radio" value="M">남성</span> <span
					class="span-radio"><input class="radio-gender" name="gender"
					type="radio" value="W">여성</span>
			</div>

		</div>



		<div class="row e6">
			<h4 class="itemtxt col-md-2 col-md-offset-4">연령대 선택</h4>
			<br>
		</div>
		<div class="row inputfield e6">

			<div class="col-md-4 col-md-offset-4">

				<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false">연령<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">20대 미만</a></li>
						<li><a href="#">20대</a></li>
						<li><a href="#">30대</a></li>				
						<li><a href="#">40대</a></li>
						<li><a href="#">50대 이상</a></li>
					</ul>
				</div>

			</div>

		</div>



		<!-- onclick="location.href='nextMemberShipPage'" -->
		<div class="row e7">
			<!--  
			<a href="nextMemberShipPage"><button class="btn btn-primary col-md-1 col-md-offset-7">
				<span>다음 </span><span class="glyphicon glyphicon-arrow-right"></span>
			</button></a>
			-->
			<input type="submit" 
			class="btn btn-primary col-md-1 col-md-offset-7" 
			value="다음"
			onclick="javascript: form.action='nextMemberShipPage';"
			>
		</div>


	</div>

</form>
	<%@ include file="../common/footer.jspf"%>
	
	<script src='<c:url value="/resources/js/memberForm.js" />'></script>
</body>
</html>
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

@-webkit-keyframes fadein{ 

/* Safari and Chrome */ 
from { opacity:0;
	
}

to {
	opacity: 1;
	}
}


#wrapper .area-title, .area-head{
	-webkit-animation : fadein 3s;
	animation-delay : 50ms

}

.area-head .head-title{
	color: #4682B4;
	margin-bottom: 40px;
}


#wrapper .area-title #headline{
	color: #808080;
}

#wrapper .area-subtitle{
	padding-bottom: 25px;
	-webkit-animation : fadein 3s;
	animation-delay : 80ms
}


#wrapper .area-subtitle h5{
	padding-bottom: 20px;
	color:#B0C4DE;

}

#wrapper .seq1{
	-webkit-animation : fadein 3s;
	animation-delay : 180ms
}


#wrapper .seq2{
	-webkit-animation : fadein 3s;
	animation-delay : 220ms
}


#wrapper .seq3{
	-webkit-animation : fadein 3s;
	animation-delay : 260ms
}


#wrapper .area-btn{
 	padding-top: 40px;
 	-webkit-animation : fadein 4s;
	animation-delay : 140ms
 }

#wrapper .area-interest{
	margin-bottom: 50px;
}

.area-interest .item-txt{
	color: #1E90FF;
	font-size: 15pt;
}


</style>

<meta charset="UTF-8">
<title>BookForYou - 선택 입력 사항</title>
</head>
<body>
	<%@ include file="../common/header2.jspf"%>



	
	<div id="wrapper" align="center" class="container">

		<div class="area-head">
			
			<h1 class="head-title"> <img src='<c:url value="/resources/img/textlogo_resize.png"/>'> 와 함께하기 2단계 </h1>
			
		</div>

		<div class="area-title" style="height: 150px;">
			<h4 id="headline">회원님의 관심사를 표현해 주세요.</h4	>
			<br>	
			<h4 id="headline">회원님의 소중한 정보는 회원님께 알맞은 책을 추천해드리는데 도움이 된답니다.</h4>

		</div>

		<div class="area-subtitle">
	
		<h5 class="h-title1"> 모든 관심사를 다 적으실 필요는 없습니다. </h5>
		<h5 class="h-title2"> 원하시는 관심사만 설정해주세요. </h5>
		<h5 class="h-title3"> 이 과정을 건너뛰어도 서비스 이용에  문제되지 않습니다! </h5>
			
	</div>
		

		<div class="area-interest seq1">
			<span class="item-txt"> #1회원님의 관심사</span>
			<div class="btn-group">
				<button type="button" class="btn btn-default dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false">
					분류 선택 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">예술</a></li>
					<li><a href="#">종교</a></li>
					<li><a href="#">과학</a></li>
					<li><a href="#">사랑</a></li>
					<li><a href="#">공포</a></li>
				</ul>
			</div>
		</div>

		<div class="area-interest seq2">
			<span class="item-txt"> #2 회원님의 관심사</span>
			<div class="btn-group">
				<button type="button" class="btn btn-default dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false">
					분류 선택 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">예술</a></li>
					<li><a href="#">종교</a></li>
					<li><a href="#">과학</a></li>
					<li><a href="#">사랑</a></li>
					<li><a href="#">공포</a></li>
				</ul>
			</div>
		</div>
		
		<div class="area-interest seq3">
			<span class="item-txt"> #3 회원님의 관심사</span>
			<div class="btn-group">
				<button type="button" class="btn btn-default dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false">
					분류 선택 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">예술</a></li>
					<li><a href="#">종교</a></li>
					<li><a href="#">과학</a></li>
					<li><a href="#">사랑</a></li>
					<li><a href="#">공포</a></li>
				</ul>
			</div>

		</div>


		<div class="row area-btn">
			<button onclick="location.href='previousMemberShipPage'" class="btn btn-primary col-md-2 col-md-offset-3">
				<span class="glyphicon glyphicon-arrow-left"></span><span> 이전</span>
			</button>
			
			<button onclick="location.href='myPage'" class="btn btn-primary col-md-2 col-md-offset-2">
				<span>마이페이지 임시 이동 </span><span class="glyphicon glyphicon-arrow-right"></span>
			</button>
		</div>



	</div>


	<%@ include file="../common/footer.jspf"%>
</body>
</html>
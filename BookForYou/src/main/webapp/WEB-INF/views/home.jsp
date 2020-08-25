<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>BookForYou</title>
<style>
.item {
	width: 100%;
	height: 95%;
}

img {
	width: 100%;
	height: 95%;
}

.btn {
	width: 20%;
}

.ghost-button {
	width: 25%;
	height: 3%;
	font-size: 40;
	font-weight: bolder;
	align-items: center;
	display: inline-block;
	padding: 25px 40px;
	margin: 320px 70px;
	border: 0px solid #d43f3a;
	border-radius: 10px;
	background-color: #d43f3a;
    background-color: rgba( 217, 83, 79, 0 );
	text-align: center;
}

.ghost-button:hover {
	background-color: rgba( 217, 83, 79, 0 );
	color: #46b8da;
}

.contactfield {
	background-color: #222222;
}
</style>
<script>
	$('.carousel').carousel({ interval: 2000 })
</script>
</head>
<body>
	<input id="loginState" type="hidden" value="${loginState}">
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="d-block w-100" src="https://post-phinf.pstatic.net/MjAxOTA5MjFfMTM2/MDAxNTY5MDI4ODUwMzA3.R9Yu6RGesmK-iGtw5fSGPxOeI6tuc7W6WgcFuJvbN4Ug.8eSfJVX2iAFId5_2v92x26vJ_VYXRxYr8yGJXf8uv68g.JPEG/0.jpg?type=w1200" alt="First slide">
				<div class="carousel-caption">
					<input type="button" class="ghost-button" name="enter" onclick="enterMain();" value="입 장 하 기">
				</div>
			</div>
			<div class="item">
				<img class="d-block w-100" src="https://images.pexels.com/photos/2355519/pexels-photo-2355519.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260" alt="Second slide">
				<div class="carousel-caption">
					<input type="button" class="ghost-button" name="enter" onclick="enterMain();" value="입 장 하 기">
				</div>
			</div>
			<div class="item">
				<img class="d-block w-100" src="${pageContext.request.contextPath}/resources/img/book1.jpg" alt="Third slide">
				<div class="carousel-caption">
					<input id="enterMain" type="button" class="ghost-button" name="enter" onclick="enterMain();" value="입 장 하 기">
				</div>
			</div>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<script type="text/javascript">
	
		function enterMain() {
			var loginState = $('#loginState').val();
			
			if(loginState == '1')
				location.href="main";
			else{
				alert("로그인을 먼저 해주십시오")
				location.href="signin";
		}
		}
		
	</script>
</body>
</html>

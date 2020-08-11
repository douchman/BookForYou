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
.carousel-inner>.carousel-item>img { /* width: 640px; height: 720px; */
	
}

#demo {
	width: 100%;
	height: 95%;
}

img {
	width: 100%;
	height: 95%;
}
</style>
<script> $('.carousel').carousel({ interval: 2000 }) </script>
</head>
<body>
	<%@ include file="common/header.jspf"%>
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
				<img class="d-block w-100" src="https://images.pexels.com/photos/213399/pexels-photo-213399.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" alt="First slide">
				<div class="carousel-caption">
					<input type="button" class="btn btn-danger btn-lg" name="enter" value="입장하기">
				</div>
			</div>
			<div class="item">
				<img class="d-block w-100" src="https://images.pexels.com/photos/2355519/pexels-photo-2355519.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260" alt="Second slide">
				<div class="carousel-caption">
					<input type="button" class="btn btn-primary btn-lg" name="enter" value="입장하기">
				</div>
			</div>
			<div class="item">
				<img class="d-block w-100" src="https://images.pexels.com/photos/2544554/pexels-photo-2544554.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" alt="Third slide">
				<div class="carousel-caption">
					<input type="button" class="btn btn-warning btn-lg" name="enter" value="입장하기">
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
	<%@ include file="common/footer.jspf"%>
</body>
</html>

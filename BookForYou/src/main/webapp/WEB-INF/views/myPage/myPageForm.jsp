<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

body{
	font-family: 'Noto Serif KR', serif;
}


#wrapper .area {
	border: 2px solid #B0C4DE;
	border-radius: 10px;
	height: 300px;
}

#area-top-center {
	width:100%;
	margin-bottom: 25px;
	padding-top: 45px;
}


#area-bottom-left {
	padding-top: 50px;
	
}

#area-bottom-right {
	
}
#area-bottom-right img{
	height: 215px;
}

#area-top-center .top-contents{
	
}

</style>
<meta charset="UTF-8">
<title>BookForYou - 마이 페이지</title>
</head>
<body>

	<%@ include file="../common/header2.jspf"%>

	<!-- 마이페이지 모든 div를 묶는 전체 div wrapper -->
	<div id="wrapper" class="container">

		<!-- 마이페이지 상단 div -->
		<div id="area-top" class="row">
			<div id="area-top-center" class="area col-md-12" align="center">
				
				<div class="top-contents col-md-4">
					<div><span style="font-size: 15pt">회원님의 독서 등급</span></div>
					<img class="" src="<c:url value='/resources/img/grade_gold.png'/>">

				</div>
				
				
				<div class="top-contents col-md-8">

					<h1>반갑습니다.</h1>
					<h3>[usrName] 님 !</h3>

				</div>


			</div>
		</div>
		
		<!-- 마이페이지 하단 div -->
		<div id="area-bottom" class="row">
		
			<!-- 하단에서 좌측 -->
			<div id="area-bottom-left" class="area col-md-4" align="center">

				<h2> [usrName] 님의 취향은</h2>
				<h4>[문화]에 대해 </h4>
				<h4>폭넓은 지식을 소유한</h4> 
				<h4>[예술]인 이시군요. 아름답습니다.</h4>
				
				
				

			</div>
			<div class="col-md-1">
			
			</div>

			<!-- 하단에서 우측 -->
			<div id="area-bottom-right" class="area col-md-7" align="center">

				<h4>  이런 서적은 어떠세요 ?  </h4>
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
							<img src="http://image.aladin.co.kr/product/64/24/cover/8989313791_1.jpg" alt="...">
							<div class="carousel-caption">...</div>
						</div>
						
						<div class="item">
							<img src="http://image.aladin.co.kr/product/62/52/cover/8989002664_1.jpg" alt="...">
							<div class="carousel-caption">...</div>
						</div>
						
						<div class="item">
							<img src="http://image.aladin.co.kr/product/64/27/cover/8991432166_1.jpg" alt="...">
							<div class="carousel-caption">...</div>
						</div>
						
						<div class="item">
							<img src="http://image.aladin.co.kr/product/64/80/cover/8995760907_1.jpg" alt="...">
							<div class="carousel-caption">...</div>
						</div>
						
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>

			</div>
		</div>

	</div>


	<%@ include file="../common/footer.jspf"%>
</body>
</html>
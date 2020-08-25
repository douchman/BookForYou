<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
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

.top-contents .area-btn{
	margin-top: 40px;
}
</style>
<meta charset="UTF-8">
<title>BookForYou - 마이 페이지</title>
</head>
<body>

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
					<h3>${sessionLogin.usrnickname } 님 !</h3>

				<div class="area-btn">
					<a href="selfConfirm"><input type="button" class="btn btn-info" value="내 정보 수정하기"></a>
					<a href="#"><input onclick='location.href="${root}Library/bookRating"' type="button" class="btn btn-info" value="내 서재 이동"></a>
				</div>
				</div>


			</div>
		</div>
		
		<!-- 마이페이지 하단 div -->
		<div id="area-bottom" class="row">
		
			<!-- 하단에서 좌측 -->
			<div id="area-bottom-left" class="area col-md-4" align="center">

				<h2>${sessionLogin.usrnickname} 님은</h2>
				<h4>${sessionLogin.tendsResult}</h4>
				
				

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
				

						<c:forEach var="item" items="${bookLst}" begin="1" varStatus="idx">
							<c:choose>
								<c:when test="${idx.count eq '1'}">
									<div class="item active">
										<a href="${root}/detail?bookNo=${item.masterseq}"><img src="${item.imgurl}" alt="..."></a>
										<div class="carousel-caption">...</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="item">
										<img src="${item.imgurl}" alt="...">
										<div class="carousel-caption">...</div>
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>

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
</body>
</html>
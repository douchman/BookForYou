<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookForYou</title>
<style type="text/css">
h2 {
	padding-left: 5%;
}

div.col-sm-4 {
	width: 318px;
	height: 394px;
	text-align: center;
}

div.caption {
   white-space: nowrap;
   border: 0px solid #000000;
   overflow: hidden;
   text-overflow: ellipsis;
   font-size: 1rem;
   width: 280px;
}

img {
	width: 80%;
	height: 342px;
}

.row>div>.book:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jspf"%>
	<form id="detailFrm" action="detail" method="get">
		<input id="bookNo" type="hidden" name="bookNo" />
	</form>
	<div class="panel panel-default">
		<h2>
			<b>name과 비슷한 사람들이 좋아한 책</b>
		</h2>
	</div>
	<div style="margin: 10px;">

		<div class="row">
			<c:forEach var="item" items="${recommend}">
				<div class="col-sm-4 col-md-2">
					<div class="book">
						<input type="hidden" class="bookNo" value="${item.masterseq }"/>
						<img src="${item.imgurl }" alt="...">
						<div class="caption">
							<p style="font-size: medium;">${item.title }</p>
						</div>
						<div class="captionRating">
							<b style="font-size: small;">평점 5.0</b>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


	<div>
		<input type="button" onclick="location.href='dataSet'" value="데이터 출력">
		<input type="button" onclick="location.href='usrBasedResult'" value="사용자기반 결과 출력">
		<input type="button" onclick="location.href='Recommend'" value="사용자기반 추천">
		<input type="button" onclick="location.href='incrCount?author=1'" value="개인 사용자의 저자 평가 수 증가">
		<table class="table">
		<c:forEach var="item" items="${allUsrScoreList}">
			<tr>
				<td>${item }</td>
			</tr>
		</c:forEach>
		<c:forEach var="item" items="${similarityTable}">
			<tr>
				<c:forEach var="item1" items="${item}">
					<td>${item1 }</td>
				</c:forEach>
			</tr>
		</c:forEach>
		<c:forEach var="item" items="${usrBasedRecommendAll}">
			<tr>
				<td>${item }</td>
			</tr>
		</c:forEach>
		<c:if test="${incrCount ne 0 }">
			<tr>
				<td>${incrCount }</td>
			</tr>
		</c:if>
		</table>
		<c:forEach var="list" items="${usrBasedRecommend}" varStatus="status">
		<div class="panel panel-default">
			<h2>
				<b>${status.count }에게 추천</b>
			</h2>
		</div>
		<div style="margin: 10px;">

			<div class="row">
				<c:forEach var="item" items="${list}">
					<div class="col-sm-4 col-md-2">
						<div class="book">
							<input type="hidden" class="bookNo" value="${item.masterseq }"/>
							<img src="${item.imgurl }" alt="...">
							<div class="caption">
								<p style="font-size: medium;">${item.title }</p>
							</div>
							<div class="captionRating">
								<b style="font-size: small;">평점 5.0</b>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		</c:forEach>
	</div>


	<%@ include file="/WEB-INF/views/common/footer.jspf"%>
	<script type="text/javascript">
		$(function() {
			$('.book').click(function(event) {
				var bookNo = $(this).children('.bookNo').val();
				$('#bookNo').val(bookNo);
				document.getElementById("detailFrm").submit();
			})
			$('.panel').click(function(event) {
				var searchStr = '안녕, 나의 빨강머리 앤';
				$('#searchStr').val(searchStr);
				document.getElementById("searchFrm").submit();
			})
		})
	</script>
</body>
</html>
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

.col-sm-4 {
	text-align: center;
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
			<b>이런 책 좋아하지?</b>
		</h2>
	</div>
	<div style="margin: 10px;">

		<div class="row">
			<div class="col-sm-4 col-md-2">
				<div class="book">
					<input type="hidden" class="bookNo" value="5126591"/>
					<img src="http://image.yes24.com/goods/91070586/800x0" alt="...">
					<div class="caption">
						<p style="font-size: medium;">하루 한 번, 심리학 공부를 시작했다</p>
					</div>
					<div class="captionRating">
						<b style="font-size: small;">평점 5.0</b>
					</div>
				</div>
			</div>

			<div class="col-sm-4 col-md-2">
				<div class="book">
					<input type="hidden" class="bookNo" value="5126591"/>
					<img src="http://image.yes24.com/goods/91361295/800x0" alt="...">
					<div class="caption">
						<p style="font-size: medium;">바다에서 M</p>
					</div>
					<div class="captionRating">
						<b style="font-size: small;">평점 5.0</b>
					</div>
				</div>
			</div>
			<div class="col-sm-4 col-md-2">
				<div class="book">
					<input type="hidden" class="bookNo" value="5126591"/>
					<img src="http://image.yes24.com/goods/91070586/800x0" alt="...">
					<div class="caption">
						<p style="font-size: medium;">하루 한 번, 심리학 공부를 시작했다</p>
					</div>
					<div class="captionRating">
						<b style="font-size: small;">평점 5.0</b>
					</div>
				</div>
			</div>
			<div class="col-sm-4 col-md-2">
				<div class="book">
					<input type="hidden" class="bookNo" value="5126591"/>
					<img src="http://image.yes24.com/goods/91281294/800x0" alt="...">
					<div class="caption">
						<p style="font-size: medium;">안녕, 나의 빨강머리 앤</p>
					</div>
					<div class="captionRating">
						<b style="font-size: small;">평점 5.0</b>
					</div>
				</div>
			</div>
			<div class="col-sm-4 col-md-2">
				<div class="book">
					<input type="hidden" class="bookNo" value="5126591"/>
					<img src="http://image.yes24.com/goods/91361295/800x0" alt="...">
					<div class="caption">
						<p style="font-size: medium;">바다에서 M</p>
					</div>
					<div class="captionRating">
						<b style="font-size: small;">평점 5.0</b>
					</div>
				</div>
			</div>

			<div class="col-sm-4 col-md-2">
				<div class="book">
					<input type="hidden" class="bookNo" value="5126591"/>
					<img src="http://image.yes24.com/goods/91281294/800x0" alt="...">
					<div class="caption">
						<p style="font-size: medium;">안녕, 나의 빨강머리 앤</p>
					</div>
					<div class="captionRating">
						<b style="font-size: small;">평점 5.0</b>
					</div>
				</div>
			</div>

		</div>
	</div>


	<div>
		<input type="button" onclick="location.href='dataSet'" value="데이터 출력">
		<input type="button" onclick="location.href='usrBasedResult'" value="사용자기반 결과 출력">
		<input type="button" onclick="location.href='Recommend'" value="사용자기반 추천">
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
		<c:forEach var="item" items="${usrBasedRecommend}">
			<tr>
				<td>${item }</td>
			</tr>
		</c:forEach>
		</table>
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
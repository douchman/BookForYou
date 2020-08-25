<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<form id="detailFrm" action="detail" method="get">
		<input id="bookNo" type="hidden" name="bookNo" />
		<input id="bookAddcode" type="hidden" name="bookAddcode" />
	</form>
	<div class="panel panel-default">
		<h2>
			<b>${sessionLogin.usrnickname }님과 비슷한 사람들이 좋아한 책</b>
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
	
	<c:if test="${not empty recommendCodeList}">
		<div class="panel panel-default">
			<h2>
				<b>${sessionLogin.usrnickname }님이 좋아할 만한 책</b>
			</h2>
		</div>
		
		<div style="margin: 10px;">

			<div class="row">
				<c:forEach var="item" items="${recommendCodeList}">
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
	</c:if>


	<div>
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

	<script type="text/javascript">
		$(function() {
			$('.book').click(function(event) {
				var bookNo = $(this).children('.bookNo').val();
				$('#bookNo').val(bookNo);
				document.getElementById("detailFrm").submit();
			})
		})
	</script>
</body>
</html>
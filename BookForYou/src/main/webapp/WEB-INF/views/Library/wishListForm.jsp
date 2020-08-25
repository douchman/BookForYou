<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
div.col-sm-12 {
	width: 150px;
	height: 260px;
}

div.caption {
	white-space: nowrap;
	border: 0px solid #000000;
	overflow: hidden;
	text-overflow: ellipsis;
	font-size: 1rem;
	width: 120px;
	margin-top: 10px;
	margin-bottom: 10px;
}
</style>

<!-- 내가 평가한 책 -->
	<div class="panel panel-default">
		<div class="panel-body">
			<b>읽고 싶은 책</b>
		</div>
	</div>

	<div class="row">
	<c:forEach var="wish" items="${wishBookLst }">
		<div class="col-sm-12 col-md-1">
			<img src="${wish.imgurl }" alt="..."
				style="width: 130px; height: 200px;">
			<div class="caption">${wish.title }</div>
		</div>
	</c:forEach>
	</div>
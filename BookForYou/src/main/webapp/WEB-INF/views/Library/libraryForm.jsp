<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/" />

<script type="text/javascript">
</script>

<title>보관함</title>
<style>
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: wavy underline;}

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

.collectionPics {
	border: 2px solid #ADD8E6;
	float: left;
	width: 40%;
	height: 45%;
	border-radius: 3px;
}

.collection {
	cursor: pointer;
}

div.col-sm-12 {
	width: 150px;
	height: 260px;
}

div.row books {
	border: 0px solid #000000;
	overflow: scroll;
	background-color: blue;
	max-width: 1200px;
	max-height: 300px;
}
</style>
<form id='frm'>
	<input type="hidden" >
</form>
<body>
	<!-- 내가 평가한 책 -->
	<div class="panel panel-default">
		<div class="panel-body">
			<a href="${home }Library/bookRatingDetail" style="font-size: 1.5rem;">
			<b>내가 평가한 책</b></a>
		</div>
	</div>
	<div class="row books">
	<c:forEach var="rated" items="${ratingLst }" >
		<div class="col-sm-12 col-md-1">
			<img src="${rated.imgurl }" alt="..."
				style="width: 130px; height: 200px;">
			<div class="caption">${rated.title }</div>
			<div class="captionRating">
				<b style="font-size: 1rem;">평점 ${rated.rating }</b>
			</div>
		</div>
		</c:forEach>
	</div>
	<!-- 읽고 싶은 책-->
	<div class="panel panel-default">
		<div class="panel-body">
			<a href="${home }/Library/wishBook" style="font-size: 1.5rem;">
			<b>읽고 싶은 책</b></a>
		</div>
	</div>
	<!-- 컬렉션  -->
	<div class="panel panel-default">
		<div class="panel-body">
			<a href="${home }Library/collList" style="font-size: 1.5rem;">
			<b>내가 만든 컬렉션</b></a>
			<a href="${home }Library/collForm"style="float:right; font-size:1rem;">컬렉션 만들기</a>

		</div>
	</div>
</body>
<br>
<br>
<br>
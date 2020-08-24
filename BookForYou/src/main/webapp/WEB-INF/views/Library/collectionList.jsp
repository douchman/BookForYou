<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/" />
<style>
.collectionPics {
	border: 2px solid black;
	float: left;
	width: 40%;
	height: 45%;
	border-radius: 3px;
}
</style>
<!-- 컬렉션  -->
<div class="panel panel-default">
	<div class="panel-body">
		<b>내가 만든 컬렉션</b> <a href="${home }Library/collForm" class="collection"
			style="float: right; font-size: 1.2rem;"> 컬렉션 만들기</a>
	</div>
</div>

<div class="row">
	<c:forEach var="coll" items="${collectionLst }">
		<div class="col-sm-12 col-md-2" style="width: 300px; height: 360px;">
			<div class="collectionPics">
				<img
					src="https://www.solidbackgrounds.com/images/3600x3600/3600x3600-dark-green-solid-color-background.jpg"
					height="100%" width="100%">
			</div>
			<div class="collectionPics">
				<img src="https://images.fabric.com/images/605/605/0354269.jpg"
					height="100%" width="100%">
			</div>
			<div class="collectionPics">
				<img
					src="https://c889979.ssl.cf3.rackcdn.com/cgg/uploads/prod_img/2_8795_e.jpg?v=-62169984000"
					height="100%" width="100%">
			</div>
			<div class="collectionPics">
				<img
					src="https://images.saatchiart.com/saatchi/1035985/art/4214419/3284267-PYZUQTZU-7.jpg"
					height="100%" width="100%">
			</div>
			<div>
				<h5 style="float: left;">
					<b> <a href="${home }/Library/collView">${coll.colltitle }</a>
					</b>
				</h5>
			</div>
		</div>
	</c:forEach>
</div>
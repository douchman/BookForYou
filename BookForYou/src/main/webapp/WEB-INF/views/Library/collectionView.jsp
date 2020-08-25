<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
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

div.col-sm-12 {
	width: 150px;
	height: 270px;
}

div.row books {
	white-space: nowrap;
	border: 0px solid #000000;
	overflow: hidden;
	text-overflow: ellipsis;
	width: 600px;
	max-height: 260px;
}

div.panel {
	width: 600px;
	height: 330px;
}

</style>
<center>
<c:forEach var="c" items="${collectionList }" >
	<div class="panel panel-default">
		<div class="panel-heading" style="height: 40px">
			<b style="float: left;">#{c.colltitle }</b>
		</div>
		<div class="panel-body">
			<p style="float: left;">작성자: ${c.nickname }</p>
		</div>
		<div class="panel-body">
			<p style="float: left; text-align:left;" >
			${c.colldesc }
			</p>
		</div>
		<div class="panel-body" style="float: right;" >
			<span class="glyphicon glyphicon-thumbs-up"></span>
			<label>1</label>	
<!-- 		<input type=button style="width: 60px;" value='좋아요' /> 
			<input type=button style="width: 60px;" value='수정'/> 
			<input type=button style="width: 60px;" value='목록' /> -->
		</div>
	</div>
</c:forEach>
</center>
<center>
	<div class="row books" style="width: 600px">
		<div class="col-sm-6 col-md-3">
			<img src="http://image.yes24.com/goods/91070586/800x0" alt="..."
				style="width: 130px; height: 200px;">
			<div class="caption">하루 한 번, 심리학 공부를 시작했다</div>
			<div class="captionRating">
				<b style="font-size: 1rem;">평점 5.0</b>
			</div>
		</div>
	</div>
</center>
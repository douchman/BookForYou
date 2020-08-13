<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookForYou</title>
<style type="text/css">
h4 {
	padding-left: 5%;
}

div.col-sm-12 {
	width: 160px;
	height: 280px;
	margin-left: 12px;
	text-align: center;
}

.row>div>.book:hover{
	cursor: pointer;
}

div.row books {
   white-space: nowrap;
   border: 0px solid #000000;
   overflow: hidden;
   text-overflow: ellipsis;
   width: 1200px;
   max-height: 260px;
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
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jspf"%>
	<form id="detailFrm" action="detail" method="get">
		<input id="bookNo" type="hidden" name="bookNo" />
	</form>
	<div class="panel panel-default">
		<h4><b>${searchStr }</b></h4>
	</div>
	<div style="margin: 10px;">
		<article>
			<div class="row books">
				<c:set var="count" value="31"/>
				<c:forEach var="book" items="${searchBookLst }" varStatus="status" begin="0" end="30">
					<div class="col-sm-12 col-md-1">
						<div class="book">
							<input type="hidden" class="bookNo" value="${book.masterseq }"/>
							<img style="width: 130; height: 200px;" src="${book.imgurl }" alt="...">
							<div class="caption">
								<p style="font-size: medium;">${book.title }</p>
							</div>
							<div class="captionRating">
								<b style="font-size: small;">평점 5.0</b>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</article>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jspf"%>
<script type="text/javascript">
$(function() {
	//스크롤 바닥 감지
	window.onscroll = function(e) {
	    //추가되는 임시 콘텐츠
	    //window height + window scrollY 값이 document height보다 클 경우,
	    if((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
	    	//실행할 로직 (콘텐츠 추가)
	        var addContent = `<div class="row books">`;
	        	addContent += `<c:forEach var="book" items="${searchBookLst }" varStatus="status" begin="${count }" end="${count+29 }">`;
	        	addContent += `<div class="col-sm-12 col-md-1">`;
	        	addContent += `<div class="book">`;
	        	addContent += `<input type="hidden" class="bookNo" value="${book.masterseq }"/>`;
	        	addContent += `<img style="width: 130; height: 200px;" src="${book.imgurl }" alt="...">`;
	        	addContent += `<div class="caption">`;
	        	addContent += `<p style="font-size: medium;">${book.title }</p>`;
	        	addContent += `</div>`;
	        	addContent += `<div class="captionRating">`;
	        	addContent += `<b style="font-size: small;">평점 5.0</b>`;
	        	addContent += `</div>`;
	        	addContent += `</div>`;
	        	addContent += `</div>`;
	        	addContent += `</c:forEach>`;
	        	addContent += `</div>`;
	        	addContent += `<c:set var="count" value="${count+30 }"/>`;
	        //article에 추가되는 콘텐츠를 append
	        $('article').append(addContent);
	    }
	};
	
	$('.book').click(function(event) {
		var bookNo = $(this).children('.bookNo').val();
		$('#bookNo').val(bookNo);
		document.getElementById("detailFrm").submit();
	})
})
</script>
</body>
</html>
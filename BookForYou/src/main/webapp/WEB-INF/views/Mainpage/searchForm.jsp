<%@page import="com.proj.detailpage.bookSearchInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookForYou</title>
<style type="text/css">
h3 {
	padding-left: 5%;
}

div.col-sm-12 {
	width: 200px;
	height: 340px;
	margin-left: 12px;
	text-align: center;
}
img{
	width: 90%;
	height: 100%;
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
article{
	padding-left: 10%;
	padding-right: 10%;
}

#top {
	position: fixed;
	width: 60px;
	height: 60px;
	border-radius: 50%;
	left: 93%;
	top: 85%;
	text-align: center;
	background-color: rgba( 50, 205, 205, 1 );
	color: #fff;
	text-decoration: none;
}
.glyphicon{
	padding-top: 10%;
	font-size: 25px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jspf"%>
	<form id="detailFrm" action="detail" method="get">
		<input id="bookNo" type="hidden" name="bookNo" />
	</form>
	<div class="panel panel-default">
		<h3><b>'${searchStr }'으로 검색한 결과</b></h3>
	</div>
	<div style="margin: 10px;">
		<article>
		<c:choose>
			<c:when test="${searchCount eq 0 }">
				<h2>검색결과가 없습니다.</h2>
			</c:when>
			<c:otherwise>
				<div class="row books"></div>
			</c:otherwise>
		</c:choose>
		</article>
	</div>
	<a id="top" href="#"><span class="glyphicon glyphicon-menu-up" aria-hidden="true"></span><br/>TOP</a>
<script src='<c:url value="/webjars/jquery/3.5.1/dist/jquery.min.js" />'></script>
<script src='<c:url value="/webjars/bootstrap/3.3.5/js/bootstrap.min.js" />'></script>
<script type="text/javascript">
var page = 1;
$(function() {
	 getList(page);
     page++;
})

$(window).scroll(function(){   //스크롤이 최하단 으로 내려가면 리스트를 조회하고 page를 증가시킨다.
	if($(window).scrollTop() >= $(document).height() - $(window).height()){
		if(page != 1) getList(page);
		page++;   
	} 
});

function detail(bookNo){
	$('#bookNo').val(bookNo);
	document.getElementById("detailFrm").submit();
}

function getList(page){
    $.ajax({
        type : 'POST',  
        dataType : 'text', 
        data : {"page" : page, "searchStr" : '${searchStr}'},
        url : 'paging',
        success : function(data) {
        	$(".row").append(data);
       },error:function(e){
           if(e.status==300){
               alert("데이터를 가져오는데 실패하였습니다.");
           };
       }
    }); 
}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/" />
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
<!--
	function setParentTitle(imgurl, title) {
		opener.document.getElementById("title").value = title;
		window.close();
	}
	//-->

	function fchk() {
		var chk_obj = document.getElementsByName("chkBox");
		var chk_leng = chk_obj.length;
		var checked = 0;

		for (i = 0; i < chk_leng; i++) {
			if (chk_obj[i].checked == true) {

				checked += 1;
				alert(chk_obj[i].value);
			}

		}

		if (checked == 0) {
			alert("선택한 책이 없습니다.");
			return;
		} else {
			alert(checked + "개선택");
			return ;

		}

	}
</script>
<style type="text/css">
.list_over {
	overflow: auto;
	background-color: pink;
}

.list_out {
	background-color: #FFFFFF;
}
</style>
<meta charset="UTF-8">
<title>책 찾기</title>
</head>
<body>
	<form action="${home }Library/searchBookinfo" method="post">
		<h4>
			책 검색 <input type="text" name="title"
				style="width: 300px; height: 20px;" /> 
				<input type="submit" value="책 검색" />
		</h4>
	</form>
<form action="${home}/Library/collForm" onsubmit="fchk();" method="post">
	<input type="submit" value="컬렉션에 책 추가하기" />
	<table>
		<thead>
			<tr align="center">
				<th style="max-width: 40px; height: 15px;">선택</th>
				<th style="width: 50px; height: 15px;">사진</th>
				<th style="width: 200px; height: 15px;">제목</th>
				<th style="width: 120px; max-height: 15px;">작가</th>
				<th style="max-width: 100px; height: 15px;">출판사</th>
				<th style="width: 70px; height: 15px;">발행일자</th>
			</tr>
		</thead>
		<tr>
			<td style="width: 40px; height: 15px;"><hr /></td>
			<td style="width: 50px; height: 15px;"><hr /></td>
			<td style="width: 200px; height: 15px;"><hr /></td>
			<td style="width: 120px; height: 15px;"><hr /></td>
			<td style="width: 100px; height: 15px;"><hr /></td>
			<td style="width: 70px; height: 15px;"><hr /></td>
		</tr>
		<c:forEach var="book" items="${bookInfoLst}">
			<tr>
				<td style="width: 40px; height: 15px;"><input type="checkbox"
					name="chkBox" id="chkBox" value="${book.masterseq }" /></td>
				<td style="width: 50px; height: 50px;"><img style="width: 50px; height: 50px;" src="${book.imgurl }"/></td>
				<td style="width: 200px; height: 15px;">${book.title}</td>
				<td style="width: 120px; max-height: 15px; overflow: hidden; text-overflow: ellipsis;">${book.author}<hr /></td>
				<td style="width: 100px; height: 15px;">${book.publisher}</td>
				<td style="width: 70px; height: 15px;">${book.pubdate}</td>
			</tr>
		</c:forEach>
	</table>
</form>

	<%-- 
<c:set var="bookinfo" value="${book.title } ${book.author } ${book.publisher } ${book.pubdate }"/>
<c:set var="imgurl" value="${book.imgurl }"/>
<div onmouseover="this.className='list_over'"
onmouseout="this.className='list_out'"
onclick="setParentTitle'${imgurl}', '${bookinfo}');">
<b>제목: ${book.title }</b> 출판사: ${book.publisher } <br/>
작가: ${book.author } <br/>
<hr/>
</div> --%>



</body>
</html>
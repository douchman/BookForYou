<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>
<style>
.textBox {
	margin: auto;
	border: none;
	padding: 10px;
}

input.text {
	border: none;
	font-size: 2.3rem;
	width: 700px;
	height: 88px;
	color: black;
	border-style: double;
	
}

input.text:focus {
	outline: none;
}

input.search {
	border: none;
	font-size: 2rem;
	width: 500px;
	height: 70px;
	color: darkgray;
	border-style: double;
}

input.search:focus {
	outline: none;
}

input.searchBtn {
	width: 200px;
	height: 68px;
}

div.textArea textarea {
	width: 700px;
	height: 350px;
	border: none;
	font-size: 1.3rem;
	border-style: double;
	
}

div.textArea textarea:focus {
	outline: none;
}
.saveBtn{
	width: 700px;
	height: 35px;
}
.bookList{
	width: 700px;
	max-height: 500;
	overflow: auto;
	font-size: 1.3rem;
	border-style: double;
	text-align: left;
	margin: 20px;
}
.selectedBooks{
	width: 700px;
	text-align:left;
	border-style: double;
	font-size: 1.3rem;
	margin: 20px;
	
}
.list{
	font-size:1.0rem;
	margin:5px;
}
</style>
<center>
	<form action="${home }Library/insertProc" method="post">	
	<input type="hidden" name="nickname" value='cokezero'>
	<input type="submit" name="saveBtn" class="saveBtn" value="컬렉션 저장하기"> 
	<div class="textBox">
		<input class="text" type="text" name="colltitle" placeholder="컬렉션 제목을 입력하세요...">
	</div>
	<div class="selectedBooks">
		<table>
			<tr>
				<td><label>추가할 책 고유번호 입력</label></td>
			</tr>
			<tr>
				<td><input type="text" name="masterseqlst" placeholder="xxxxx, xxxxx, xxxxx"/></td>
			</tr>	
		</table>
	</div>
	<hr/>
	<div class="textArea">
		<textarea name="colldesc" placeholder="컬렉션 설명 추가하기 "></textarea>	
	</div>
	</form>
	
	<form action="${home }Library/searchBookinfo" method="post">
		<div class="textBox">
			<input class="search" type="text" name="title" placeholder="책 고유번호 검색"/>
			<input class="searchBtn" type="submit" value="검색"/>
		</div>
	</form>
	<hr/>
	
	<label>검색 결과</label>
	<div class="bookList">
		<table style="margin:auto;align:center; padding-top:10px">
		<thead>
			<tr style="padding-top:20px;">
				<th style="max-width: 50px; height: 15px; valign:middle; text-align:center;">선택</th>
				<th style="width: 80px; height: 15px; valign:middle; text-align:center;">사진</th>
				<th style="width: 200px; height: 15px; valign:middle; text-align:center;">제목</th>
				<th style="width: 130px; max-height: 15px; valign:middle; text-align:center; ">작가</th>
				<th style="max-width: 100px; height: 15px; valign:middle; text-align:center;">출판사</th>
				<th style="width: 80px; height: 15px; valign:middle; text-align:center;">고유번호</th>
			<!-- 	<th style="width: 80px; height: 15px; valign:middle; text-align:center;">
					<button>추가</button>
				</th> -->
			</tr>
		</thead>
		<tr>
			<td style="width: 40px; height: 5px;"><hr /></td>
			<td style="width: 70px; height: 5px;"><hr /></td>
			<td style="width: 200px; height: 5px;"><hr /></td>
			<td style="width: 120px; height: 5px;"><hr /></td>
			<td style="width: 100px; height: 5px;"><hr /></td>
			<td style="width: 70px; height: 5px;"><hr /></td>
		</tr>
		<c:forEach var="book" items="${bookInfoLst}">
			<tr>
				<td style="width: 40px; height: 15px;">
				<input type="checkbox"name="chkBox" id="chkBox" value="${book.masterseq }" />
				</td>
				<td style="width: 50px; height: 70px;"><img style="width: 50px; height: 70px;" src="${book.imgurl }"/></td>
				<td style="width: 200px; height: 15px;">${book.title}</td>
				<td style="width: 120px; max-height: 15px; overflow: hidden; text-overflow: ellipsis;">${book.author}</td>
				<td style="width: 100px; height: 15px;">${book.publisher}</td>
				<td style="width: 70px; height: 15px;">${book.masterseq}</td>
			</tr>
		</c:forEach>
	</table>
		</div>
		<input type="submit" value="선택한 책 추가하기"/>
	
</center>
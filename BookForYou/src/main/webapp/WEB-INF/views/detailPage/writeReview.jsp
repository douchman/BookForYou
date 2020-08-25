<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	*{margin:0; padding:0;}
	#okBtn, #cancelBtn{
		width: 100px;
		height: 30px;
	}
	form{
		margin-top: 5%;
	}
</style>

</head>
<body>
	<form action="${home }detail/write" id="writeFrm" method="post">
	<input type="hidden" name="masterseq" value="${param.masterSeq }">
	<input type="hidden" name="nickname" value="${param.nickName }">
		<div align="center" id=text>
			<textarea  style="width: 300px; height: 400px; resize: none;" name="review" placeholder="작품에 대한 생각을 말해주세요!"></textarea>
		</div>
		
		<div align="center">
			<input type="submit" value="등록" id='okBtn' onclick="close();" />
			<input type="button" value="취소" id='cancelBtn' onclick="window.close();"/>
		</div>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	#modifyBtn, #gobackBtn{
		width: 100px;
		height: 30px;
	}
</style>
</head>
<body>
	<form>
		<div align="center" id=text>
			<textarea  style="width: 800px; height: 300px; resize: none;" id="review">적었던 리뷰가 적혀있는 수정창</textarea>
		</div>
		<div align="center">
			<input type="button" value="수정" id=modifyBtn  />
			<input type="button" value="돌아가기" id=gobackBtn />
		</div>
	</form>
</body>
</html>
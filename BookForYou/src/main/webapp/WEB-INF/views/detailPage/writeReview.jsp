<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	#okBtn, #cancelBtn{
		width: 100px;
		height: 30px;
	}
</style>
</head>
<body>
	<form>
		<div align="center" id=text>
			<textarea  style="width: 800px; height: 300px; resize: none;" id="review" placeholder="작품에 대한 생각을 말해주세요!"></textarea>
		</div>
		<div align="center">
			<input type="button" value="등록" id=okBtn  />
			<input type="button" value="취소" id=cancelBtn />
		</div>
	</form>
</body>
</html>
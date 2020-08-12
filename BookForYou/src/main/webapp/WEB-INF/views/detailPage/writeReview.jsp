<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form>
		<div align="center" id=text>
			<textarea  style="width: 300px; height: 400px; resize: none;" id="review" placeholder="작품에 대한 생각을 말해주세요!"></textarea>
		</div>
		<div align="center">
			<input type="button" value="등록" id=okBtn  />
			<input type="button" value="취소" id=cancelBtn />
		</div>
	</form>
</body>
</html>
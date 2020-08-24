<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	font-family: 'Noto Serif KR', serif;
}
.area-space{
	height: 350px;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="area-space"></div>

	<div class="wrapper" class="container col-md-6 col-md-offset-3" align="center">
			<form action="chkPw" method="post">

			<div class="">
				<h4>본인 확인을 위한 비밀번호를 입력해주세요.</h4>
				<br>
			</div>
			<div class="row col-md-6 col-md-offset-3">
				<div class="form-group">
					<input id="pw" type="password" name="inputPw"
						class="form-control" placeholder="비밀번호"
						value="" style="width: 300px; font-size: 12pt;">
				</div>
				<span  style="color: red; font-size: 13pt;">${authMsg}</span>
				<div style="margin-top: 7px;">
					<input type="submit"
						class="btn btn-primary" value="확인">
						
				</div>
			</div>
		</form>
	</div>

	<div class="area-space"></div>
</body>
</html>
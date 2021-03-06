<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.area-btn {
	margin-right: 9px;
}
.area-space-150{
	height: 150px; 
	
}
</style>
<meta charset="UTF-8">
<title>BookForYou 회원 로그인</title>
</head>
<body>
	<input id="loginResult" type="hidden" value="${member.loginResult }">
	<div id="wrapper" class="container">

		<div class="area-logo row">
			<img class="col-md-3 col-md-offset-4"
				src="<c:url value='/resources/img/BFYlogo.png'/>">
		</div>

		<div class="col-md-5 col-md-offset-3">
			<form id="frm" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">아이디</label> <input type="text"
						class="form-control" id="usrid" name="usrid"
						value="${member.usrid}" placeholder="아이디를 입력하세요">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">비밀번호</label> <input
						type="password" class="form-control" id="pw" name="pw"
						placeholder="비밀번호">
				</div>
				<div style="margin-bottom: 15px;">
					<span style="color: red;" id="loginMsg"></span>
				</div>
				<div class="area-btngroup">
					<input class="area-btn col-md-2 btn btn-primary" id="btnLogin"
						type="button" value="로그인" onclick="loginProc();"> <input
						class="area-btn col-md-3 btn btn-primary" id="btnRegist"
						type="button" value="회원가입" onclick="location.href='${root}signup'"> <input
						class="area-btn col-md-3 btn btn-primary"
						onclick="location.href='findID'" type="button" value="ID 찾기">
					<input class="area-btn col-md-3 btn btn-primary"
						onclick="location.href='findPw'" type="button" value="PW 찾기">
				</div>
			</form>

		</div>
	</div>
	<div class="area-space-150"></div>
<script src='<c:url value="/resources/js/loginForm.js?ver=7" />'></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href='<c:url value="/webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>'>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR&display=swap" rel="stylesheet">

<style type="text/css">

body {
	font-family: 'Noto Serif KR', serif;
}
</style>

<meta charset="UTF-8">

<title>ID/PW 찾기 결과</title>
</head>


<body>

<!-- 
mode :1 -> 아이디 찾기 
mode :2 -> 패스워드 찾기
 -->
<c:choose>


<c:when test="${mode == '1'}">


<div align="center">
		<div class="area-logo">
			<a href="home"><img
				src="<c:url value='/resources/img/BFYlogo.png'/>"></a>
		</div>
		
		<h3>회원님의 아이디 입니다.</h3>
		<br>
		<h3 style="color: #1E90FF;"> ${usrid}</h3>

	</div>


</c:when>


<c:when test="${mode == '2' }">

PW 찾기는 현재 미구현 입니다.

</c:when>


</c:choose>


	


</body>

</html>
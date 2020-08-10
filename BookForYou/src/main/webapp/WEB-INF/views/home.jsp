<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<%@ include file="common/header.jspf" %>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="memberProc"> 임시 회원가입 페이지 이동</a>



<%@ include file="common/footer.jspf" %>
</body>
</html>

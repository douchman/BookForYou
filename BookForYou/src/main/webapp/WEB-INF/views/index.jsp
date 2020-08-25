<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/header2.jspf" %>
<!DOCTYPE html>

<c:set var="home" value="/"></c:set>

<html>
<head>
<meta charset="UTF-8">
<title>BookForYou</title>
</head>
<body>

<c:import url="${home}${formPath}"></c:import>


<%@ include file="common/footer.jspf" %>
</body>
</html>
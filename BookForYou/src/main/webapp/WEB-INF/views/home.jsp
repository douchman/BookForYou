<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


<%@ include file="common/footer.jspf" %>
</body>
</html>

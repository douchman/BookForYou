
<%@page import="Mail.AuthnumGenerator"%>
<%@page import="Mail.ParkMail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var ="mailAddress" value="${mailAddress}"/>
<c:set var ="authNum" value="${authNum}"/>


<%
	ParkMail parkmail = new ParkMail();
	AuthnumGenerator authNumGen = new AuthnumGenerator();
	
	String authNum = authNumGen.getAuthNum();
	// 메일 내용 작성하기
	
	String mailContents = "<div align='center'>"+
				"<p>안녕하세요.<br>"+
			 	"<p>당신에게 딱 맞는 책 < BookForYou > 입니다.<br>"+
				"<p>가입하신 ID :"+(String)pageContext.getAttribute("mailAddress") + "의 인증 메일 입니다.<br>"+
			 	"<p>하단의 링크를 클릭하시면 이메일 인증을 완료됩니다.<br>"+
				"<a href='http://localhost:8080/bookforyou/authDone?authNum="+
			 	(String)pageContext.getAttribute("authNum")+"'><I><U>이메일 인증</U></I></a>"+"</div>";
%>

<%
	
	parkmail.sendMail( (String)pageContext.getAttribute("mailAddress"),
			"< BookForYou > 계정을 활성화 해주세요.",
			mailContents);
	
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">


<style>

#wrapper .area-txt{


}


.area-txt .txt-title{
	
	color: #4682B4;
	
}	

.area-txt .txt-sub1 .sub1-usrid{

	color: #4682B4;
}

.area-txt .txt-sub2 .sub2-important{
	
	color: #DC143C;

}
</style>
<title>BookForYou - 회원가입 완료</title>
</head>
<body>

	<%@ include file="../common/header2.jspf"%>


	<div id="wrapper" class="container">

		<div class="area-logo row">
			<img class="col-md-3 col-md-offset-4" src="<c:url value='/resources/img/BFYlogo.png'/>">
		</div>
		
		
		<div align="center">
		
		
			<div class="area-txt col-md-7 col-md-offset-2">
			
			
				<h3 class="txt-title"> 회원가입을 진심으로 환영합니다. </h3>
				<br>
				<h4 class="txt-sub1"> 입력하신 <label class="sub1-usrid">${member.usrid }</label>  로  인증메일을 발송 하였습니다. </h4>
				<br>
				<h4 class="txt-sub2"> <label class="sub2-important">이메일 인증</label>이 완료되면 모든 서비스를 이용 하실 수 있습니다. </h4>
				
				
			</div>
		
		
		</div>
		
		
	</div>


	<%@ include file="../common/footer.jspf"%>

</body>
</html>
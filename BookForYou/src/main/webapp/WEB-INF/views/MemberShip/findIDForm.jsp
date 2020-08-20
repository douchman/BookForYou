<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

.hlightTxt{
	color: #1E90FF;

}

.area-divide-100{
	
	height: 100px;
}

.area-divide-50{
	
	height: 50px;
}

.form-group{

	text-align: left;
}
</style>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../common/header2.jspf"%>

	<div id="wrapper" class="container col-md-6 col-md-offset-3" align="center">

		<div class="area-logo">
			<img src="<c:url value='/resources/img/BFYlogo.png'/>">
		</div>

	
		<div class="area-headtxt" >
			<h2> 회원님의 정보를 찾아 드립니다.</h2>
			<br/>
			<br/>
			
			<h4> 가입하실때 입력한 <font class="hlightTxt">닉네임</font>이나  <font class="hlightTxt">이메일</font>을 입력해주세요 </h4>
		</div>
		
		<div class="area-divide-100"></div>
		
		<div class="area-input col-md-6 col-md-offset-3">
			<div class="">
				<form id="frm">
					<div class="form-group">
						<label for="exampleInputEmail1">이메일</label> <input type="text"
							class="form-control" id="usrid" name="usrid" value=""
							placeholder="아이디를 입력하세요">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">닉네임</label> <input
							type="text" class="form-control" id="usrnickname" name="usrnickname"
							placeholder="비밀번호" value="">
					</div>
					<div class="area-divide-50"></div>
					<div class="area-btn">
						<input type="button" onclick="getID();" class="btn btn-info" value="찾기">
					</div>
				</form>
		
			</div>

		</div>
		
	</div>

	<%@ include file="../common/footer.jspf"%>


<script type="text/javascript">

function getID(){
	var popupX = (window.screen.width / 2) - 400;
	var popupY= (window.screen.height / 2) - 400;
	
	var frm = document.getElementById('frm');
	
	var frmData = $('#frm').serialize();
	
	window.open('findID?'+frmData+"&mode=1","_Blank" , 'toolbar=no,menumar=no,width=400,height=400,left='+popupX+',top='+popupY).focus();
	
}

</script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
#wrapper .area {
	border: 2px solid #B0C4DE;
	border-radius: 10px;
	height: 350px;
}

#area-top-center {
	width:100%;
	margin-bottom: 25px;
}


#area-bottom-left {
	
	
}

#area-bottom-right {
	
}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="../common/header.jspf"%>

	<!-- 마이페이지 모든 div를 묶는 전체 div wrapper -->
	<div id="wrapper" class="container">

		<!-- 마이페이지 상단 div -->
		<div id="area-top" class="row">
			<div id="area-top-center" class="area col-md-12" align="center">
				<label> AREA TOP CENTER </label>

			</div>
		</div>
		
		<!-- 마이페이지 하단 div -->
		<div id="area-bottom" class="row">
		
			<!-- 하단에서 좌측 -->
			<div id="area-bottom-left" class="area col-md-4" align="center">

				<label> AREA BOTTOM LEFT</label>

			</div>
			<div class="col-md-1">
			
			</div>

			<!-- 하단에서 우측 -->
			<div id="area-bottom-right" class="area col-md-7" align="center">

				<label> AREA BOTTOM RIGHT </label>
				
			</div>
		</div>

	</div>


	<%@ include file="../common/footer.jspf"%>
</body>
</html>
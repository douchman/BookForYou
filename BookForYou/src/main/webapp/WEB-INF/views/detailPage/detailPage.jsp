<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<style type="text/css">
	*{margin:0; padding:0;}
	
	.startRadio {
	  display: inline-block;
	  overflow: hidden;
	  height: 40px;
	  margin-left: 30%;
	  margin-bottom: 2%;
	  margin-top: 5%;
	}
	.startRadio:after {
	  content: "";
	  display: block;
	  position: relative;
	  z-index: 10;
	  height: 40px;
	  background: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAYAAACOEfKtAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAACCBJREFUeNrsnHtwTFccx38pIpRQicooOjKkNBjrUX0ww0ijg4qpaCPTSjttPWYwU/X4o/XoH/7w7IMOQyg1SCco9d5EhTIebSSVoEQlxLQhoRIiJEF/33vOPrLdTe/u3pW7u/c3c/aeu3vuub/fZ3/nnN8999wb8piFDPFYnjIQGAANgAZAA6A+xXxZJD1LY70q9ohjg5kHRX5oZ6JGIYYHuiXrzxCduSHShjP69cAQPcaB92qIuq4k+uuO2G/fkqhgMlHzJoYHqpIlJ6zwzEjILz5heKAqKbkrvO9utbIbzwn6ZbQIFV4Y1cLwwHpl3hErvK2PP6MMTpnI4zv8ZjTheuRsKdG6320s7bniY22uKGMAdCGzfiaqfaRk17DnnbN8L/OrHz4WZQyATuRgEdHeS0r2CqcZTorMxG8ok1loAPxP0Dwj0xYCssdVOJaR332nkDwojjEAStmYR5R7XckeZ1DzXZXj375AGZT9Ps8AaA2aPz9s3V2n4pC1+JhzWBwb9AC/PEV0TTRYM3tY6v+V5zIAaMYxODaoAd6oJFp03MbSHe74wLHXK4MYIALjigdKdjt71n61x8my23Ds/CNBCvB8GVFqrtOgWa0ogw3qQF1BB3B23aA5393j5TFrUEdDBtcNAvAQh8q7CpTsNbD05uKFU/HuAlFnUAC0n2lGYMye9I+ndfGxtxF4I49AvCGC6ycOcBM3vOy/lewpBjDX2/pkHSdPl4i6Axrg/VoOmrPqBsQaiRKAo26c40mKzyZU0bn/cZMohz0D3oHLL6Tb95WfM9lzXtfUkAWUwZu41mFEvduJ1CeKyMSpWwRRYx+5iiZ35XBJlXdDgMq5LqDll7r0BkwbTPaBLahzJf9BcVk8oGTZDSphbGWPtgKmSYLt+aw291jc9sBbVQKSAkt61kX2tIfOa0GvlMPpNCdEfbmy4/ddk1pArXnTW6Y+nEycejiWw23SmAjhqQDbR8Jt00xDgFf5ejOXIWVbmmCJ+M6FnJSgcmTKZ1j39TBjwlDDJESTTAA7wFnZTuEMNUqA7Rsl8vhOFcAfLxAdKxaw4GXwNmdOaOdVOdKzLjKsh+RHwlAb8SZGeqrJzlvbOJaFV5pkvzqwI9HoF1wARHCbuI2o2obiqgSUbdcEr1IAC4PtZNcF9JVbfEehjHzrGKI3u9bThLecJXpvp7VPW8XAJlMQCwNdyZtJ6DM3JhCNi1XRB67mhjlpr7ghyzKaIe4MUniMjHZgWc6q4UQTTCoDaRRcNNS6u4MrGhyE8GDzDuTBwhm8eq9EZrzMkf1A2/U/V2gKIngYUA4pVzcDBQuP48BpZqLlvypZjMl9uTmfD3B43eWg2Wxaf6Kv4728FkYF7/dSsggxs/gEMQEMD7bhar0ZbP4qXoPJBHSgqSOJxnRTdvkCiPbxiaIDEB5s2gcbYStsVrOmU9UlNobwzaOJhgls0XJg6RhA8DrKASMaNsJWtStiVc9RIIjcnigicZaenNL5xO0CAB5sSIdNsA02wla14tYkD2Yvdr8jLrzltWSavHj3V3jQPQ22wCbY5u4MjduzZK2aEu0fR9Q9UtkdLCGG+SE86LwFNsAW2ATb3BWPphnbNicy8wmjhe8N4/SDHzogPO+Nzq2FLbDJE/F4nrZDONGBZKLnWiq7o/gfTfcj74OuCVi8bk4WtngqXk10d3mGx/0k67+XyIpt8gN40DEROu9PEjZ4I17fKcDUODpf2X8ks4LrdQwPuiVDV+gM3b0VTW61vNSeg6ix1hEshRVN1SE86JQCHaErdNakXi3vyu25RPTWVuuEbFO+bq7WCbxQ3jywxLIjumhXt6Y3+6CYKcq6q6fZG0UX6KYlPM0BQq6U27I6AnjFQTd9AqyqFU8aIcvNt0Qv9KQuVdCtqlbHAItsd3yLdDgIFznoqEOA5X4AsNzwQMMDDQ80PNDwQF0CLLT9u4U6BFjooKO+AFbWEJXeE1mOu0r1Rk/qVAkdK2t0CFDn/Z/P+kHN3hujdf8XskBZGWVZG3GUPShbI4Cx0DW2rd4AauSBDC6ON1M4JTh8jwVOK+Q7FAwPdAJuLG8+JHGPhZ5uQvSRnM9JzVH6LQBN4HIHeLuWQaZ7DLA8gAAykAm8SeI0BPuRzdn9+okUIdcrz+GGvOI3kcruKYCH8XFY/JPGIFcHBEB3QxgGgEe8RnAahP3nWxFNH8Au2Ft4n70A5LxBYpUU3tyx7KQyNQXgQ7ied3m7h0EubIhQRrMZ6chlRDfFmupINuamC2i4hQNww0msblAeP5j1CrtgLFETlTFBzSN2vbPieeF8W8CElwBgbctCPv8tF+eP4E0Z/pCy6ToCeKeaKHyxyLLy4U4Ux3oaPBg40fIdllHMZnAjuqpbxOM0toPrFTAxBnm0uM5PaNaLWJc/neiC5wxaVszkj1CdxIGuRmBWtp+8jQhDJgIUFmgfTSH6ZTzRSC/gKfWTqAN1HeM6R8VY60O/eonPvRk6+HIk1gagwwDCSr8uww4szUxG0xzPDTaPzfrpbaLXOmgfIb/Kde7kcTyffTyll7U7GAcdoAt08sVAokkT/pZHxykHRJYTHgKIt4QiH3Mo8smA+h9W8YUUV4jBZk1OnUs3vA3uAqep37CGU/vrBCCe/11i93o6hCJTZSji7qNTWgseFkL4s1yEQFbBiL80TidhjKU5IBT5VIYienlZIv7AuXYh0FIRAmkWymjigR/sEu85TXrRd4+VaiV4DDftHFHGZaINo3QUBwarGO+RNgAaAA2AwSz/CjAAQpkGTQKEVKkAAAAASUVORK5CYII=") repeat 0 0;
	  background-size: contain;
	  pointer-events: none;
	}
	.startRadio__box {
	  position: relative;
	  z-index: 1;
	  float: left;
	  width: 20px;
	  height: 40px;
	  cursor: pointer;
	}
	.startRadio__box input {
	  opacity: 0 !important;
	  height: 0 !important;
	  width: 0 !important;
	  position: absolute !important;
	}
	.startRadio__box input:checked + .startRadio__img {
	  background-color: #0084ff;
	}
	.startRadio__img {
	  display: block;
	  position: absolute;
	  right: 0;
	  width: 500px;
	  height: 40px;
	  pointer-events: none;
	}
	table{
   		margin-top: 10%;
   		padding-left: 5%;
   		padding-right: 5%;
   		width: 1000px;
   		table-layout: fixed;
   		word-break: break-all;
   		margin: auto;
	}
	.wishBookList{
		width: 200px;
		height: 30px;
	}
	.modifyBtn, .deleteBtn, .likeReiew{
		border: none;
		background-color: white;
		width: 50px;
		vertical-align: bottom;
		display: inline-block;
		cursor: pointer;
		outline: 0;
	} 
	a{
		cursor: pointer;
	}
	li{
	  list-style:none;
	}
</style>

</head>
<body>
	<%@ include file="../common/header.jspf"%>
	<c:url var="home" value="/"/>
	<%String num = "0"; %>
	
	<form action="${home }detail/indivRating" id="detFrm" method="post">
		<input type="hidden" name="nickName" id="nickName" value="name">
		<input type="hidden" name="masterSeq" id="masterSeq" value="${bookInfo.masterseq }">
		<input type="hidden" name="rating" id="rating" />
	
	</form>
	<form action="${home }detail/wish" id="detFrm2" method="post">
		<input type="hidden" name="nickName" value="name">
		<input type="hidden" name="masterSeq" value="${bookInfo.masterseq }">
		<input type="hidden" name="wish" id="wish" value="1" />
	</form>
	
	<table>
		<tr>
			<th rowspan="3"><img src="${bookInfo.imgurl }" height="220px" width="180px" style="padding: 10px; "></th>
			<td colspan="2"><h2>${bookInfo.title }</h2></td>
		</tr>
		<tr><td><h4>${bookInfo.addcode }</h4></td></tr>
		<tr>
			<td> ${bookInfo.author }</td>
			<td>별점</td>
		</tr>
		
		<tr>
			<td colspan="2" >
			<div class="startRadio">
				<label class="startRadio__box">
					<input type="radio" name="star" value="0.5" id="0.5"  onclick=" value_check();"  <% if("0.5".equals(num)){%>checked<%}%> onchange="review();">
					<span class="startRadio__img"><span class="blind">별 0.5개</span></span>
				</label>
				<label class="startRadio__box">
					<input type="radio" name="star" value="1" id="1"  onclick=" value_check();" <% if("1".equals(num)){%>checked<%}%>  onchange="review();">
					<span class="startRadio__img"><span class="blind">별 1개</span></span>
				</label>
				<label class="startRadio__box">
					<input type="radio" name="star" value="1.5" id="1.5"  onclick=" value_check();" <% if("1.5".equals(num)){%>checked<%}%>  onchange="review();">
					<span class="startRadio__img"><span class="blind">별 1.5개</span></span>
				</label>
				<label class="startRadio__box">
					<input type="radio" name="star" value="2" id="2"  onclick=" value_check();" <% if("2".equals(num)){%>checked<%}%>  onchange="review();">
					<span class="startRadio__img"><span class="blind">별 2개</span></span>
				</label>
				<label class="startRadio__box">
					<input type="radio" name="star" value="2.5" id="2.5"  onclick=" value_check();" <% if("2.5".equals(num)){%>checked<%}%>  onchange="review();">
					<span class="startRadio__img"><span class="blind">별 2.5개</span></span>
				</label>
				<label class="startRadio__box">
					<input type="radio" name="star" value="3" id="3"  onclick=" value_check();" <% if("3".equals(num)){%>checked<%}%>  onchange="review();"> 
					<span class="startRadio__img"><span class="blind">별 3개</span></span>
				</label>
				<label class="startRadio__box">
					<input type="radio" name="star" value="3.5" id="3.5"  onclick=" value_check();" <% if("3.5".equals(num)){%>checked<%}%>  onchange="review();">
					<span class="startRadio__img"><span class="blind">별 3.5개</span></span>
				</label>
				<label class="startRadio__box">
					<input type="radio" name="star" value="4" id="4"  onclick=" value_check();" <% if("4".equals(num)){%>checked<%}%>  onchange="review();">
					<span class="startRadio__img"><span class="blind">별 4개</span></span>
				</label>
				<label class="startRadio__box">
					<input type="radio" name="star" value="4.5" id="4.5"  onclick=" value_check();"  <% if("4.5".equals(num)){%>checked<%}%> onchange="review();">
					<span class="startRadio__img"><span class="blind">별 4.5개</span></span>
				</label>
				<label class="startRadio__box">
					<input type="radio" name="star" value="5" id="5"  onclick=" value_check();" <% if("5".equals(num)){%>checked<%}%> onchange="review();">
					<span class="startRadio__img"><span class="blind">별 5개</span></span>
				</label>
			</div>
			<div id="review" style="margin-left: 30%; margin-bottom: 2%; /* display: none; */">
				<a onclick="writeReview('${home }detail/writeReview', ${bookInfo.masterseq });" id="writeReview" >리뷰를 작성해주세요!</a>
			</div>
			</td>
			<td>
				<button class="wishBookList" name="wishBookList" id="wishBookList" onclick="wish();" value="0">읽고 싶어요!</button>
			</td>
		</tr>
		<tr>
			<td><h3>작가</h3></td>
			<td> ${bookInfo.author }</td>
		</tr>
		<tr> 
			<td><h3>카테고리</h3></td>
			<td>${bookInfo.addcode }</td>
		</tr>
		<tr>
			<td><h3>출판연도</h3></td>
			<td>${bookInfo.pubdate }</td>
		</tr>
		<tr>
			<td><h3>출판사</h3></td>
			<td>${bookInfo.publisher }</td>
		</tr>
		<tr>
			<td><h3>정보</h3></td>
			<td colspan="2" style="width: 200px;">${bookInfo.description }</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><h2>별점 그래프</h2></td>
		</tr>
		<tr align="center">
			<td><div id="columnchart_material"
					style="width: 700px; height: 500px; border: 1px solid"></div></td>
		</tr>

		<tr>
			<td><h2>리뷰</h2></td>
		</tr>
		<tr>
			<td>
				<div style="overflow: auto; height: 600px;">

					<div style="border: 1px solid; width: 600px; margin: auto;"
						align="center">
						<h4 align="left">닉네임 님 4.5</h4>
						리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용
						리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용
						리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용
						리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용 <br />

						<div align="left" class="reviewBtn">
							<img src="https://image.flaticon.com/icons/svg/2558/2558422.svg" width="25px" height="25px" style="vertical-align: bottom;"> 5
							<input type="button" value="좋아요" class="likeReiew" style="margin-left: 83%;">
						</div>
					</div>
					<div style="border: 1px solid; width: 600px; margin: auto;"
						align="center">
						<h4 align="left">닉네임 님 4.5</h4>
						리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용
						리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용
						리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용
						리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용리뷰내용 <br />

						<div align="left" class="reviewBtn">
							<img src="https://image.flaticon.com/icons/svg/2558/2558422.svg"
								width="25px" height="25px" style="vertical-align: bottom;"> 5 
								<input type="button" value="수정" class="modifyBtn" onclick="popUp('${home }detailPage/modifyReview.jsp')" style="margin-left: 65%;"> 
								<input type="button" value="삭제" class="deleteBtn"> 
								<input type="button" value="좋아요" class="likeReiew">
						</div>
					</div>

				</div>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<td><h2>작가의 다른 작품</h2></td>
		</tr>

	</table>
	<div>
		<ul>
			<li>
			<table>
				<tr>
					<th rowspan="3">
						<img src="https://image.aladin.co.kr/product/681/74/cover/8987799379_1.jpg" height="200px" width="150px">
					</th>
					<td colspan="2"><h3>희망을 주는 수학 수업</h3></td>
				</tr>

				<tr>
					<td>교육</td>
				</tr>
				<tr>
					<td>김종남, 김리라</td>
					<td>별점</td>
				</tr>
			</table>
			</li>
			<li>
				<table>
				<tr>
					<th rowspan="3">
						<img src="https://image.aladin.co.kr/product/681/74/cover/8987799379_1.jpg" height="200px" width="150px">
					</th>
					<td colspan="2"><h3>희망을 주는 수학 수업</h3></td>
				</tr>

				<tr>
					<td>교육</td>
				</tr>
				<tr>
					<td>김종남, 김리라</td>
					<td>별점</td>
				</tr>
			</table>
			</li>
			
			<li class="last_li">
			<table>
				<tr><td><input type="button" value="더보기" id="seeMoreBook" class="more" style="width: 800px; height: 50px"></td></tr>
			</table>
			</li>
		</ul>
	</div>

	<table>
		<tr>
			<td><h2>이 책이 포함된 컬렉션</h2></td>
		</tr>
	</table>


		<div>
			<ul>
			<li>
				<table>
					<tr>
						<th rowspan="3">
							<div style="width: 300px; height: 360px; margin-left: 15px; float: right;">
								<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">
									<img src="https://image.aladin.co.kr/product/681/74/cover/8987799379_1.jpg" height="100%" width="100%">
								</div>
								<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">
									두번째 영역
								</div>
								<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">
									세번째 영역
								</div>
								<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">
									네번째 영역
								</div>
							</div>
						</th>
					</tr>
					<tr>
						<td>
							<h3>컬렉션 이름</h3>
						</td>
					</tr>
					
					<tr>
						<td>
							<h4>만든사람 닉네임</h4>
						</td>
					</tr>
				</table>
			</li>
			
			<li>
				<table>
					<tr>
						<th rowspan="3">
							<div style="width: 300px; height: 360px; margin-left: 15px; float: right;">
								<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">
									<img src="https://image.aladin.co.kr/product/681/74/cover/8987799379_1.jpg" height="100%" width="100%">
								</div>
								<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">
									두번째 영역
								</div>
								<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">
									세번째 영역
								</div>
								<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">
									네번째 영역
								</div>
							</div>
						</th>
					</tr>
					<tr>
						<td>
							<h3>컬렉션 이름</h3>
						</td>
					</tr>
					
					<tr>
						<td>
							<h4>만든사람 닉네임</h4>
						</td>
					</tr>
				</table>
			</li>

			<li class="last">
			<table>
				<tr><td><input type="button" value="더보기" id="seeMoreBook" class="moreColl" style="width: 800px; height: 50px"></td></tr>
			</table>
			</li>
		</ul>
	</div>
	<br/><br/>
<%@ include file="../common/footer.jspf"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

	google.charts.load('current', {
		'packages' : [ 'bar' ]
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {
		var data = google.visualization.arrayToDataTable([
				[ '별점', '인원' ], [ '0.5 ~ 1', 10 ], [ '1.5 ~ 2', 70 ],
				[ '2.5 ~ 3', 1], [ '3.5 ~ 4', 100 ], [ '4.5 ~ 5', 90 ] ]);

		var options = {
			chart : {
				subtitle : '책 제목'
			}
		};

	var chart = new google.charts.Bar(document
				.getElementById('columnchart_material'));

		chart.draw(data, google.charts.Bar.convertOptions(options));
	}

	function value_check() {
		var check_count = document.getElementsByName("star").length;

		for (var i = 0; i < check_count; i++) {
			if (document.getElementsByName("star")[i].checked == true) {
				var star = "";
				console.log(star);
				star = document.getElementsByName("star")[i].value;
				console.log(star);
			}
			console.log(star);
		}
		console.log(star);
		document.getElementById("rating").value = star;
		$("#detFrm").submit();
	} 
	

	/* function review() {
		if ($('input:radio[name="star"]').is(':checked'))
			$('#review').show();
	} */
	
	function wish(){
		if(document.getElementById("wishBookList").clicked){
			$('#review').hide();
			  for(var i=0;star.length;i++){
		             if(star[i].checked){
		            	 star[i].checked = false;
		             }
		        }
			  	var wishbook = document.getElementById("wishBookList").value;
			  	wishbook = "1";
			    console.log(wishbook);
			  	document.getElementById("wish").value = wishbook;
			}	
		console.log(wishbook);
		$("#detFrm2").submit();
	} 
	
	function writeReview(url, masterSeq) {
		window.name = "리뷰";
		var nickName = 'qwe';
		
		var urllink = url+"?masterSeq="+ masterSeq +"&nickName="+ nickName;
		var myWindow = window
				.open(urllink, "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=400, lwfr=600, widtn=200px, height=400px");
		//url, title, size
	}
	
	$('.more').on('click', function(){
		$('<li><table><tr><th rowspan="3">' +
	  		'<img src="https://image.aladin.co.kr/product/681/74/cover/8987799379_1.jpg" height="200px" width="150px"> '+        
	      	'</th><td colspan="2"><h3>희망을 주는 수학 수업</h3></td></tr>' +
			'<tr><td>교육</td></tr>	<tr><td>김종남, 김리라</td>	<td>별점</td>	</tr></table></li>')
		.prependTo('.last_li');	//여기다 데이터를 저장해서 불러오기(json)
	});
	
	$('.moreColl').on('click', function(){
		$('<li><table><tr><th rowspan="3">' +						
			'<div style="width: 300px; height: 360px; margin-left: 15px; float: right;">' +
			'<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">'+
			'<img src="https://image.aladin.co.kr/product/681/74/cover/8987799379_1.jpg" height="100%" width="100%"></div>' +
			'<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">	두번째 영역</div>'+
			'<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">세번째 영역</div>'+
			'<div style="border: 3px solid #E8FFFF; float: left; width: 38%; height: 45%;">네번째 영역</div></th></tr>' +
			'<tr><td><h3>컬렉션 이름</h3></td></tr><tr><td><h4>만든사람 닉네임</h4></td></tr></table></li>')
		.prependTo('.last');	
	});
</script>
</body>
</html>
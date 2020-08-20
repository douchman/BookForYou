$(document).ready(function(){
	var pwChk = $('#pwChkMsg');

	/*  아이디 유효검사  : 이메일 검사라서 중복 진행 후에 메일 발송으로 넘어 갈 것.  */

	/*  닉네임 유효검사   */
	
	/*  성별 동작  */
	

	
	var pwChk = $('#pwChkMsg');
	
	/*  form 내에서 enter 키 입력시 강제로 submit 되는 것 막기*/
	$(document).on("keydown",'input[type="text"]',function(event) {
	  	if (event.keyCode === 13) {
		  event.preventDefault();
	  		};
		});
	
	
	
	/*  아이디 유효검사  : 이메일 검사라서 중복 진행 후에 메일 발송으로 넘어 갈 것.  */
	
	$('#chkId').on('click',function(){
		
		$.ajax({
		
			type	:	"GET",
			url		:	"isExistId",
			data	:	$('#frm1').serialize(),
			success	:	function(response){
				response = response.trim();
					
		
				if(response == "0"){
					alert('가입 가능한 아이디 입니다!');
					$('#idPass').val('1');
					}
				else{
					alert('이미 존재하는 ID 입니다!');
					$('#idPass').val('0');
					}
			}
				
		})
	
	})
	
	
	/*  닉네임 유효검사   */
	
	$('#chkNickname').on('click',function(){

		$.ajax({
		
			type	:	"GET",
			url		:	"isExistNickName",
			data	:	$('#frm1').serialize(),
			success	:	function(response){
				response = response.trim();
						
				if(response == "0"){
					alert('사용 가능한 닉네임 입니다.');
					$('#nickPass').val('1');
					
				}
					
				else{
					alert('이미 존재하는 닉네임 입니다!');
					$('#nickPass').val('0');
				}
			}
				
		})
		
		
		
	})
	
	
	/*  성별 동작  */
	
	
	/* 회원가입 버튼 */

	
	
	/* 패스워드 유효 검사  */
	$('#pw').keyup(function(){
		//alert(pw +'and' + pwOk);
		// 패스워드 , 패스워드 확인 입력 필드가 모두 비어있지 않을때
		if($('#pw').val() != null && $('#pw').val() != '' && $('#pwOk').val() != null && $('#pwOk').val() != ''){
			// 그 값들이 일치하는지 확인한다.
			//일치 하지 않을 경우
			if($('#pw').val() != $('#pwOk').val()){
				pwChk.css("color","red");
				pwChk.html('패스워드 미 일치!');
				$('#pwPass').val('0');
			}
			// 일치 할 경우
			else{
				pwChk.css("color","blue");
				pwChk.html('패스워드 일치');	
				$('#pwPass').val('1');
			}
		}
		// 두 입력 필드가 비어있을경우에는 메시지를 없애기
		else if($('#pw').val() == null || $('#pw').val() == '' || $('#pwOk').val() == null || $('#pwOk').val() == ''){
			pwChk.html('');
			$('#pwPass').val('0');
		}
	})
	
	$('#pwOk').keyup(function(){
		//alert(pw +'and' + pwOk);
		// 패스워드 , 패스워드 확인 입력 필드가 모두 비어있지 않을때
		if($('#pw').val() != null && $('#pw').val() != '' && $('#pwOk').val() != null && $('#pwOk').val() != ''){
			// 그 값들이 일치하는지 확인한다.
			//일치 하지 않을 경우
			if($('#pw').val() != $('#pwOk').val()){
				pwChk.css("color","red");
				pwChk.html('패스워드 미 일치!');
				$('#pwPass').val('0');
			}
			// 일치 할 경우
			else{
				pwChk.css("color","blue");
				pwChk.html('패스워드 일치');
				$('#pwPass').val('1');
			}
		}
		// 두 입력 필드가 비어있을경우에는 메시지를 없애기
		else if($('#pw').val() == null || $('#pw').val() == '' || $('#pwOk').val() == null || $('#pwOk').val() == ''){
			pwChk.html('');
			$('#pwPass').val('0');
		}
		
	})	



})

// 다음으로 넘어가기를 위한 유효성 검사
function nextPage(){
	var frm = document.getElementById('frm1');
	var idPass = $('#idPass').val();
	var pwPass = $('#pwPass').val();
	var nickNamePass = $('#nickPass').val();
	var agePass = $('#agePass').val();
	var genderPass = $('#genderPass').val();

	// 모든 입력값이 올바르게 입력이 되었다면
	if( idPass == 1 && 
		pwPass == 1 &&
		nickNamePass == 1 && 
		agePass == 1 ){
		
		frm1.action = 'nextMemberShipPage';
		frm1.submit();
		
	}
	
	else
		alert('필수입력 사항을 모두 입력 해주십시오.')

}


function setAge(age, tag){
	
	//console.log(age, tag.innerHTML);
	
	$('#btnAge').html(tag.innerHTML);
	$('#ageValue').val(age);
	$('#agePass').val('1');
}
	
function setFav(category, no ,tag){
	$('#fav'+no).html(tag.innerHTML);
	$('#favorite'+no).val(tag.innerHTML);
	
}



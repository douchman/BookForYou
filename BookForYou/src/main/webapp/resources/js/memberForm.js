$(document).ready(function(){
	var pwChk = $('#pwChkMsg');

	/*  아이디 유효검사  : 이메일 검사라서 중복 진행 후에 메일 발송으로 넘어 갈 것.  */

	/*  닉네임 유효검사   */
	
	/*  성별 동작  */
	
	
	
	
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
			}
			// 일치 할 경우
			else{
				pwChk.css("color","blue");
				pwChk.html('패스워드 일치');		
			}
		}
		// 두 입력 필드가 비어있을경우에는 메시지를 없애기
		else if($('#pw').val() == null || $('#pw').val() == '' || $('#pwOk').val() == null || $('#pwOk').val() == ''){
			pwChk.html('');
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
			}
			// 일치 할 경우
			else{
				pwChk.css("color","blue");
				pwChk.html('패스워드 일치');
			}
		}
		// 두 입력 필드가 비어있을경우에는 메시지를 없애기
		else if($('#pw').val() == null || $('#pw').val() == '' || $('#pwOk').val() == null || $('#pwOk').val() == ''){
			pwChk.html('');
		}
		
	})	



})
	

	


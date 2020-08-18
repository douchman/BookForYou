$(document).ready(function() {

	var loginResult = $('#loginResult').val();
	var loginMsg = $('#loginMsg');
	/* form 내에서 enter 키 입력시 강제로 submit 되는 것 막기 */
	$(document).on("keydown", 'input[type="text"]', function(event) {
		if (event.keyCode === 13) {
			event.preventDefault();
		}
		;
	});

	switch(loginResult){
	// 0: 아이디없음  1: 패스워드 미일치 2: 서비스불가상태
	case '0':
		loginMsg.html('ID가 존재하지 않습니다.');
		break;
	case '1':
		loginMsg.html('PW가 다릅니다.');
		break;
	case '2':
		loginMsg.html('이메일인증이 되지 않은 ID입니다.');
		break;
	default:
		loginMsg.html('');
	}
	
	

	
	$('#btnRegist').on('click', function() {
		location.href='memberProc';
	})
})


function loginProc() {
	var frm = document.getElementById('frm');
	var usrid = $('#usrid').val();
	var pw = $('#pw').val();

	if (pw == "" || pw == null || usrid == "" || usrid == null) {
		alert('아이디 또는 비밀번호를 입력해주십시오.')

	} else {
		frm.action = 'loginProc';
		frm.submit();
	}

}
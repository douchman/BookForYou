$(document).ready(function(){
	
	/*  form 내에서 enter 키 입력시 강제로 submit 되는 것 막기*/
	$(document).on("keydown",'input[type="text"]',function(event) {
	  	if (event.keyCode === 13) {
		  event.preventDefault();
	  		};
		});
	
	// 수정 페이지 진입시 기존 입력되었던 연령대 설정 부분
	initAgeTxt();
	
	
	// 페이지 초기 진입시 관심 설정 부분
	initFav();
	
	// 닉네임 검사
	$('#chkNickname').on('click',function(){
		var nickname = $('#usrnickname').val();

		if(nickname){}
		else{}
		$.ajax({
		
			type	:	"POST",
			url		:	"isExistNickName",
			data	:	$('#frm1').serialize(),
			success	:	function(response){
				response = response.trim();
						
				if(response == "0"){
					alert('사용 가능한 닉네임 입니다.');					
				}
					
				else{
					alert('이미 존재하는 닉네임 입니다!');
				}
			}
				
		})
		
		
		
	})
})

function initAgeTxt(){
	var btnHtml = "";
	var age = $('#ageValue').val();
	if(age == 10)
		btnHtml += age +'대 미만'
	else if(age == 50)
		btnHtml += age +'대 이상'
	else
		btnHtml += age +'대'	
	$('#btnAge').html(btnHtml);

}

function initFav(){
	
	for(i=1; i<=3; i++){
		var fav = $('#favorite'+i).val();
		var favTxt = "";
		switch (fav) {
		case '0':
			favTxt = '총류/사전'
			break;
		case '1':
			favTxt = '철학/심리학/윤리'
			break;
		case '2':
			favTxt = '종교'
			break;
		case '3':
			favTxt = '사회과학'
			break;
		case '4':
			favTxt = '자연과학'
			break;
		case '5':
			favTxt = '기술과학'
			break;
		case '6':
			favTxt = '예술'
			break;
		case '7':
			favTxt = '언어'
			break;
		case '8':
			favTxt = '문학'
			break;
		case '9':
			favTxt = '역사/지리/관광'
			break;
		default :
			favTxt = "분류"
			break;
		}
		$('#fav'+i).html(favTxt);
	}
}

function setAge(age, tag){
	
	//console.log(age, tag.innerHTML);
	
	$('#btnAge').html(tag.innerHTML);
	$('#ageValue').val(age);

}

function setFav(category, no ,tag, value){
	$('#fav'+no).html(tag.innerHTML);
	$('#favorite'+no).val(value);
	
}
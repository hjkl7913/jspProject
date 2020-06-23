var isCheckedEmail = false;

function validate(){
	if(!isCheckedEmail){
		alert('email 중복체크를 해주세요');
	}
	return isCheckedEmail;
}

function EmailCheck() {
	var tfEmail = $('#email').val();
	
	console.log("tfEmail : "+tfEmail);
	
	$.ajax({
		type: 'get',
		url: '/project/user?cmd=userEmailCheck&Email='+tfEmail
	}).done(function(result){
		console.log("result : "+result);
		if(result == 1) {
			alert('이메일이 중복되었습니다.');
		}else if (result == 0){
			alert('사용 할 수 있는 이메일 입니다.');
			isCheckedEmail = true;
		}else{
			console.log('develop : 서버 오류');
		}
	}).fail(function(error){
		console.log(error);
	});
	
	isCheckedEmail = true;
}
function UserPasswordFind() {
	var email = $(".form-control").val();
	if (email === null || email === "") {
		alert("이메일을 입력하세요.");
		return;
	}
	
	$.ajax({
		type: "get",
		url : "/project/user?cmd=userEmailCheck&Email="+email,
		dataType: "text"
		
	}).done(function(result) {
		if(result == 1){

			$("#find__email").empty();
			renderFindEmail();
		} else {

			$("#find__email").empty();
			renderFindEmailFail();
		}
	}).fail(function(error) {
		alert("서버오류");
	})
}

function renderFindEmail() {
	var sendEmail = $(".form-control").val();
	console.log("sendEmail : "+sendEmail);
	
	var searchItem = `<h5>임시 비밀번호가 전송 되었습니다.</h5>`;
	$("#find__email").append(searchItem);
	
	passwordEmailSend(sendEmail);
		
}

function passwordEmailSend(sendEmail) {
	
	$.ajax({
		type: "get",
		url : "/project/user?cmd=sendEmailFindPassword&Email="+sendEmail,
		dataType: "text"
			
	}).done(function(result){
		if(result == 1){
		console.log("이메일전송 완료!");
		} else {
			console.log("이메일전송 실패");
		}
	}).fail(function(error){
		alert("서버오류2");
	})
}


function renderFindEmailFail() {

	var searchItem2 = `<h5>죄송합니다, 계정을 발견하지 못했습니다.</h5>`;
	$("#find__email").append(searchItem2);
}


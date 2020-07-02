function back() {
	history.back();
}


function questionSubmit() {
	var userId = $("#userId").val()
	var displayName = $("#displayName").val()
	var email = $("#email").val()
	var platform = $(".select-op1").val()
	var language = $(".select-op2").val()
	var question = $("#question").val()
	
	if(question == "" || question == null){
		alert("내용을 입력하세요.");
		return;
	}
	
	console.log(userId+" : " + displayName+" : " + email+" : " + platform+" : " + language+" : " + question);
	
	$.ajax({
		type: "post",
		url: "/project/user?cmd=questionProc",
		data: {
			"userId":userId ,
			"displayName":displayName ,
			"email":email ,
			"platform":platform ,
			"language":language ,
			"question":question ,
		},
		dataType: "text"
	}).done(function(result){
		if(result == 1){
			$("#question").val("");
			alert("문의가 등록 되었습니다.");
			location.href='/project/home?cmd=home';
		} else {
			alert("문의 등록에 실패하였습니다.");
			location.href='/project/home?cmd=home';
		}
		
	}).fail(function(error){
		alert("서버오류");
	})
	
	
}
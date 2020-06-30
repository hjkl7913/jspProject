function DeletePassChange() {
	$("#password").val("");
	$("#newPassword").val("");
	$("#renewPassword").val("");
	return;
}

function PassChangeCheck(id) {
	
	var password = $("#password").val();
	var newPassword = $("#newPassword").val();
	var renewPassword = $("#renewPassword").val();
	
	if(password =="" || password==null || newPassword =="" || newPassword==null || renewPassword =="" || renewPassword==null) {
		alert("빈칸을 채워주세요.");
		return;
	}
	
	if(newPassword != renewPassword) {
		alert("새 비밀번호와 재입력 비밀번호가 일치 하지 않습니다.");
		return;
	} 
	
	$.ajax({
		type: "post",
		url: "/project/user?cmd=passwordCheck",
		data: {
			"id":id, 
			"password":password},
			
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text"
	}).done(function(result){
		if(result != 1){
			alert("현재 비밀번호와 일치 하지 않습니다.");
			return;
		}else {
			ChangePassword(id,newPassword);
		}
		
	}).fail(function(error){
		alert("서버오류");
		console.log(error);
	})
	
}

function ChangePassword(id,newPassword) {
	$.ajax({
		type: "post",
		url: "/project/user?cmd=passwordUpdate",
		data: {
			"id":id, 
			"newPassword":newPassword},
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text"
	}).done(function(result){ 
		if(result == 1){
			alert("비밀번호 변경 성공");
			location.href="/project/user?cmd=accountPassword&id="+id;
		}else{
		alert("비밀번호 변경 실패");
		}
	}).fail(function(error){
		alert("서버오류!");
	})
}



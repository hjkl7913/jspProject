function DeleteInput() {
	$("#code__input").val("");
	return;
}


function codeCheck(userId) {
	var code = $("#code__input").val();
	
	if(code =="" || code==null) {
		alert("코드를 입력하세요.");
		return;
	}
	
	$.ajax({
		type: "get",
		url: `/project/user?cmd=codeCheck&code=${code}&userId=${userId}`,
		dataType: "text"
			
	}).done(function(result){
		if(result == 1){
			codeUseCheck(userId,code)
		}else {
			alert("이미 사용 했거나 존재하지 않는 코드 입니다.");
		}
		
	}).fail(function(error){
		alert("서버오류1");
		console.log(error);
	})
	
}

function codeUseCheck(userId,code) {
	$.ajax({
		type: "post",
		url: "/project/user?cmd=codeUseCheck",
		data:{
			"userId":userId,
			"code":code
		},
		dataType: "text"
			
	}).done(function(result){
		if(result == 1){
			alert("이미 구매한 게임 입니다.");
		}else {
			codeUse(userId,code)
		}
		
	}).fail(function(error){
		alert("서버오류2");
		console.log(error);
	})
	
}

function codeUse(userId,code) {
	$.ajax({
		type: "post",
		url: "/project/user?cmd=codeUse",
		data:{
			"userId":userId,
			"code":code
		},
		dataType: "json"
			
	}).done(function(usedGameCodeJsons){
		if(usedGameCodeJsons != null){
			alert("여까지 왔나?");
			console.log(usedGameCodeJsons);
		}else {
			alert("코드 사용 실패");
		}
		
	}).fail(function(error){
		alert("서버오류2");
		console.log(error);
	})
	
}




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
		if(result == 0 || result == -1){
			alert("이미 사용 하거나 존재하지 않는 코드 입니다.");
		}else{
			codeUseCheck(userId,code,result);
		}
		
	}).fail(function(error){
		if(userId == null || userId == ""){
			alert("로그인이 필요합니다.");
		}
		alert("서버오류1");
		console.log(error);
	})
	
}

function codeUseCheck(userId,code,gamename) {
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
			alert("게임이름: gamename은 이미 구매한 게임 입니다.");
		}else {
			codeUse(userId,code,gamename)
		}
		
	}).fail(function(error){
		
		alert("서버오류2");
		console.log(error);
	})
	
}

function codeUse(userId,code,gamename) {
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
			$(".usecode-add").empty();
			renderUsedCodeList(usedGameCodeJsons);
			alert(gamename+" : 게임 코드 사용 성공");
		}else {
			alert("코드 사용 실패");
		}
		
	}).fail(function(error){
		alert("서버오류3");
		console.log(error);
	})
	
}

function renderUsedCodeList(usedGameCodeJsons){
	for(var usedGameCodeJson of usedGameCodeJsons){
		$(".usecode-add").append(makeCodeItem(usedGameCodeJson));
	}
}


function makeCodeItem(usedGameCodeJson){
	var usedCodeItem = `<div class="user-code" id="user__code__${usedGameCodeJson.id}">`;
	usedCodeItem += `<h5>게임이름 : ${usedGameCodeJson.gamename}</h5>`;
	usedCodeItem += `<p>사용한 코드: ${usedGameCodeJson.gameCode}</p>`;
	usedCodeItem += `<p>사용한 날짜: ${usedGameCodeJson.useDate}</p>`;
	usedCodeItem += `</div>`;

	
	return usedCodeItem;
} 


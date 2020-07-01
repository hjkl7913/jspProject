
function adminCodeCheck(gameId, gamename) {
	var code = $("#code__input").val();
	
	if(code == "" || code == null) {
		alert("코드를 입력하세요.");
		return;
	}
	
	$.ajax({
		type: "get",
		url: `/project/admin?cmd=adminCodeCheck&code=${code}`,
		dataType: "text"
			
	}).done(function(result){
		if(result == 1){
			alert("이미 존재하는 코드 입니다.");
		}else if (result == "long"){
			alert("코드는 20자 로 입력하세요.");
		}else if (result == 0){
			adminCodeAdd(gameId, gamename, code)
		}
		
	}).fail(function(error){
		if(userId == null || userId == ""){
			alert("로그인이 필요합니다.");
			return;
		}
		alert("서버오류1");
		console.log(error);
	})
	
}

function adminCodeAdd(gameId, gamename, code) {
	$.ajax({
		type: "post",
		url: "/project/admin?cmd=codeAddProc",
		data:{
			"gameId":gameId,
			"gamename":gamename,
			"code":code
		},
		dataType: "text"
			
	}).done(function(result){
		if(result == 1){
			$("#code__input").val("");
			alert("코드 추가 성공");
		}else {
			alert("코드 추가 실패");
		}
		
	}).fail(function(error){
		alert("adminCodeAdd : 서버오류");
		console.log(error);
	})
	
}
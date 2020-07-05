function adminCodeDelete(codeId) {
	var deleteSel = confirm("삭제 하시겠습니까?");
	
	if(deleteSel == true) {
	
	$.ajax({
		type: "get",
		url: "/project/admin?cmd=adminCodeDelete&codeId="+codeId,
		dataTye: "text"
	
	}).done(function(result) {
		if(result == 1){
			console.log("삭제성공");
			$("#admin__code__"+codeId).remove();
			adminCodeReSearch(codeId);
			
		} else {
			alert("삭제실패");
		}
		
	}).fail(function(error){
		alert("서버 오류");
	})
	
	} else {
		return;
	}
	
}

function adminCodeReSearch(codeId) {
	$.ajax({
		type: "get",
		url: "/project/admin?cmd=adminCodeReSearchAll&codeId="+codeId,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType:"json"
			
	}).done(function(gameCodesJasons) {
		if(gameCodesJasons != null ){
			renderCodeList(gameCodesJasons,codeId);
		} else {
			alert("목록 받아오기 실패");
		}	
	}).fail(function(error){
		alert("서버 오류");
	})
}


function renderCodeList(gameCodesJasons,codeId){
	for(var gameCodesJason of gameCodesJasons){
		$("#admin__code__"+codeId).append(makeCodeItem(gameCodesJason,codeId));
	}
}


function makeCodeItem(gameCodesJason,codeId){
	
	var CodeItem = `<div class="row" id="admin__code__${gameCode.codeId}">`;
	CodeItem += `<div class="admin-code" >`;
	CodeItem += `<h5>게임이름 : ${gameCode.gamename}</h5>`;
	CodeItem += `<p>게임코드: ${gameCode.code}</p>`;
	CodeItem += `</div>`;
	CodeItem += `<div>`;
	CodeItem += `<i style='font-size:24px; cursor: pointer;' class='fas' onclick="adminCodeDelete('${gameCode.codeId}')">&#xf410;</i>`;
	CodeItem += `</div>`;


	
	return CodeItem;
} 
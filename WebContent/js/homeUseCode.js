
$("#code__use__home").keyup(function (e){
    var code = $(this).val();
    if(code.length == 5 || code.length == 11 || code.length == 17){
    	$("#code__use__home").val(code+"-");
    }
    setTimeout(function() {
    if(code.length == 23){
    	
    	$.ajax({
    		type: "get",
    		url: "/project/user?cmd=homeCodeCheck&code="+code,
    		dataType: "json",
    		async : false
    	}).done(function(homeUseCodeDto){
    		if(homeUseCodeDto != null){
    			console.log(homeUseCodeDto);
    			var img = homeUseCodeDto.gameImage;
    			var gamename = homeUseCodeDto.gameCode.gamename;
    			
    			
    				
    			$("#find__code").empty();
    			renderFindcode(gamename);
    			$("#img_form_url").attr("src", img);
    			$(".home-code-btn").removeAttr("disabled");
    			
    			
    			
    		} else if (homeUseCodeDto == null) {
    			//console.log(homeUseCodeDto);
    			
    			$("#find__code").empty();
    			renderFindCodeFail();
    			$("#img_form_url").attr("src", "/project/image/codeuse.png");
    			$(".home-code-btn").attr("disabled");
    			
    		}
    		
    	}).fail(function(error){
    		alert("서버오류");
    	})
    } else if(code.length < 23) {
    	
    	$(".home-code-btn").attr("disabled","disabled");
    	$("#img_form_url").attr("src", "/project/image/codeuse.png");
    	
    }
    }, 1000);
});


function renderFindcode(gamename) {
	var searchItem = `<h4>게임이름 : ${gamename}</h4>`;
	
	$("#find__code").append(searchItem);
}

function renderFindCodeFail() {

	var searchItem2 = `<h5>코드가 존재하지 않습니다.</h5>`;
	$("#find__code").append(searchItem2);
}


function homeCodeUseCheck() {
	var code = $("#code__use__home").val();
	var userId = $("#userId").val();
	
	$.ajax({
		type: "get",
		url: `/project/user?cmd=codeUseCheck&userId=${userId}&code=${code}`,
		dataType:"text"
	}).done(function(result){
		if(result == 1){
			alert("이미구매한 게임입니다.");
			$("#code__use__home").val("");
			$(".home-code-btn").attr("disabled","disabled");
		} else {
			homeCodeUse(userId, code);
		}
	}).fail(function(error){
		alert("서버 오류1");
	})
}


function homeCodeUse(userId, code) {
	$.ajax({
		type: "post",
		url: "/project/user?cmd=homeUseCode",
		data:{
			"userId":userId,
			"code":code
		},
		dataType:"text"
	}).done(function(result){
		if(result == 1){
			alert("코드사용 성공");
			$("#code__use__home").val("");
			$(".home-code-btn").attr("disabled","disabled");
		} else {
			alert("코드사용 실패");
			$("#code__use__home").val("");
			$(".home-code-btn").attr("disabled","disabled");
		}
	}).fail(function(error){
		alert("서버 오류2");
	})
	
}


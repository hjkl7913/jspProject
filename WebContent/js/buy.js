function gameBuy(id){
	$.ajax({
		type: "get",
		url: "/project/home?cmd=gameBuy&id="+id
	}).done(function(result){
		if(result == 1){
			console.log(result);
			alert("구매 성공");
			
		}else{
			alert("로그인이 필요합니다.");
		}
			
	}).fail(function(error){
		alert("서버오류");
		
	})
}
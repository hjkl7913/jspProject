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

function CartAddCheck(gameId, userId, gamename, contentImage, price) {
	console.log("userId : "+userId);
	if(userId == "" || userId == null){
		alert("로그인이 필요합니다.");
		return;
	}
	
	
	$.ajax({
		type: "post",
		url: "/project/user?cmd=cartAddCheck",
		data: {
			"gameId" : gameId,
			"userId" : userId,
			"gamename" : gamename
		},
		contentType: "application/x-www-form-urlencoded; charset=utf-8",		
		dateType: "text"
			
	}).done(function(result) {
		if(result == 1){
			alert("이미 리스트에 있습니다.");
			return;
		}else{
			CartAdd(gameId, userId, gamename, contentImage, price);
		}
		
	}).fail(function(error) {
		alert("서버오류");
		console.log(error);
	})
	
}


function CartAdd(gameId, userId, gamename, contentImage, price) {
	
	
	$.ajax({
		type: "post",
		url: "/project/user?cmd=cartAdd",
		data: {
			"gameId" : gameId,
			"userId" : userId,
			"gamename" : gamename,
			"contentImage" : contentImage,
			"price" : price
		},
		contentType: "application/x-www-form-urlencoded; charset=utf-8",		
		dateType: "text"
			
	}).done(function(result) {
		if(result == 1){
			alert("위시리스트 추가 성공");
		}else{
			alert("위시리스트 추가 실패");
		}
		
	}).fail(function(error) {
		alert("서버오류");
		console.log(error);
	})
}
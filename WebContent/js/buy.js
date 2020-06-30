function gameBuyCheck(gameId,userId,gamename){
	if(userId == "" || userId == null){
		alert("로그인이 필요합니다.");
		return;
	}
	
	var Buyconfirm = confirm("구매 하시겠습니까?");
	
	if(Buyconfirm == true){
		$.ajax({
			type : "get",
			url : "/project/user?cmd=gameBuyCheck",
			data: {
				"gameId":gameId , 
				"userId":userId,
				"gamename":gamename
			},
			dataType: "text"
			
		}).done(function(result) {
			if(result == 1){
				alert("이미 구매한 게임 입니다.");
			} else {
				gameBuy(gameId,userId,gamename);
			}
			
		}).fail(function(error){
			alert("서버 오류");
		})
		
	} else {
		return;
	}
	
}


function gameBuy(gameId,userId,gamename){
	
		$.ajax({
			type : "post",
			url : "/project/user?cmd=gameBuy",
			data: {
				"gameId":gameId , 
				"userId":userId,
				"gamename":gamename
			},
			dataType: "text"
			
		}).done(function(result) {
			if(result == 1){
				gameBuyCount(gameId);
			} else {
				alert("구매 실패");
			}
			
		}).fail(function(error){
			alert("서버 오류");
		})
		
	
}





function gameBuyCount(gameId){
	
	$.ajax({
		type: "get",
		url: "/project/user?cmd=gameBuyCount&id="+gameId
	}).done(function(result){
		if(result == 1){
			alert("구매 성공");
			console.log(result);
		}else{
			alert("카운트 증가 실패");
		}
			
	}).fail(function(error){
		alert("서버오류");
		
	})
	
}


function CartAddCheck(gameId, userId, gamename, contentImage, price) {
	
	if(userId == "" || userId == null){
		alert("로그인이 필요합니다.");
		return;
	}
	
	var cartConfirm = confirm("위시리스트에 추가 하시겠습니까?");
	
	if(cartConfirm == true){
	
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
	else{
		return;
	}
	
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
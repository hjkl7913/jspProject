function gameBuyCheck(cartId , gameId, userId, gamename){ //id 는 cart 아이디
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
				console.log("gameBuyCheck : gameId : " + gameId)
				gameBuy(cartId, gameId, userId, gamename);
			}
			
		}).fail(function(error){
			alert("서버 오류1");
		})
		
	} else {
		return;
	}
	
}


function gameBuy(cartId ,gameId,userId,gamename){
	
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
				gameBuyCount(cartId ,gameId);
			} else {
				alert("구매 실패");
			}
			
		}).fail(function(error){
			alert("서버 오류2");
		})
		
	
}



function gameBuyCount(cartId , gameId){
	
	$.ajax({
		type: "get",
		url: "/project/user?cmd=gameBuyCount&id="+gameId
	}).done(function(result){
		if(result == 1){
			alert("구매 성공");
			console.log("gameBuyCount : "+cartId);
			$("#cart__de__"+cartId).remove();
			cartDelete2(cartId);
		}else{
			alert("카운트 증가 실패");
		}
			
	}).fail(function(error){
		alert("서버오류3");
		
	})
	
}

function cartDelete2(id) {
	
	$.ajax({
		type: "get",
		url: "/project/user?cmd=cartDelete&id="+id,
		dataTye: "text"
	
	}).done(function(result) {
		if(result == 1){
			$("#cart__de__"+id).remove();
			console.log("삭제성공");
			cartReSearch2(id);
			
		} else {
			alert("삭제실패");
		}
		
	}).fail(function(error){
		alert("서버 오류4");
	})
	
}


function cartReSearch2(id) {
	$.ajax({
		type: "get",
		url: "/project/user?cmd=cartReSearch&id="+id,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType:"json"
			
	}).done(function(cartReSearchJsons) {
		if(cartReSearchJsons != null ){
			renderCartList(cartReSearchJsons,id);
		} else {
			alert("목록 받아오기 실패");
		}	
	}).fail(function(error){
		alert("서버 오류5");
	})
}



function renderCartList(cartReSearchJsons,id){
	for(var cartReSearchJson of cartReSearchJsons){
		$("#cart__de__"+id).append(makeCartItem(cartReSearchJson,id));
	}
}


function makeCartItem(cartReSearchJson,id){
	
	var cartItem = `<div id="cart__de__${cartReSearchJson.id}">`;
	cartItem += `<div class="jumbotron" id="cart__jumbo">`;
	cartItem += `<div class="container">`;
	cartItem += `<div class="row">`;
	cartItem += `<div class="col-lg-4">`;
	cartItem += `<img src="${cartReSearchJson.contentImage}" alt="https://dummyimage.com/1200x800/949494/fff.png" class="img-fluid">`;
	cartItem += `</div>`;
	cartItem += `<div class="col-lg-7 justify-content-end">`;
	cartItem += `<div>`;
	cartItem += `<h4>${cartReSearchJson.gamename}</h4>`;
	cartItem += `<h5>${cartReSearchJson.price}</h5>`;
	cartItem += `</div><br/>`;
	cartItem += `<div class="d-flex justify-content-end">`;
	cartItem += `<span class="text-center d-inline-block"> <a class="btn btn-primary btn-lg w-100" onclick="buyCount('${cartReSearchJson.id}',${cartReSearchJson.gameid})" role="button">구매하기</a>`;
	cartItem += `</span>`;
	cartItem += `</div>`;
	cartItem += `</div>`;
	cartItem += `<div class="col-lg-1 ">`;
	// 삭제 버튼
	cartItem += `<i style='font-size:24px' class='fas' onclick="cartDelete('${cartReSearchJson.id}')">&#xf410;</i>`;
	cartItem += `</div>`;
	cartItem += `</div>`;
	cartItem += `</div>`;
	cartItem += `</div>`;
	cartItem += `</div>`;
	
	return cartItem;
} 

function cartDelete(id) {
	var deleteSel = confirm("삭제 하시겠습니까?");
	
	if(deleteSel == true) {
	
	$.ajax({
		type: "get",
		url: "/project/user?cmd=cartDelete&id="+id,
		dataTye: "text"
	
	}).done(function(result) {
		if(result == 1){
			console.log("삭제성공");
			$("#cart__de__"+id).remove();
			cartReSearch(id);
			
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

function cartReSearch(id) {
	$.ajax({
		type: "get",
		url: "/project/user?cmd=cartReSearch&id="+id,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType:"json"
			
	}).done(function(cartReSearchJsons) {
		if(cartReSearchJsons != null ){
			renderReplyList(cartReSearchJsons,id);
		} else {
			alert("목록 받아오기 실패");
		}	
	}).fail(function(error){
		alert("서버 오류");
	})
}


function renderReplyList(cartReSearchJsons,id){
	for(var cartReSearchJson of cartReSearchJsons){
		$("#cart__de__"+id).append(makeReplyItem(cartReSearchJson,id));
	}
}


function makeReplyItem(cartReSearchJson,id){
	console.log("여기왔냐?2");
	var repyItem = `<div id="cart__de__${cartReSearchJson.id}">`;
	replyItem += `<div class="jumbotron" id="cart__jumbo">`;
	replyItem += `<div class="container">`;
	replyItem += `<div class="row">`;
	replyItem += `<div class="col-lg-4">`;
	replyItem += `<img src="${cartReSearchJson.contentImage}" alt="https://dummyimage.com/1200x800/949494/fff.png" class="img-fluid">`;
	replyItem += `</div>`;
	replyItem += `<div class="col-lg-7 justify-content-end">`;
	replyItem += `<div>`;
	replyItem += `<h4>${cartReSearchJson.gamename}</h4>`;
	replyItem += `<h5>${cartReSearchJson.price}</h5>`;
	replyItem += `</div><br/>`;
	replyItem += `<div class="d-flex justify-content-end">`;
	replyItem += `<span class="text-center d-inline-block"> <a class="btn btn-primary btn-lg w-100" href="#" role="button">구매하기</a>`;
	replyItem += `</span>`;
	replyItem += `</div>`;
	replyItem += `</div>`;
	replyItem += `<div class="col-lg-1 ">`;
	// 삭제 버튼
	replyItem += `<i style='font-size:24px' class='fas' onclick="cartDelete('${cartReSearchJson.id}')">&#xf410;</i>`;
	replyItem += `</div>`;
	replyItem += `</div>`;
	replyItem += `</div>`;
	replyItem += `</div>`;
	replyItem += `</div>`;
	
	return replyItem;
} 
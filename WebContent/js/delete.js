function deleteById(id){
	$.ajax({
		type: "POST",
		url: "/project/admin?cmd=delete&id="+id,
		dataType: "text"
	}).done(function(result){
		if(result == 1){
			alert("삭제 성공");
			location.href="/project/admin/admin.jsp";
		}else{
			alert("삭제실패");
		}
			
	}).fail(function(error){
		alert("서버오류");
		
	})
}
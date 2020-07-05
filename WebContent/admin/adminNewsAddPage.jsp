<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/nav.jsp"%>

	<br/><br/><br/><br/>
	<div class="container" style="background-color: white;">
		<br/><br/>
		<h2 style="color: black;">새소식 추가</h2><br/><br/>
		<form action="/project/admin?cmd=newsAddProc" method="post" enctype="multipart/form-data">
		
		<div class="col-lg-3">
		<label for="usr">새소식 이미지</label>
			<div class="form-group">
				<img id="img__wrap" onerror="this.src='/project/image/logo.png'" width="550px" height="300px" />
			</div>
			<div class="form-group bg-light">
			
				<input type="file" name="image" id="img__preview" />
			</div>
		</div>
		<div class="form-group">
				<label for="comment">새소식</label>
				<textarea class="form-control" rows="5" id="news" name="news" placeholder="내용을 입력하세요."></textarea>
		</div>
		<input type="hidden" name="gameId" value="${id}"> <br/>
		
		<div class="d-flex justify-content-end" >
		<button type="submit" class="btn btn-warning">추가</button>
		</div><br/><br/>
		</form>
	</div>
	<br/><br/><br/><br/>
	
<script src="/project/js/imgPreview.js"></script>

<%@ include file="../include/footer.jsp"%>

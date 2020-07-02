<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-7 mx-auto" id="login__col__con">
			<div class="card card-signin my-5">
				<div class="card-body" id="login__con">
					<h1 class="card-title">문의하기</h1>
						
						<br />
						<div class="form-question">
						<div class="form-label-group">
							<input type="text" id="displayName" name="displayName" class="form-control" value="${sessionScope.principal.displayName}" placeholder="디스플레이 이름" required readonly>
						</div>
						
						<input type="hidden" id="userId" value="${sessionScope.principal.id}">
						
						<br />
						<div class="form-label-group">
							<input type="text" id="email" name="email" class="form-control" value="${sessionScope.principal.email}" placeholder="이메일" readonly>
						</div>
						<br /> 
						<select name="platform" class="select-op1">
  						  <option value="Android">Android</option>
  						  <option value="iOS">iOS</option>
   						 <option value="Mac">Mac</option>
   						 <option value="PC">PC</option>
  						  <option value="PlayStation 4">PlayStation 4</option>
  						  <option value="Switch">Switch</option>
   						 <option value="Xbox One">Xbox One</option>
   						 <option value="기타">기타</option>
  						</select>
  						  <br />  <br />  
  						 <select name="language" class="select-op2">
  						  <option value="English">English</option>
  						  <option value="한국어" selected="selected">한국어</option>
  						  <option value="日本語">日本語</option>
  						  <option value="简体中文">简体中文</option>
  						  <option value="Français">Français</option>
  						  <option value="Deutsch">Deutsch</option>
  						 
  						</select>
						 <br /> <br />
						 <p style="font-size: 16px;">한국어 (처음 답변을 받을 때까지 걸리는 평균 시간은 21시간입니다.)의 요청 건수가 많아 지원이 지연될 수 있습니다. 기타 능숙한 언어로 바꾸어 요청하면 더 빠른 지원을 받으실 수 있습니다. 현재 가장 빠른 응답을 받을 수 있는 언어는 English (처음 답변을 받을 때까지 걸리는 평균 시간은 3시간입니다.)입니다.</p>
						<div class="form-group">
      					<label for="comment"></label>
      					<textarea class="form-control" rows="7" id="question" name="question" placeholder="여기에 문제를 설명하세요." required="required"></textarea>
    					</div>
						<div class="container">
						<div class="row col-lg-12">
						<div class="col-lg-6">
						<button class="btn btn-lg btn-light btn-block text-uppercase" style="color: black;" onclick="back()">취소</button>
						</div>
						<div class="col-lg-6">
						<button class="btn btn-lg btn-primary btn-block text-uppercase" onclick="questionSubmit()">제출</button>
						</div>
						</div>
						</div>
						<hr class="my-4">
						</div>
						
				

				</div>
			</div>
		</div>
	</div>
</div>
<br />
<br />
<br />
<br />

<script src="/project/js/questionBox.js"></script>

<%@ include file="../include/footer.jsp"%>
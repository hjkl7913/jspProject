<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<div style="background-color: white;">
	<br />
	<br />
	<div class="container  d-flex justify-content-center">
	<div class="col-lg-9">
	<form method="post"  action="/project/admin?cmd=answerComplete">
		<div class="row">
			
			<div class="col">
				<label>questionId</label> <input type="text" class="form-control"   name="questionId" value="${userQuestion.questionId}" readonly>
			</div>
			<div class="col">
				<label>유저id</label> <input type="text" class="form-control"  name="userId" value="${userQuestion.userId}" readonly>
			</div>
		</div><br/>
		<div class="row">
			<div class="col">
				<label>유저 닉네임</label> <input type="text" class="form-control"  name="displayName" value="${userQuestion.displayName}" readonly>
			</div>
			<div class="col">
				<label>유저 이메일</label> <input type="text" class="form-control"  name="email" value="${userQuestion.email}" readonly>
			</div>
		</div><br/>
		<div class="row">
			<div class="col">
				<label>플랫폼</label> <input type="text" class="form-control"  name="platform" value="${userQuestion.platform}" readonly>
			</div>
			<div class="col">
				<label>사용언어</label> <input type="text" class="form-control"  name="language" value="${userQuestion.language}" readonly>
			</div>
		</div><br/>
				<label>작성일</label> <input type="text" class="form-control"  name="writeDate" value="${userQuestion.writeDate}" readonly>
			<br/>
			<label>문의 내용</label>
			<textarea class="form-control" rows="5" id="question" name="question" readonly>${userQuestion.question}</textarea>
		
			<br/>
			<label>답변</label>
			<textarea class="form-control" rows="10" id="answer" name="answer" placeholder="내용을 입력하세요." required></textarea>
			<br/>
			<div class="d-flex justify-content-end">
			<button type="submit" class="btn btn-success">답변 보내기</button>
			</div>
	</form>		
	<br />
	<br />
	<br />
	
</div><br />
	<br />
</div>
</div>

<%@ include file="../include/footer.jsp"%>
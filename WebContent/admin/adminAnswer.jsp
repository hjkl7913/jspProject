<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

	<div style="background-color: white;"><br/><br/>
	<div class="container">
		<c:forEach var="userQuestion" items="${userQuestions}">
		<div class="row d-flex justify-content-between" id="admin__answer">
			<p>질문 id: ${userQuestion.questionId} </p>
			<p>닉네임: ${userQuestion.displayName}</p>
			<p>플랫폼: ${userQuestion.platform}</p>
			<p>언어: ${userQuestion.language}</p>
			<p>작성날짜: ${userQuestion.writeDate}</p>
			<a href="/project/admin?cmd=answerProc&questionId=${userQuestion.questionId}"><button type="button"class="btn btn-danger">답변하기</button></a>
		</div>
		</c:forEach>
	
		
	</div>
	<br/><br/><br/><br/><br/><br/><br/>
	</div>

<%@ include file="../include/footer.jsp"%>
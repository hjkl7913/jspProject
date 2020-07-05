<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

	<div style="background-color: #2A2A2A;"><br/><br/>
	<div class="container col-lg-12">
	
	<div class="row">
	<div class="col-lg-2">
	</div>
	<div class="col-lg-8">	
	<h3 style="color: white;">유저 문의</h3><br/>
		<table class="table table-dark table-hover">
    <thead>
      <tr>
        <th>질문 id</th>
        <th>닉네임</th>
        <th>플랫폼</th>
        <th>언어</th>
        <th>작성날짜</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="userQuestion" items="${userQuestions}">
      <tr>
        <td>${userQuestion.questionId}</td>
        <td>${userQuestion.displayName}</td>
        <td>${userQuestion.platform}</td>
        <td>${userQuestion.language}</td>
        <td>${userQuestion.writeDate}</td>
        <td><a href="/project/admin?cmd=answerProc&questionId=${userQuestion.questionId}"><button type="button"class="btn btn-danger">답변하기</button></a></td>      
      </tr>
       </c:forEach>
    </tbody>
   
  </table>
	
		
	
		
	</div>
	</div>
	<div class="col-lg-2">
	</div>
	<br/><br/><br/><br/><br/><br/><br/>
	</div>
	</div>

<%@ include file="../include/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<br />
<br />
<br />
<div class="container" style="background-color: white;">
	<br /> <br />
	<h2 style="color: black;">게임코드 전체목록</h2>
	
	<br />
	<c:forEach var="gameCode" items="${gameCodes}">
	<div class="row" id="admin__code__${gameCode.codeId}">
	<div class="admin-code" >
		<h5>게임이름 : ${gameCode.gamename}</h5>
		<p>게임코드: ${gameCode.code}</p>
	</div>
	<div>
		<i style='font-size:24px' class='fas' onclick="adminCodeDelete('${gameCode.codeId}')">&#xf410;</i>
	</div>
	</div>
	</c:forEach>
<br /><br /><br />
</div>
<br />
<br />
<br />

<script src="/project/js/adminCodeDelete.js"></script>

</body>
</html>
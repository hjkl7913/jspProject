<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>


<div class="account-page" id="account__page">
	<br /> <br />
	<br />
	<div class="container">
		<div class="container col-lg-12">

			<div class="row">
				<div class="container col-lg-3">
					<div id="account__page__table">

						<a href="/project/user?cmd=account&id=${param.id}"><button>일반</button></a> <a href="/project/user?cmd=accountCart&id=${param.id}"><button>거래</button></a> <a
							href="/project/user?cmd=accountPassword&id=${param.id}"><button>비밀번호 및 보안</button></a> <a href="/project/user?cmd=accountCode&id=${param.id}"><button>코드 사용</button></a>

					</div>
				</div>
				<div class="container col-lg-9" style="background-color: white;">
					<br />
					<h4 style="color: black;">코드 사용</h4>
					<br />



					<div class="row">

						<div class="col-lg-6">


							<div class="form-group">

								<br /> <input class="form-control" type="text" id="code__input" placeholder="코드입력 *" maxlength="19" />
							</div>
							<br />
							<div id="code__btn">
								<button type="submit" class="btn btn-primary" id="gggg" onclick="DeleteInput()">취소</button>
								<button type="submit" class="btn btn-primary" onclick="codeCheck('${param.id}')">사용</button>
							</div>
						</div>

						<div class="col-lg-6">
							<div class="form-group"></div>
							<br />

						</div>
					</div>
					<br />
				</div>


			</div>
			<br />
			<div class="row">
				<div class="container col-lg-3"></div>
				<div class="container col-lg-9" style="background-color: white;">

					<div class="col-lg-9">
						<br />
						<div class="form-group" id="code__con">
							<h4 style="color: black;">코드 찾는 방법</h4>
							<p>제품 코드 예: K5XSH-CTLEQ-Q5RF6-U7YD9 또는 K5XSHCTLEQQ5RF6U7YD9</p>

							<br />
							<h5>이메일</h5>
							<p>확인 이메일에서 제품 코드를 찾아보세요.</p>
							<br />
							<h5>박스 또는 매뉴얼</h5>
							<p>박스 또는 매뉴얼에서 제품 코드를 찾아보세요.</p>
						</div>
						<br />
						<h5>코드 사용 기록</h5>
					</div><br />
					
					<div class="usecode-add">
					
					<c:forEach var="usedGameCode" items="${usedGameCodes}">
					<div class="user-code" id="user__code__${usedGameCode.id}">
						<h5>게임이름 : ${usedGameCode.gamename}</h5>
						<p>사용한 코드: ${usedGameCode.gameCode}</p>
						<p>사용한 날짜: ${usedGameCode.useDate}</p>
					</div>
					</c:forEach>
					</div>
					
					</div>
			<br />
				<br />
				</div>

				<br />
				<br />
				<br />
				<br />
				<br />
			</div>
		</div>


	</div>

<br />
<br />


<script src="/project/js/accountCode.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto" id="login__col__con">
				<div class="card card-signin my-5">
					<div class="card-body" id="login__con">
						<h5 class="card-title text-center">Sign In</h5>
						<form action="/project/user?cmd=loginProc" method="POST" class="form-signin">
							<div class="form-label-group">
							<p>에픽게임즈 계정으로 로그인하세요</p>
								<input type="email" id="email" name="email" value="${cookie.remember.value}" class="form-control" placeholder="이메일  주소" required autofocus>

							</div>
							<br />

							<div class="form-label-group">
								<input type="password" id="password" name="password" class="form-control" placeholder="비밀번호" required>

							</div>
							<br />
							
							
							<c:choose>
								<c:when test="${empty cookie.remember.value}">
									<div class="custom-control custom-checkbox mb-3">
										<input type="checkbox" class="custom-control-input" id="customCheck1" name="remember"> <label class="custom-control-label" for="customCheck1">사용자 이메일 저장</label>
									</div>
								</c:when>
								<c:otherwise>
									<div class="custom-control custom-checkbox mb-3">
										<input type="checkbox" class="custom-control-input" id="customCheck1" name="remember" checked> <label class="custom-control-label" for="customCheck1">사용자 이메일 저장</label>
									</div>
								</c:otherwise>
							</c:choose>
							
							
							
							<a href="/project/user?cmd=findPassword">비밀번호를 잊으셨나요?</a><br />
							
							<br />
							<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">지금 로그인</button>
							<hr class="my-4">
						</form>
						<p>에픽게임즈 계정이 없으신가요? <a href="/project/user?cmd=join">가입</a></p>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
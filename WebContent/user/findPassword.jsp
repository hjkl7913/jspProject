<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto" id="login__col__con">
				<div class="card card-signin my-5">
					<div class="card-body" id="login__con">
						<h5 class="card-title text-center">Sign In</h5>
													
							<div class="form-label-group">
							<p>비밀번호를 잊으셨나요?</p>
							<p>계정을 등록할 떄 사용한 이메일을 입력하세요. </p>
							<p>비밀번호 재설정 방법을 안내하는 이메일이 발송됩니다.</p>
							
							<div id="find__email">
								
							</div>
							
								<input type="email" id="email" name="email" class="form-control" placeholder="이메일  주소" required autofocus>
							</div>
							
							<br />
							<button class="btn btn-lg btn-dark btn-block text-uppercase" type="submit" onclick="UserPasswordFind()">이메일 보내기</button>
							<hr class="my-4">
						
						<p>비밀번호를 저장하시겠습니까? <a href="/project/user?cmd=login">로그인</a></p>

					</div>
				</div>
			</div>
		</div>
	</div>

<script src="/project/js/findPassword.js"></script>

</body>
</html>
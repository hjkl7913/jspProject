<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h5 class="card-title text-center">Sign In</h5>
					<form class="form-signin" onsubmit="return validate()">
						
						<div class="form-label-group">
							<label for="inputUsername">이름</label>
							<input type="text" id="username" class="form-control" placeholder="username" required autofocus>
							 
						</div>
						
						<div class="form-label-group">
							 <label for="inputDisplay">표시이름</label><input type="text" id="displayname" class="form-control" placeholder="displayname" required autofocus>
						</div>
						
						<div class="form-label-group">
							 <label for="inputEmail">이메일</label>
							 <button type="button" class="btn btn-warning float-right" onclick="emailCheck()">중복확인</button>
							 <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
						</div>
					
						<div class="form-label-group">
							  <label for="inputPassword">비밀번호</label><input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
						</div>

						<div class="custom-control custom-checkbox mb-3">
							<input type="checkbox" class="custom-control-input" id="customCheck1"> <label class="custom-control-label" for="customCheck1">아이디 기억하기</label>
						</div>
						<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
						<hr class="my-4">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Sign In</h5>
						<form action="/project/user?cmd=loginProc" method="POST" class="form-signin">
							<div class="form-label-group">
								<label for="inputEmail">Email address</label> <input type="email" id="email" name="email" value="${cookie.remember.value}" class="form-control" placeholder="Email address" required autofocus>

							</div>
							<br />

							<div class="form-label-group">
								<label for="inputPassword">Password</label> <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>

							</div>
							<br />
							<div class="custom-control custom-checkbox mb-3">
								<input type="checkbox" class="custom-control-input" id="customCheck1" name="remember"> <label class="custom-control-label" for="customCheck1">이메일 기억하기</label>
							</div>
							<br/>
							<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">로그인</button>
							<hr class="my-4">
						</form>
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
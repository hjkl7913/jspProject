<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h5 class="card-title text-center">Sign In</h5>
					<form action="/project/user?cmd=joinProc" method="POST" class="form-signin" onsubmit="return validate()">
						
						<div class="form-label-group">
							<label for="inputUsername">이름</label>
							<input type="text" id="username" name="username" class="form-control" placeholder="username" required autofocus>
							 
						</div>
						<br/>
						
						<div class="form-label-group">
							 <label for="inputDisplay">표시이름</label><input type="text" id="displayname" name="displayname" class="form-control" placeholder="displayname" required autofocus>
						</div>
						<br/>
						
						<div class="form-label-group">
							 <button type="button" class="btn btn-warning float-right" onclick="EmailCheck()">중복확인</button>
							 <label for="inputEmail">이메일</label>
							 <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required autofocus>
						</div>
						<br/>
					
						<div class="form-label-group">
							  <label for="password">비밀번호</label><input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
						</div>

						<br/>
						<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
						<hr class="my-4">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<br/><br/><br/><br/>
<script src="/project/js/join.js"></script>

<%@ include file="../include/footer.jsp"%>
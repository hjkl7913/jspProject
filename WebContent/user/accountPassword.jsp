<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>


<div class="account-page" id="account__page">
	<br /> <br /> <br />
	<div class="container">
		<div class="container col-lg-12">

			<div class="row">
				<div class="container col-lg-3">
					<div id="account__page__table">

						<a href="/project/user?cmd=account&id=${param.id}"><button>일반</button></a> 
						<a href="/project/user?cmd=account&id=${param.id}"><button>거래</button></a> 
						<a href="/project/user?cmd=accountPassword&id=${param.id}"><button>비밀번호 및 보안</button></a> 
						<a href="/project/user?cmd=account&id=${param.id}"><button>코드 사용</button></a>
						
					</div>
				</div>
				<div class="container col-lg-9" style="background-color: white;">
					<br />
					<h4 style="color: black;">비밀번호 변경</h4>
					<br />
					<p>보안을 위해 비밀번호는 다른 온라인 계정에서 사용하지 않는 고유한 것을 사용하길 권장합니다.</p>
					<br />
					
						
						<div class="row">

							<div class="col-lg-6">

								<div class="form-group">
									
									<br /> <label>현재 비밀번호</label> 
									<p>필수</p>
									<input type="password" class="form-control" id="password" name="password" placeholder="현재 비밀번호*" >
								</div>
								
								<div class="form-group">
									
									<br /> <label>새 비밀번호</label>
									<p>필수</p> 
									<input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="새 비밀번호* " >
								</div>
								
								<div class="form-group">

									<br /> <label>새 비밀번호 재입력</label> 
									<p>필수</p>
									<input type="password" class="form-control" id="renewPassword" name="renewPassword" placeholder="새 비밀번호 재입력*" >
								</div>
								<br />
								<button type="submit" class="btn btn-primary" onclick="DeletePassChange()">변경사항 버림</button>
								<button type="submit" class="btn btn-primary" onclick="PassChangeCheck('${param.id}')">변경사항 저장</button>
							</div>

							<div class="col-lg-6">
								<div class="form-group">
										<br/>
									 <label>귀하의 비밀번호</label> <br/>
									 <p>비밀번호는 최근에 사용한 비밀번호 5개와 같을 수 없습니다.</p><br />
									 <p>비밀번호는 7자 이상 입력해야 합니다.</p><br />
									 <p>비밀번호에는 숫자가 최소 1자 들어있어야 합니다.</p><br />
									 <p>비밀번호에는 공백이 없어야 합니다.</p><br />
									 
								</div>
								<br />

						</div>
						</div>
					<br/><br/><br/><br/><br/>
				</div>
			
			</div>

		</div>
	</div><br/><br/>
</div>


<script src="/project/js/join.js"></script>
<script src="/project/js/accountPassword.js"></script>


</body>
</html>
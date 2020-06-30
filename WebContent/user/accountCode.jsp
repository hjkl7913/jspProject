<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>


<div class="account-page" id="account__page">
	<br /> <br /><br />
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

									<br />
									<input class="form-control" type="text" placeholder="코드입력 *" maxlength="23"/>
								</div>
								<br />
								
								<button type="submit" class="btn btn-primary" onclick="">취소</button>
								<button type="submit" class="btn btn-primary" onclick="">사용</button>
							</div>

							<div class="col-lg-6">
								<div class="form-group">
										
									 
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

</body>
</html>
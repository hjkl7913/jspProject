<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<br />
	<br />
	<br />
	<br />
	<div class="col-lg-12">
		
		<div class="row" id="home__user__code">
		
			<div class="col-lg-5 d-flex justify-content-end">
				<img id="img_form_url" alt="/project/image/codeuse.png" src="/project/image/codeuse.png" width="305px" height="400px"> <br />
			</div>
			<input type="hidden" id="userId" name="userId" value="${sessionScope.principal.id}">
			<div class="col-lg-5">
				<br />
				<br />
				<br />
				<br />
				<h3>제품 등록</h3>
				<p>DVD와 함께 제공된 제품 코드 또는 기타 에픽게임즈 제품 코드를 입력하세요.</p>
				
				<div class="form-group">
					<input type="text" class="form-control" id="code__use__home" name="code" maxlength="23" placeholder="00000-00000-00000-00000" autocomplete="off" required>	
				</div>
				<div id="find__code">
								
				</div><br />
				
					<button type="button" class="home-code-btn" onclick="homeCodeUseCheck()" disabled="disabled">사용</button>
			</div>
			<div class="col-lg-2">
				
			</div>
			
		</div>
	
	</div>

</div>
<br />
<br />
<br />
<br />
<br />
<br />

<script src="/project/js/homeUseCode.js"></script>


<%@ include file="../include/footer.jsp"%>
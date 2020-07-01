<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<br />
<br />
<br />
<br />
<div class="container" style="background-color: white;">
	<br />
	<br />
	<h2 style="color: black;">게임 코드 추가</h2>
	<br />
	<br />



		<div class="form-group">
			<div class="form-group">
				<h5>게임이름 : ${gamename}</h5>
				<br />
				<br />
				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-4">
							<label for="usr">코드</label> 
							<input type="text" class="form-control" id="code__input" name="code" placeholder="코드를 입력하세요." maxlength="20"><br />
						</div>
						<div class="col-lg-8">
						
						</div>

					</div>
				</div><br />
				<p>제품 코드 예: K5XSHCTLEQQ5RF6U7YD9 (20로 입력)</p>
			</div>
		</div> <br /> 
		<div class="d-flex justify-content-end">
			<button type="submit" class="btn btn-warning" onclick="adminCodeCheck('${id}','${gamename}')">추가</button>
		</div>
		<br />
		<br />

</div>
<br />
<br />
<br />
<br />
<script src="/project/js/adminCodeAdd.js"></script>
<%@ include file="../include/footer.jsp"%>
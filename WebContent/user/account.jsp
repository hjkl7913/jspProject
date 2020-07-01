<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>


<div class="account-page" id="account__page">
	<br /> <br /> <br /> 
	<div class="container" >
		<div class="container col-lg-12">

			<div class="row">
				<div class="container col-lg-3">
					<div id="account__page__table">
						
								<a href="/project/user?cmd=account&id=${param.id}"><button>일반</button></a> <a href="/project/user?cmd=accountCart&id=${param.id}"><button>거래</button></a> <a
							href="/project/user?cmd=accountPassword&id=${param.id}"><button>비밀번호 및 보안</button></a> <a href="/project/user?cmd=accountCode&id=${param.id}"><button>코드 사용</button></a>
					</div>
				</div>
				<div class="container col-lg-9" style="background-color: white;"><br/>
					<div id="account__page__inpu">
						<h4>일반 설정</h4>
						<br />
						<p>이름, 연락처 정보 등 에픽게임즈에 공유된 계정 정보를 확인하고 관리할 수 있습니다.</p>
						<br />
						<form method="post" action="/project/user?cmd=accountUpdate">
						<input type="hidden" name="id" value="${accountUser.id}">
						
						<div class="form-group">
							<h4>계정 정보</h4> <br />
							<p>ID:  ${accountUser.id}</p><br />
							<label>표시 이름</label>
							<input type="text" class="form-control" id="usr" name="displayName" placeholder="표시명 " value="${accountUser.displayName}">
						</div><br />
						
							<h4>개인 세부 정보</h4>
							<br />
							<p>이름, 연락처 정보 등 에픽게임즈에 공유된 정보를 관리합니다. 개인 정보는 비공개로 설정되어 다른 사용자에게 표시되지 않습니다.</p>
							<div class="row">
								<div class="col">
									<label>이름</label>
									<input type="text" class="form-control" placeholder="이름 " name="text" value="${accountUser.username}" readonly>
								</div>
								<div class="col">
									<label>전화번호</label>
									<input type="text" class="form-control" placeholder="전화번호 " name="tel"  value="${accountUser.tel}">
								</div>
							</div>
							<br />
							<h4>주소</h4>

							<div class="form-group">
								<!-- 버튼타입으로 만들거면 button 이라고 명시해야 안헷갈림 , inline block 이므로 float로 위치 조정 -->
								<button type="button" class="btn btn-warning float-right" onclick="goPopup()">주소검색</button>
								<br /> <input type="text" class="form-control" id="address" placeholder="Enter address" name="address" value="${accountUser.address}" readonly>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<br />

							<h4>회사</h4>
							<p>구매 관련 회사 VAT 영수증에 사용된 회사 정보를 관리하세요.</p>
							<br />
							<div class="row">
								<div class="col">
									<label>회사명</label>
									<input type="text" class="form-control" placeholder="회사명 " name="company" value="${accountUser.company}">
								</div>
								<div class="col">
									<label>VAT 번호</label>
									<input type="text" class="form-control" placeholder="회사  VAT 번호" name="companyVAT" value="${accountUser.companyVAT}">
								</div>
							</div>
							<br />

							<h4>회사 주소</h4>

							<div class="form-group">
								<!-- 버튼타입으로 만들거면 button 이라고 명시해야 안헷갈림 , inline block 이므로 float로 위치 조정 -->
								<button type="button" class="btn btn-warning float-right" onclick="CompanyGoPopup()">회사 주소 검색</button>
								<br /> <input type="text" class="form-control" id="companyAddress" placeholder="Enter address" name="companyAddress" value="${accountUser.companyAddress}" readonly>
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div><br />
							<div class="d-flex justify-content-end">
								<button type="submit" class="btn btn-primary">회원정보 수정</button>
							</div>
							<br />
							<br />
						</form>
					</div>
					<br />

				</div>

			</div>

		</div>
	</div>
</div>

<script src="/project/js/join.js"></script>
<script src="/project/js/companyJuso.js"></script>

</body>
</html>
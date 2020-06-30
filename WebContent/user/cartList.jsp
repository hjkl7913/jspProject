<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>


<div class="account-page" id="account__page">
	<br /> <br /> <br />
	<div class="container">
		<div class="container col-lg-12">

			<div class="row">
				<div class="container col-lg-3">
					<div id="account__page__table">

						<a href="/project/user?cmd=account&id=${param.id}"><button>일반</button></a> <a href="/project/user?cmd=accountCart&id=${param.id}"><button>거래</button></a> <a
							href="/project/user?cmd=accountPassword&id=${param.id}"><button>비밀번호 및 보안</button></a> <a href="/project/user?cmd=accountCode&id=${param.id}"><button>코드 사용</button></a>

					</div>
				</div>
				<div class="container col-lg-9" style="background-color: white;" >
					<br />
					<h4 style="color: black;">결제 내역</h4>
					<br />
					<p>
						계정 결제 세부사항 및 거래명세를 확인합니다. <a href="/project/user?cmd=refundPolicy">에픽게임즈 환불 정책 보기</a>
					</p>
					<br />
					
					<c:forEach var="cart" items="${carts}">
					<div class="cartList-op" id="cart__de__${cart.id}">
					<div class="jumbotron" id="cart__jumbo">
						<div class="container">
					
							<div class="row">
								<div class="col-lg-4">
									<img src="${cart.contentImage}" alt="https://dummyimage.com/1200x800/949494/fff.png" class="img-fluid">
								</div>
								<div class="col-lg-7 justify-content-end">
									<div>
										<h4>${cart.gamename}</h4>
										<h5>${cart.price}</h5>
									
									</div><br/>
									
									<div class="d-flex justify-content-end">
									<span class="text-center d-inline-block"> <a class="btn btn-primary btn-lg w-100" onclick="gameBuyCheck('${cart.id}','${cart.gameId}','${cart.userId}','${cart.gamename}')" role="button">구매하기</a>
									</span>
									</div>

								</div>
								<div class="col-lg-1 ">
								<i style='font-size:24px' class='fas' onclick="cartDelete('${cart.id}')">&#xf410;</i>
								</div>
							</div>


						</div>
					</div>
					</div>
					</c:forEach>
					<br/>
				</div>

			</div>



		</div>

	</div>
	<br /> <br /> <br />

</div>
<br />
<br />

<script src="/project/js/cartDelete.js"></script>
<script src="/project/js/cartBuyGame.js"></script>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>


<div class="account-page" id="account__page">
	<br /> <br />
	<br />
	<div class="container">
		<div class="container col-lg-12">

			<div class="row">
				<div class="container col-lg-3">
					<div id="account__page__table">

						<a href="/project/user?cmd=account&id=${param.id}"><button>일반</button></a> 
						<a href="/project/user?cmd=accountBuyList&id=${param.id}"><button>결제내역</button></a> 
						<a href="/project/user?cmd=accountCart&id=${param.id}"><button>위시리스트</button></a> 
						<a href="/project/user?cmd=accountPassword&id=${param.id}"><button>비밀번호 및 보안</button></a> 
						<a href="/project/user?cmd=accountCode&id=${param.id}"><button>코드 사용</button></a>

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
					
					<c:forEach var="orderListResponseDto" items="${orderListResponseDtos}">
					<div class="cartList-op" id="cart__de__">
					<div class="jumbotron" id="cart__jumbo">
						<div class="container">
					
							<div class="row">
								<div class="col-lg-4">
									<img src="${orderListResponseDto.contentImage}" alt="https://dummyimage.com/1200x800/949494/fff.png" class="img-fluid">
								</div>
								<div class="col-lg-7 justify-content-end">
									<div>
										<h4>${orderListResponseDto.orderList.gamename}</h4>
										<p>결제가격: ${orderListResponseDto.price}<p>
										<p>결제일: ${orderListResponseDto.orderList.buyDate}<p>
									
									</div><br/>
									
									<div class="d-flex justify-content-end">
									<span class="text-center d-inline-block"> <a class="btn btn-warning btn-lg w-100" role="button">다운로드</a>
									</span>
									</div>

								</div>
							</div>


						</div>
					</div>
					</div>
					</c:forEach>
					<br/>
				</div>

				<br />
				<br />
				<br />

			</div>
		</div>


	</div>
	</div>

<br />
<br />



<%@ include file="../include/footer.jsp"%>
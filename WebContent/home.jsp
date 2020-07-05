<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="include/nav.jsp"%>




<div class="container">

	<br />
	<br />
	<div class="container d-flex justify-content-between">
		<div class="search__main">
			<h5>
				<a href="/project/home?cmd=search">찾아보기</a>
			</h5>
		</div>
		<div class="box ">
			<div class="container-1">

				<div class="row">
					<form action="/project/home" method="get">
						<input type="hidden" name="cmd" value="homeGameSearch"> <input type="hidden" name="page" value="0"> <input type="submit" class="img-button"
							style="background-image: url('image/search.png');" value=""> <input name="keyword" type="text" id="search" placeholder="검색" />
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="container" style="width: 1000px">

		<div id="demo" class="carousel slide" data-ride="carousel">
		<br />
		<br />
		<form class="form-inline justify-content-center">
			<!-- Indicators -->
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
			</ul>


			<!-- The slideshow -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="image/Fortnite.jpg" alt="Los Angeles" width="600px" height="300px">
				</div>
				<div class="carousel-item">
					<img src="image/starwars.png" alt="Chicago" width="600px" height="300px">
				</div>
				<div class="carousel-item">
					<img src="image/control.jpg" alt="New York" width="600px" height="300px">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next"> <span class="carousel-control-next-icon"></span>
			</a>
		</form>
	</div>
	</div>
</div>
<br />
<br />
<br />
<br />
<!-- Page Content -->
<div class="container " id="best__game">

	<!-- Page Features -->
	<div id="free__back">
		<div style="background-color: #2A2A2A">
			<h2>
				<img alt="" src="image/pre.png">무료게임
			</h2>
		</div>
		<div class="row  text-center justify-content-center" >

			<c:forEach var="freeGameInfo" items="${freeGameInfos}">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-80" id="card__div__free">
						<a href="/project/home?cmd=detail&id=${freeGameInfo.id}"><img class="card-img-top" src="${freeGameInfo.image}" alt="" height="200px"></a>
						<div class="card-body">
							<h5 class="card-title">
								<a href="/project/home?cmd=detail&id=${freeGameInfo.id}">${freeGameInfo.gamename}</a>
							</h5>
							<p class="card-text">
								<a style="color: #8e8e8e" href="/project/home?cmd=detail&id=${freeGameInfo.id}">${freeGameInfo.freeDown}</a>
							</p>
						</div>

					</div>
				</div>
			</c:forEach>


		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
</div>
<br />
<br />
<br />
<!-- new -->
<div class="container">
	<div class="col-lg-12">
		<div class="row justify-content-between">
			<div id="sale__special">
				<h4>할인 및 특별가</h4>
				<br />
				<br />
				<br />
				<h2>Borderlands 3</h2>
				<p>모든 에디션 50% 할인 및 시즌 패스 20% 할인!</p>
				<p>할인 기간은 6월 30일(미국 동부 시간 기준)에 종료됩니다.</p>
				<a href="/project/home?cmd=detail&id=10"><button class="btn btn-dark" type="button">할인 보기</button></a>

			</div>
			<div>
				<img alt="" src="image/bor3.png" width="100%" height="450px" style="margin: auto">
			</div>
		</div>


	</div>
</div>
<br />
<br />
<br />

<div class="container" id="best__game">


	<h2>베스트셀러</h2>
	<div class="best__game">
		<div class="row justify-content-start">

			<c:forEach var="BestGameInfo" items="${BestGameInfos}">
				<div class="col-lg-2 col-md-6 mb-3">
					<div class="card h-60" id="card__div__free">
						<a href="/project/home?cmd=detail&id=${BestGameInfo.id}"><img class="card-img-top" src="${BestGameInfo.image}" alt="" height="200px"></a>
						<div class="card-body">
							<p class="card-text">
								<a href="/project/home?cmd=detail&id=${BestGameInfo.id}">${BestGameInfo.gamename}</a>
							</p>
							<p class="card-text">
								<a style="color: #8e8e8e" href="/project/home?cmd=detail&id=${BestGameInfo.id}">${BestGameInfo.developer}</a>
							</p>
							<h5 class="card-title">
								<a href="/project/home?cmd=detail&id=${BestGameInfo.id}">${BestGameInfo.price}</a>
							</h5>
						</div>

					</div>
				</div>
			</c:forEach>

		</div>
		<!-- /.row -->
	</div>
</div>
<br />
<br />
<br />

<div class="container" id="great__best">
	<h2>최고 인기작</h2>
	<div class="col-lg-12">
		<div class="row">
			<c:forEach var="greatBestGameInfo" items="${greatBestGameInfos}">
				<div style="margin-right: 16px;" id="card__div__free">
					<a href="/project/home?cmd=detail&id=${greatBestGameInfo.id}"><img src="${greatBestGameInfo.image}" width="200px" height="281px"></a> <br />
					<br />
					<p>
						<a href="/project/home?cmd=detail&id=${greatBestGameInfo.id}">${greatBestGameInfo.gamename}</a>
					</p>
					<p>
						<a style="color: #8e8e8e" href="/project/home?cmd=detail&id=${greatBestGameInfo.id}">${greatBestGameInfo.developer}</a>
					</p>
					<h5>
						<a href="/project/home?cmd=detail&id=${greatBestGameInfo.id}">${greatBestGameInfo.price}</a>
					</h5>
				</div>
			</c:forEach>

		</div>
	</div>
</div>

<br />
<br />
<br />


<div class="container" id="best__game">

	<h2>출시 예정</h2>
	<div class="__game">
		<div class="row">

			<c:forEach var="ExpectedGameInfo" items="${ExpectedGameInfos}">
				<div class="col-lg-3 col-md-6 mb-3">
					<div class="card h-60" id="card__div__free">
						<a href="/project/home?cmd=detail&id=${ExpectedGameInfo.id}"><img class="card-img-top" src="${ExpectedGameInfo.image}" alt="" height="350px"></a>
						<div class="card-body">
							<p class="card-text">
								<a href="/project/home?cmd=detail&id=${ExpectedGameInfo.id}">${ExpectedGameInfo.gamename}</a>
							</p>
							<p class="card-text">
								<a style="color: #8e8e8e" href="/project/home?cmd=detail&id=${ExpectedGameInfo.id}">${ExpectedGameInfo.developer}</a>
							</p>
							<h5 class="card-title">
								<a href="/project/home?cmd=detail&id=${ExpectedGameInfo.id}">${ExpectedGameInfo.price}</a>
							</h5>
						</div>

					</div>
				</div>
			</c:forEach>

		</div>
		<!-- /.row -->
	</div>
</div>


<%@ include file="include/footer.jsp"%>
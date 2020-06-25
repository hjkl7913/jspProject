<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="include/nav.jsp"%>


</head>
<body>

	<div class="container">
		<div id="demo" class="carousel slide" data-ride="carousel">
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
	<br />
	<br />
	<br />
	<br />
	<!-- Page Content -->
	<div class="container" id="best__game">

		<!-- Page Features -->
		<div id="free__back">

			<h2>
				<img alt="" src="image/pre.png">무료게임
			</h2>
			<div class="row text-center justify-content-center">

				<c:forEach var="freeGameInfo" items="${freeGameInfos}">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-80" id="card__div__free">
							<a href="/project/home?cmd=detail&id=${freeGameInfo.id}"><img class="card-img-top" src="${freeGameInfo.image}" alt="" height="200px"></a>
							<div class="card-body">
								<h5 class="card-title">${freeGameInfo.gamename}</h5>
								<p class="card-text">${freeGameInfo.freeDown}</p>
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
	<div class="container" id="best__game">

		
		<h2>베스트셀러</h2>
		<div class="best__game">
			<div class="row">

				<c:forEach var="BestGameInfo" items="${BestGameInfos}">
					<div class="col-lg-2 col-md-6 mb-3">
						<div class="card h-60" id="card__div__best">
							<img class="card-img-top" src="${BestGameInfo.image}" alt="" height="200px">
							<div class="card-body">
								<p class="card-text">${BestGameInfo.gamename}</p>
								<p class="card-text" style="color: #6A6A6A">${BestGameInfo.developer}</p>
								<h5 class="card-title" style="color: white;">${BestGameInfo.price}</h5>
							</div>

						</div>
					</div>
				</c:forEach>

			</div>
			<!-- /.row -->
		</div>
	</div><br/><br/><br/>
	
	
	<div class="container" id="best__game">

		<h2>출시 예정</h2>
		<div class="__game">
			<div class="row">

				<c:forEach var="ExpectedGameInfo" items="${ExpectedGameInfos}">
					<div class="col-lg-3 col-md-6 mb-3">
						<div class="card h-60" id="card__div__best">
							<img class="card-img-top" src="${ExpectedGameInfo.image}" alt="" height="350px">
							<div class="card-body">
								<p class="card-text">${ExpectedGameInfo.gamename}</p>
								<p class="card-text" style="color: #6A6A6A">${ExpectedGameInfo.developer}</p>
								<h5 class="card-title" style="color: white;">${ExpectedGameInfo.price}</h5>
							</div>

						</div>
					</div>
				</c:forEach>

			</div>
			<!-- /.row -->
		</div>
	</div>
	

	<%@ include file="include/footer.jsp"%>
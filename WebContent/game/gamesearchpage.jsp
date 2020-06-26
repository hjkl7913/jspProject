<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<br />
<br />
<br />
<br />
<div class="container">
	<div class="container d-flex justify-content-end">
	<div class="box " >
		<div class="container-1">
			<span class="icon"><i class="fa fa-search"></i></span>
			<div class="row">
				<input type="button" class="img-button" style="background-image: url('image/search.png');" onclick="Search()">
				<input type="search" id="search" placeholder="검색" />
			</div>
		</div>
	</div>
	</div>
	<br/>
	<br/>


	<div class="container" id="best__game">

		<!-- Page Features -->
		<div>
			<div class="row">

			<div class="col-lg-10" >
			<div class="row text-center" id="tag__search">
			
				<c:forEach var="AllGameInfo" items="${AllGameInfos}">
				<div class="col-lg-3 col-md-6 mb-4">
					<div class="card h-80" id="card__div__free">
						<a href="/project/home?cmd=detail&id=${AllGameInfo.id}"><img class="card-img-top" src="${AllGameInfo.image}" alt="" height="230px"></a>
						<div class="card-body">
							<h5 class="card-title">${AllGameInfo.gamename}</h5>
							<p class="card-text">${AllGameInfo.developer}</p>
							<p class="card-text">${AllGameInfo.price}</p>
						</div>

					</div>
				</div>
				</c:forEach>
				
				<c:forEach var="gameInfo" items="${gameInfos}">
				<div class="col-lg-3 col-md-6 mb-4">
					<div class="card h-80" id="card__div__free">
						<a href="/project/home?cmd=detail&id=${gameInfo.id}"><img class="card-img-top" src="${gameInfo.image}" alt="" height="230px"></a>
						<div class="card-body">
							<h5 class="card-title">${gameInfo.gamename}</h5>
							<p class="card-text">${gameInfo.developer}</p>
							<p class="card-text">${gameInfo.price}</p>
						</div>

					</div>
				</div>
			</c:forEach>
					
			</div>
			</div>
			<!-- /.row -->

			
			<div class="col-lg-2">
			<strong>필터</strong><br/><br/>
			<strong><button onclick="FilterSearch('액션')">액션</button> </strong><br/><br/>
			<strong><button onclick="FilterSearch('어드벤처')">어드벤처</button></strong><br/><br/>
			<strong><button onclick="FilterSearch('모든 툴키트')" id="filter">모든 툴키트</button></strong><br/><br/>
			<strong><button onclick="FilterSearch('퍼즐')" id="filter">퍼즐</button></strong><br/><br/>
			<strong><button onclick="FilterSearch('레이싱')" id="filter">레이싱</button></strong><br/><br/>
			<strong><button onclick="FilterSearch('RPG')" id="filter">RPG</button></strong><br/><br/>
			<strong><button onclick="FilterSearch('슈팅')" id="filter">슈팅</button></strong><br/><br/>
			<strong><button onclick="FilterSearch('전략')" id="filter">전략</button></strong><br/><br/>
			<strong><button onclick="FilterSearch('생존')" id="filter">생존</button></strong><br/><br/>
			
			</div>
			
			
		</div>
		</div>
		<!-- /.container -->
	</div>

</div>

<script src="/project/js/gameSearch.js"></script>
</body>
</html>
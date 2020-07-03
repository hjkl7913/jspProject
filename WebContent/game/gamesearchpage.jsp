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
			<div class="row" id="tag__search">
			
				<c:forEach var="AllGameInfo" items="${AllGameInfos}">
				<div class="col-lg-3 col-md-6 mb-4">
					<div class="card h-80" id="card__div__free">
						<a href="/project/home?cmd=detail&id=${AllGameInfo.id}"><img class="card-img-top" src="${AllGameInfo.image}" alt="" height="260px"></a>
						<div class="card-body">
							<p class="card-text"><a href="/project/home?cmd=detail&id=${AllGameInfo.id}">${AllGameInfo.gamename}</a></p>
							<p class="card-text" id="p_gray"><a style="color: #8e8e8e" class="p_gray" href="/project/home?cmd=detail&id=${AllGameInfo.id}">${AllGameInfo.developer}</a></p>
							<h5 class="card-title"><a href="/project/home?cmd=detail&id=${AllGameInfo.id}">${AllGameInfo.price}</a></h5>
						</div>

					</div>
				</div>
				</c:forEach>
				
				<c:forEach var="gameInfo" items="${gameInfos}">
				<div class="col-lg-3 col-md-6 mb-4">
					<div class="card h-80" id="card__div__free">
						<a href="/project/home?cmd=detail&id=${gameInfo.id}"><img class="card-img-top" src="${gameInfo.image}" alt="" height="260px"></a>
						<div class="card-body">
							<p class="card-text"><a href="/project/home?cmd=detail&id=${gameInfo.id}">${gameInfo.gamename}</a><p>
							<p class="card-text"><a style="color: #8e8e8e" href="/project/home?cmd=detail&id=${gameInfo.id}">${gameInfo.developer}</a></p>
							<h5 class="card-title"><a href="/project/home?cmd=detail&id=${gameInfo.id}">${gameInfo.price}</a></h5>
						</div>

					</div>
				</div>
			</c:forEach>
					
			</div>
			</div>
			<!-- /.row -->

			
			<div class="col-lg-2" id="Tag__menu">
			<strong>필터</strong><br/><br/><hr/>
			<p style="cursor: pointer" onclick="FilterSearch('액션')">액션</p>
			<p style="cursor: pointer" onclick="FilterSearch('어드벤처')">어드벤처</p>
			<p style="cursor: pointer" onclick="FilterSearch('모드 툴키트')">모드 툴키트</p>
			<p style="cursor: pointer" onclick="FilterSearch('퍼즐')">퍼즐</p>
			<p style="cursor: pointer" onclick="FilterSearch('레이싱')">레이싱</p>
			<p style="cursor: pointer" onclick="FilterSearch('RPG')">RPG</p>
			<p style="cursor: pointer" onclick="FilterSearch('슈팅')">슈팅</p>
			<p style="cursor: pointer" onclick="FilterSearch('전략')">전략</p>
			<p style="cursor: pointer" onclick="FilterSearch('생존')">생존</p><br/>
			
			</div>
			
			
		</div>
		</div>
		<!-- /.container -->
	</div>

</div>

<script src="/project/js/gameSearch.js"></script>
<%@ include file="../include/footer.jsp"%>
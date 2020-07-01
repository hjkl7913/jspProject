<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<div class="container">
<br/><br/>
	<div class="search__main">
		<h5><a href="/project/admin?cmd=searchAll">전체보기</a></h5>
	</div>
	<div class="col-md-12 m-2">
		<form class="form-inline justify-content-end" action="/project/admin">
			<input type="hidden" name="cmd" value="search"> 
			<input type="hidden" name="page" value="0"> 
			<input class="form-control mr-sm-2" name="keyword" type="text" placeholder="Search">
			<button class="btn btn-danger" type="submit">검색</button>
		</form>
	</div><br/><br/>
	
	
	<div class="row text-center">
		<c:forEach var="gameInfo" items="${gameInfos}">
			<div class="col-lg-3 col-md-6 mb-3">
				<div class="card h-70" id="card__div__free">
					<a href="/project/admin?cmd=detailsearch&id=${gameInfo.id}" class="btn btn-primary stretched-link">
					<img class="card-img-top" src="${gameInfo.image}" alt="" width="100%" height="280px"></a>
					<div class="card-body">
						<p class="card-text">${gameInfo.gamename}<p>
						<h5 class="card-title">${gameInfo.price}</h5>
					</div>
				</div>
				<input type="hidden" id="id" name="id" value="${gameInfo.id}">
			</div>
		</c:forEach>

	</div>
	
	<div class="row text-center">
		<c:forEach var="AllGameInfo" items="${AllGameInfos}">
			<div class="col-lg-3 col-md-6 mb-3">
				<div class="card h-70" id="card__div__free">
					<a href="/project/admin?cmd=detailsearch&id=${AllGameInfo.id}" class="btn btn-primary stretched-link">
					<img class="card-img-top" src="${AllGameInfo.image}" alt="" width="100%" height="280px"></a>
					<div class="card-body">
						<p class="card-text">${AllGameInfo.gamename}<p>
						<h5 class="card-title">${AllGameInfo.price}</h5>
					</div>
				</div>
				<input type="hidden" id="id" name="id" value="${AllGameInfo.id}">
			</div>
		</c:forEach>

	</div>

</div>

<%@ include file="../include/footer.jsp"%>
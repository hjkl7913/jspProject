<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<div class="container">

	<div class="col-md-12 m-2">
		<form class="form-inline justify-content-end" action="/blog/board">
			<input type="hidden" name="cmd" value="search"> 
			<input type="hidden" name="page" value="0"> 
			<input class="form-control mr-sm-2" name="keyword" type="text" placeholder="Search">
			<button class="btn btn-danger" type="submit">검색</button>
		</form>
	</div><br/><br/>
	
	
	<div class="row text-center">
		<c:forEach var="gameInfo" items="${gameInfos}">
			<div class="col-lg-3 col-md-6 mb-3">
				<div class="card h-70">
					<a href="/project/admin?cmd=detailsearch&id=${gameInfo.id}" class="btn btn-primary stretched-link">
					<img class="card-img-top" src="${gameInfo.image}" alt="" width="200px" height="200px"></a>
					<div class="card-body">
						<h4 class="card-title">${gameInfo.gamename}</h4>
						<p class="card-text">${gameInfo.price}</p>
					</div>
				</div>
				<input type="hidden" id="id" name="id" value="${gameInfo.id}">
			</div>
		</c:forEach>

	</div>

</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<br />
<br />
<br />
<div class="container">
	<div class="col-lg-12">
		<p>새소식</p>
	</div>
	<c:forEach var="gameNews" items="${gameNewss}">

			<div class="col-lg-12">
				<div style="background-color: #202020">
					<div class="col-lg-12" id="news__page">
						<br />
						<h5><a href="/project/home?cmd=detail&id=${gameNews.gameId}">${gameNews.content}</a></h5>
					</div>
					<div class="col-lg-12" id="news__page">
						<p>
							<a href="/project/home?cmd=detail&id=${gameNews.gameId}"><img src="image/newsimage.png">에픽게임즈 • ${gameNews.timeAgo}</a>
						</p>
						
					</div>
				</div>

			</div>

		<input type="hidden" name="gameId" value="${gameNews.gameId}">
		<input type="hidden" name="id" value="${gameNews.id}">

		<div class="col-lg-12">
			<a href="/project/home?cmd=detail&id=${gameNews.gameId}"><img style="width: 100%" src="${gameNews.image}" /></a>
		</div>
		<br />

	</c:forEach>
</div>

<%@ include file="../include/footer.jsp"%>
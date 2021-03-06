<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>



<div class="container" style="background-color: white;">
	<br />
	<br />
	<br />
	<br />
	<h2 style="color: black;">게임정보</h2>
	<br />
	<br />

	
		<div class="container col-lg-12">
		<div class="row">
			
			<div class="container col-lg-3">
				<div class="container">

					<div class="search__admin">
						<h5>
							<a href="/project/admin?cmd=newsAdd&id=${detailgameInfo.id}">새소식 추가</a>
						</h5>
					</div>
					&emsp;&emsp;

				</div>
			</div>
			
			<div class="container col-lg-3">
				<div class="container">

					<div class="search__admin">
						<h5>
							<a href="/project/admin?cmd=adminCodeSearchAll">코드 목록 전체 보기</a>
						</h5>
					</div>
					&emsp;&emsp;

				</div>
			</div>

			<div class="container col-lg-3">
				<div class="container">

					<div class="search__admin">
						<h5>
							<a href="/project/admin?cmd=codeAdd&id=${detailgameInfo.id}&gamename=${detailgameInfo.gamename}">게임 코드 추가</a>
						</h5>
					</div>
					&emsp;&emsp;

				</div>
			</div>
		</div>
		
	</div><br /><br />

	<form class="form-inline justify-content-end" action="/project/admin">
		<input type="hidden" name="cmd" value="search"> <input type="hidden" name="page" value="0"> <input class="form-control mr-sm-2" name="keyword" type="text" placeholder="Search">
		<button class="btn btn-danger" type="submit">검색</button>
	</form>
	<br />

	<form action="/project/admin?cmd=update" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col-lg-3">
				<label for="usr">이미지</label>
				<div class="form-group">
					<img id="img__wrap" onerror="this.src='/project/image/logo.png'" width="250px" height="300px" />
				</div>
				<div class="form-group bg-light">

					<input type="file" name="image" id="img__preview" />
				</div>
			</div>
			<div class="col-lg-3">
				<label for="usr">플레이사진1</label>
				<div class="form-group">
					<img id="img__wrap1" onerror="this.src='/project/image/logo.png'" width="250px" height="300px" />
				</div>
				<div class="form-group bg-light">

					<input type="file" name="gamePlayImage1" id="img__preview1" />
				</div>
			</div>
			<div class="col-lg-3">
				<label for="usr">플레이사진2</label>
				<div class="form-group">
					<img id="img__wrap2" onerror="this.src='/project/image/logo.png'" width="250px" height="300px" />
				</div>
				<div class="form-group bg-light">

					<input type="file" name="gamePlayImage2" id="img__preview2" />
				</div>
			</div>
			<div class="col-lg-3">
				<label for="usr">플레이사진3</label>
				<div class="form-group">
					<img id="img__wrap3" onerror="this.src='/project/image/logo.png'" width="250px" height="300px" />
				</div>
				<div class="form-group bg-light">

					<input type="file" name="gamePlayImage3" id="img__preview3" />
				</div>
			</div>

			<div class="col-lg-3">
				<label for="usr">콘텐트 이미지</label>
				<div class="form-group">
					<img id="img__wrap4" onerror="this.src='/project/image/logo.png'" width="250px" height="200px" />
				</div>
				<div class="form-group bg-light">

					<input type="file" name="contentImage" id="img__preview4" />
				</div>
			</div>

		</div>
		<div class="form-group">
			<label for="comment">상세페이지 게임 설명</label>
			<textarea class="form-control" rows="5" id="content" name="content">${detailgameInfo.content}</textarea>
		</div>

		<input type="hidden" name="buyCount" value="${detailgameInfo.buyCount}">

		<div class="form-group">
			<label for="usr">Movie</label> <input type="text" class="form-control" id="movie" name="movie" value="${detailgameInfo.movie }">
		</div>
		<div class="form-group">
			<label for="usr">Gamename</label> <input type="text" class="form-control" id="gamename" name="gamename" value="${detailgameInfo.gamename}">
		</div>
		<div class="form-group">
			<label for="usr">price</label> <input type="text" class="form-control" id="price" name="price" value="${detailgameInfo.price}">
		</div>
		<div class="form-group">
			<label for="usr">Developer</label> <input type="text" class="form-control" id="developer" name="developer" value="${detailgameInfo.developer}">
		</div>
		<div class="form-group">
			<label for="usr">Publisher</label> <input type="text" class="form-control" id="publisher" name="publisher" value="${detailgameInfo.publisher}">
		</div>
		<div class="form-group">
			<label for="usr">Tags</label> <input type="text" class="form-control" id="tags" name="tags" value="${detailgameInfo.tags}">
		</div>
		<div class="form-group">
			<label for="usr">Rating</label> <input type="text" class="form-control" id="rating" name="rating" value="${detailgameInfo.rating}">
		</div>
		<div class="form-group">
			<label for="usr">Releasedate</label> <input type="text" class="form-control" id="releasedate" name="releasedate" value="${detailgameInfo.releasedate}">
		</div>
		<div class="form-group">
			<label for="usr">Platform</label> <input type="text" class="form-control" id="platform" name="platform" value="${detailgameInfo.platform}">
		</div>
		<div class="form-group">
			<label for="usr">FreeDown</label> <input type="text" class="form-control" id="freedown" name="freedown" value="${detailgameInfo.freeDown}">
		</div>
		<div class="form-group">
			<label for="comment">Explanation</label>
			<textarea class="form-control" rows="5" id="explanation" name="explanation">${detailgameInfo.explanation}</textarea>
		</div>



		<h2 style="color: black;">최소사양</h2>
		<div class="form-group">
			<label for="usr">OS</label> <input type="text" class="form-control" id="minos" name="minos" value="${detailgameInfo.minOS}">
		</div>
		<div class="form-group">
			<label for="usr">Processor</label> <input type="text" class="form-control" id="minprocessor" name="minprocessor" value="${detailgameInfo.minProcessor}">
		</div>
		<div class="form-group">
			<label for="usr">Memory</label> <input type="text" class="form-control" id="minmemory" name="minmemory" value="${detailgameInfo.minMemory}">
		</div>
		<div class="form-group">
			<label for="usr">Graphics</label> <input type="text" class="form-control" id="mingraphics" name="mingraphics" value="${detailgameInfo.minGraphics}">
		</div>
		<div class="form-group">
			<label for="usr">DirectX</label> <input type="text" class="form-control" id="mindirectX" name="mindirectX" value="${detailgameInfo.minDirectX}">
		</div>
		<div class="form-group">
			<label for="usr">Storage</label> <input type="text" class="form-control" id="minstorage" name="minstorage" value="${detailgameInfo.minStorage}">
		</div>

		<h2 style="color: black;">권장사양</h2>
		<div class="form-group">
			<label for="usr">OS</label> <input type="text" class="form-control" id="recomos" name="recomos" value="${detailgameInfo.recomOS}">
		</div>
		<div class="form-group">
			<label for="usr">Processor</label> <input type="text" class="form-control" id="recomprocessor" name="recomprocessor" value="${detailgameInfo.recomProcessor}">
		</div>
		<div class="form-group">
			<label for="usr">Memory</label> <input type="text" class="form-control" id="recommemory" name="recommemory" value="${detailgameInfo.recomMemory}">
		</div>
		<div class="form-group">
			<label for="usr">Graphics</label> <input type="text" class="form-control" id="recomgraphics" name="recomgraphics" value="${detailgameInfo.recomGraphics}">
		</div>
		<div class="form-group">
			<label for="usr">DirectX</label> <input type="text" class="form-control" id="recomdirectX" name="recomdirectX" value="${detailgameInfo.recomDirectX}">
		</div>
		<div class="form-group">
			<label for="usr">Storage</label> <input type="text" class="form-control" id="recomstorage" name="recomstorage" value="${detailgameInfo.recomStorage}">
		</div>
		<div class="form-group">
			<input type="hidden" class="form-control" id="id" name="id" value="${detailgameInfo.id}">
		</div>

		<h4 style="color: black;">지원 언어</h4>
		<div class="form-group">

			<textarea class="form-control" rows="5" id="language" name="language">${detailgameInfo.languagesSupported}</textarea>
		</div>
		<div class="d-flex justify-content-end">
			<button type="submit" class="btn btn-warning">수정</button>
			&nbsp;&nbsp;
		</div>
	</form>
	<button class="btn btn-danger" onclick="deleteById(${detailgameInfo.id})">삭제</button>
	<br />
	<br />
	<br />
	<br />
</div>

<br />
<br />
<br />
<script src="/project/js/imgPreview.js"></script>
<script src="/project/js/delete.js"></script>
<%@ include file="../include/footer.jsp"%>
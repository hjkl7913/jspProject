<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

	
	
	<div class="container" style="background-color: white;">
		<br/><br/><br/><br/>
		<h2>게임정보</h2><br/>
		
		<form class="form-inline justify-content-end" action="/project/admin">
			<input type="hidden" name="cmd" value="search"> 
			<input type="hidden" name="page" value="0"> 
			<input class="form-control mr-sm-2" name="keyword" type="text" placeholder="Search">
			<button class="btn btn-danger" type="submit">검색</button>
		</form>
		
		<form action="/project/admin?cmd=adminProc" method="post">
		<label for="usr">이미지</label>
			<div class="form-group">
				<img id="img__wrap" src="/project/images/EpicGamesLogo.png" width="250px" height="200px" />
			</div>
			<div class="form-group bg-light">
			
				<input type="file" name="image" id="image" />
			</div>
			<div class="form-group">
				<label for="usr">Movie</label> <input type="text" class="form-control" id="movie" name="movie">
			</div>
			<div class="form-group">
				<label for="usr">Gamename</label> <input type="text" class="form-control" id="gamename" name="gamename">
			</div>
			<div class="form-group">
				<label for="usr">price</label> <input type="text" class="form-control" id="price" name="price">
			</div>
			<div class="form-group">
				<label for="usr">Developer</label> <input type="text" class="form-control" id="developer" name="developer">
			</div>
			<div class="form-group">
				<label for="usr">Publisher</label> <input type="text" class="form-control" id="publisher" name="publisher">
			</div>
			<div class="form-group">
				<label for="usr">Tags</label> <input type="text" class="form-control" id="tags" name="tags">
			</div>
			<div class="form-group">
				<label for="usr">Rating</label> <input type="text" class="form-control" id="rating" name="rating">
			</div>
			<div class="form-group">
				<label for="usr">Releasedate</label> <input type="text" class="form-control" id="releasedate" name="releasedate">
			</div>
			<div class="form-group">
				<label for="usr">Platform</label> <input type="text" class="form-control" id="platform" name="platform">
			</div>
			<div class="form-group">
				<label for="comment">Explanation</label>
				<textarea class="form-control" rows="5" id="explanation" name="explanation"></textarea>
			</div>

			<h2>최소사양</h2>
			<div class="form-group">
				<label for="usr">OS</label> <input type="text" class="form-control" id="minos" name="minos">
			</div>
			<div class="form-group">
				<label for="usr">Processor</label> <input type="text" class="form-control" id="minprocessor" name="minprocessor">
			</div>
			<div class="form-group">
				<label for="usr">Memory</label> <input type="text" class="form-control" id="minmemory" name="minmemory">
			</div>
			<div class="form-group">
				<label for="usr">Graphics</label> <input type="text" class="form-control" id="mingraphics" name="mingraphics">
			</div>
			<div class="form-group">
				<label for="usr">DirectX</label> <input type="text" class="form-control" id="mindirectX" name="mindirectX">
			</div>
			<div class="form-group">
				<label for="usr">Storage</label> <input type="text" class="form-control" id="minstorage" name="minstorage">
			</div>

			<h2>권장사양</h2>
			<div class="form-group">
				<label for="usr">OS</label> <input type="text" class="form-control" id="recomos" name="recomos">
			</div>
			<div class="form-group">
				<label for="usr">Processor</label> <input type="text" class="form-control" id="recomprocessor" name="recomprocessor">
			</div>
			<div class="form-group">
				<label for="usr">Memory</label> <input type="text" class="form-control" id="recommemory" name="recommemory">
			</div>
			<div class="form-group">
				<label for="usr">Graphics</label> <input type="text" class="form-control" id="recomgraphics" name="recomgraphics">
			</div>
			<div class="form-group">
				<label for="usr">DirectX</label> <input type="text" class="form-control" id="recomdirectX" name="recomdirectX">
			</div>
			<div class="form-group">
				<label for="usr">Storage</label> <input type="text" class="form-control" id="recomstorage" name="recomstorage">
			</div>

			<h4>지원 언어</h4>
			<div class="form-group">
				
				<textarea class="form-control" rows="5" id="language" name="language"></textarea>
			</div>
			<div class="d-flex justify-content-end">
			<button type="submit" class="btn btn-primary">Submit</button>
			</div><br/><br/><br/><br/>
		</form>
	</div>
	
	<br/><br/><br/>

</body>
</html>
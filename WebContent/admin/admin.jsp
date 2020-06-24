<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>


	<h2>관리자 모드</h2>
	<p>ㅎㅎ</p>
	<div class="container">
		<form action="/action_page.php">
			<div class="form-group">
				<label for="usr">Image</label> <input type="text" class="form-control" id="price" name="price">
			</div>
			<div class="form-group">
				<label for="usr">Movie</label> <input type="text" class="form-control" id="price" name="price">
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
				<label for="usr">OS</label> <input type="text" class="form-control" id="os" name="os">
			</div>
			<div class="form-group">
				<label for="usr">Processor</label> <input type="text" class="form-control" id="processor" name="processor">
			</div>
			<div class="form-group">
				<label for="usr">Memory</label> <input type="text" class="form-control" id="memory" name="memory">
			</div>
			<div class="form-group">
				<label for="usr">Graphics</label> <input type="text" class="form-control" id="graphics" name="graphics">
			</div>
			<div class="form-group">
				<label for="usr">DirectX</label> <input type="text" class="form-control" id="directX" name="directX">
			</div>
			<div class="form-group">
				<label for="usr">Storage</label> <input type="text" class="form-control" id="storage" name="storage">
			</div>

			<h2>권장사양</h2>
			<div class="form-group">
				<label for="usr">OS</label> <input type="text" class="form-control" id="os" name="os">
			</div>
			<div class="form-group">
				<label for="usr">Processor</label> <input type="text" class="form-control" id="processor" name="processor">
			</div>
			<div class="form-group">
				<label for="usr">Memory</label> <input type="text" class="form-control" id="memory" name="memory">
			</div>
			<div class="form-group">
				<label for="usr">Graphics</label> <input type="text" class="form-control" id="graphics" name="graphics">
			</div>
			<div class="form-group">
				<label for="usr">DirectX</label> <input type="text" class="form-control" id="directX" name="directX">
			</div>
			<div class="form-group">
				<label for="usr">Storage</label> <input type="text" class="form-control" id="storage" name="storage">
			</div>

			<h4>지원 언어</h4>
			<div class="form-group">
				<label for="comment">지원 언어</label>
				<textarea class="form-control" rows="5" id="language" name="language"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>
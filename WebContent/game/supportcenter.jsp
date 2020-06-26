<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/heroic-features.css" rel="stylesheet">

<style type="text/css">
.container-2{
  vertical-align: middle;
  white-space: nowrap;
  position: relative;
}

.container-2 input#search{
  width: 600px;
  height: 45px;
  background: white;
  border: none;
  font-size: 10pt;
  float: left;
  color: black;
  padding-left: 15px;

}

.container-2 input#search::-webkit-input-placeholder {
   color: #65737e;
}
 
.container-2 input#search:-moz-placeholder { /* Firefox 18- */
   color: #65737e;  
}
 
.container-2 input#search::-moz-placeholder {  /* Firefox 19+ */
   color: #65737e;  
}
 
.container-2 input#search:-ms-input-placeholder {  
   color: #65737e;  
  
}

input.img-button2 {
        background: url( "/project/image/search2.png" ) no-repeat;
        border: none;
        float: left;
        width: 45px;
        height: 45px;
        cursor: pointer;
}
</style>
</head>
<body>

	<div class="container">
	<div class="box " >
		<div class="container-2">
			<span class="icon"><i class="fa fa-search"></i></span>
			<div class="row">
				<input type="button" class="img-button2"><input type="search" id="search" placeholder="검색" />
			</div>
		</div>
	</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container-1{
  width: 300px;
  vertical-align: middle;
  white-space: nowrap;
  position: relative;
}

.container-1 input#search{
  width: 250px;
  height: 45px;
  background: #2b303b;
  border: none;
  font-size: 10pt;
  float: left;
  color: white;
  padding-left: 45px;

}

.container-1 input#search::-webkit-input-placeholder {
   color: #65737e;
}
 
.container-1 input#search:-moz-placeholder { /* Firefox 18- */
   color: #65737e;  
}
 
.container-1 input#search::-moz-placeholder {  /* Firefox 19+ */
   color: #65737e;  
}
 
.container-1 input#search:-ms-input-placeholder {  
   color: #65737e;  
  
}

input.img-button {
        background: url( "image/search.png" ) no-repeat;
        border: none;
        width: 45px;
        height: 45px;
        cursor: pointer;
      }
</style>
</head>

<body>

<div class="box">
  <div class="container-1">
      <span class="icon"><i class="fa fa-search"></i></span>
     	<div class="row">
      <input type="button" class="img-button"><input type="search" id="search" placeholder="검색" />
  </div>
  </div>
</div>
</body>
</html>
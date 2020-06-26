<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Epic Games</title>
<meta charset="utf-8">
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
<link href="css/style.css" rel="stylesheet">

<title>Heroic Features - Start Bootstrap Template</title>

</head>
<body style="background-color: black">
	<nav class="navbar navbar-expand-lg navbar-default fixed-top">
			<a class="navbar-brand" href="#"><img alt="" src="/project/image/logo3.png" width="28" height="28"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>


			<div class="collapse navbar-collapse" id="navbarResponsive">
				<a class="navbar-brand" style="font-size: 18px" href="/project/home?cmd=home">스토어</a> <a class="navbar-brand" style="font-size: 18px" href="#">새 소식</a> <a class="navbar-brand" style="font-size: 18px" href="/project/home?cmd=question">자주 묻는 질문</a> <a class="navbar-brand" style="font-size: 18px" href="#">지원센터</a>
				<ul class="navbar-nav ml-auto">
					<c:choose>
						<c:when test="${empty sessionScope.principal}">
							<li class="nav-item active"><a class="nav-link" href="/project/user?cmd=login">로그인</a></li>
							<li class="nav-item"><a class="nav-link" href="/project/user?cmd=join">회원가입</a></li>
						</c:when>
						<c:when test="${sessionScope.principal.userRole == 'ADMIN'}">
							<li class="nav-item"><a class="nav-link" href="/project/admin?cmd=admin">관리자페이지</a></li>
							<li class="nav-item"><a class="nav-link" href="/project/user?cmd=logout">로그아웃</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="/project/user?cmd=logout">로그아웃</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>

	</nav>

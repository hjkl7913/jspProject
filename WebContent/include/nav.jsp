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
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/heroic-features.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<title>Heroic Features - Start Bootstrap Template</title>

</head>
<body style="background-color: black">
	<nav class="navbar navbar-expand-lg navbar-default fixed-top" style="height: 52px">
		<a class="navbar-brand" href="/project/home?cmd=home" id="nav__logo1"><img alt="" src="/project/image/logo3.png" width="33" height="38"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"><img src="/project/image/logo.png"></span>
		</button>


		<div class="collapse navbar-collapse" id="navbarResponsive" style="background-color: #252525; ">
			<a class="navbar-brand" style="font-size: 13px" href="/project/home?cmd=home">스토어</a> &emsp; <a class="navbar-brand" style="font-size: 13px" href="/project/home?cmd=news">새 소식</a> &emsp; <a
				class="navbar-brand" style="font-size: 13px" href="/project/home?cmd=question">자주 묻는 질문</a> &emsp; <a class="navbar-brand" style="font-size: 13px" href="/project/home?cmd=spCenter">지원센터</a>
			<ul class="navbar-nav ml-auto">
				<c:choose>
					<c:when test="${empty sessionScope.principal}">
						<li class="nav-item active"><a class="nav-link" href="/project/user?cmd=login">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/project/user?cmd=join">회원가입</a></li>
						<a class="nav-link" href="#" id="nav__a__button1"><button type="button"> 에픽게임즈 받기</button></a>
					</c:when>
					<c:when test="${sessionScope.principal.userRole == 'ADMIN'}">
						<ul id="main-menu">
								<li><a href="#">관리자페이지</a>
									<ul id="sub-menu">
										<li><a href="/project/admin?cmd=admin" aria-label="subemnu">게임관리</a></li>
										<li><a href="/project/admin?cmd=answer" aria-label="subemnu">답변하기</a></li>
										<li><a href="/project/user?cmd=logout" aria-label="subemnu">로그아웃</a></li>
									</ul></li>

							</ul>
						
					</c:when>
					<c:otherwise>
						
							<ul id="main-menu">
								<li><a href="#">${sessionScope.principal.displayName}</a>
									<ul id="sub-menu">
										<li><a href="/project/user?cmd=account&id=${sessionScope.principal.id}" aria-label="subemnu">계정</a></li>
										<li><a href="/project/user?cmd=homeCode&id=${sessionScope.principal.id}" aria-label="subemnu">코드사용</a></li>
										<li><a href="/project/user?cmd=accountCart&id=${sessionScope.principal.id}" aria-label="subemnu">위시리스트</a></li>
										<li><a href="/project/user?cmd=logout" aria-label="subemnu">로그아웃</a></li>
									</ul></li>

							</ul>
						
						<a class="nav-link"  href="/project/image/epicgamesinstall.msi" id="nav__a__button" download><button type="button" > 에픽게임즈 받기</button></a>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>

	</nav>
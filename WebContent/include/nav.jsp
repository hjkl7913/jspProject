<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand/logo -->
		<a class="navbar-brand" href="#"><img alt="" src="/project/images/EpicGamesLogo.png" width="50" height="50"></a>
		<div class="justify-content-between collapse navbar-collapse" id="collapsibleNavbar">
			<!-- Links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#" style="text-decoration: none;">스토어</a></li>
				<li class="nav-item"><a class="nav-link" href="#" style="text-decoration: none;">새 소식</a></li>
				<li class="nav-item"><a class="nav-link" href="#" style="text-decoration: none;">자주 묻는 질문</a></li>
				<li class="nav-item"><a class="nav-link" href="#" style="text-decoration: none;">지원센터</a></li>
			</ul>
			<ul class="navbar-nav">
				<c:choose>
					<c:when test="${empty sessionScope.principal}">
						<li class="nav-item"><a class="nav-link" href="/project/user?cmd=login" style="text-decoration: none;">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/project/user?cmd=join" style="text-decoration: none;">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="/project/user?cmd=logout" style="text-decoration: none;">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
	<br>
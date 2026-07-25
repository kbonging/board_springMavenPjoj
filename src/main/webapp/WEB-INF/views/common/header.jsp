<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/message.jsp"%>

<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Spring Board</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Common CSS -->
<link rel="stylesheet" href="/css/common.css">

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

		<div class="container">

			<a class="navbar-brand fw-bold" href="/board/list">
				Spring Board
			</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbar">

				<span class="navbar-toggler-icon"></span>

			</button>

			<div class="collapse navbar-collapse" id="navbar">

				<ul class="navbar-nav me-auto">

					<li class="nav-item">
						<a class="nav-link" href="/board/list">게시판</a>
					</li>

				</ul>

				<ul class="navbar-nav">
					<c:choose>
						<c:when test="${empty sessionScope.loginMember}">
							<li class="nav-item">
								<a class="nav-link" href="/member/login">로그인</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/member/join">회원가입</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="nav-item">
								<span class="navbar-text me-3">
									${sessionScope.loginMember.name}님 환영합니다.
								</span>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/member/logout">로그아웃</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>

			</div>

		</div>

	</nav>

	<!-- Content -->
	<div class="container mt-4">
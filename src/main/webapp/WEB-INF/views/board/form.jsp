<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<c:choose>
	<c:when test="${empty board.boardId}">
		<c:url var="actionUrl" value="/board/write" />
		<c:set var="buttonText" value="등록" />
		<c:set var="pageTitle" value="게시글 등록" />
	</c:when>
	<c:otherwise>
		<c:url var="actionUrl" value="/board/update" />
		<c:set var="buttonText" value="수정" />
		<c:set var="pageTitle" value="게시글 수정" />
	</c:otherwise>
</c:choose>

<h2>${pageTitle}</h2>

<form action="${actionUrl}" method="post">

	<c:if test="${not empty board.boardId}">
		<input type="hidden" name="boardId" value="${board.boardId}">
	</c:if>
	<table border="1" cellpadding="5">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${board.title}"
				style="width: 300px;"></td>
		</tr>

		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="10" cols="60">${board.content}</textarea>
			</td>
		</tr>
	</table>

	<br>

	<button type="submit">${buttonText}</button>

	<button type="button" onclick="location.href='/board/list'">목록</button>

</form>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>


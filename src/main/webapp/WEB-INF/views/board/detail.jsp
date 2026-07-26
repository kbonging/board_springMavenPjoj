<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<script>
$(document).ready(function(){
	
	$("#btnUpdate").click(function(){
		location.href = "/board/form?boardId=${board.boardId}";
	});

	$("#btnDelete").click(function(){
	    if(confirm("삭제하시겠습니까?")){
	        $("#deleteForm").submit();
	    }
	});
	
	
});
</script>

<h2 class="mb-4">게시글 상세</h2>

<div class="card">

	<div class="card-body">
		<table class="table">
			<tr>
				<th width="20%">제목</th>

				<td>${board.title}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writerName}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.viewCnt}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.createdAt.toString().substring(0,10)}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${board.content}</td>
			</tr>
		</table>

		<form id="deleteForm" action="/board/delete" method="post">
			<input type="hidden" name="boardId" value="${board.boardId}">
		</form>

		<div class="text-end">
			<a href="/board/list" class="btn btn-secondary"> 목록 </a>
			
			<c:if test="${not empty sessionScope.loginMember and sessionScope.loginMember.memberId == board.writer}">
				<button id="btnUpdate" class="btn btn-warning">수정</button>
				<button id="btnDelete" class="btn btn-danger">삭제</button>
			</c:if>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
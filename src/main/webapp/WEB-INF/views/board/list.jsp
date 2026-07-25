<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<!-- Page CSS -->
<link rel="stylesheet" href="/resources/css/common.css">

<div class="d-flex justify-content-between align-items-center mb-4">

    <h2 class="mb-0">게시판 목록</h2>

    <a href="/board/form" class="btn btn-primary">
        글쓰기
    </a>

</div>

<div class="card">

    <div class="card-body">

        <table class="table table-striped table-hover align-middle">
            <thead class="table-dark">
                <tr>
                    <th style="width: 10%;">번호</th>
                    <th>제목</th>
                    <th style="width: 15%;">작성자</th>
                    <th style="width: 10%;">조회수</th>
                    <th style="width: 20%;">작성일</th>
                </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${empty boardList}">
                    <tr>
                        <td colspan="5" class="text-center">
                            등록된 게시글이 없습니다.
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="board" items="${boardList}">
                        <tr>
                            <td>${board.boardId}</td>
                            <td class="text-start">
                                <a href="/board/detail/${board.boardId}"
                                   class="text-decoration-none">
                                    ${board.title}
                                </a>
                            </td>
                            <td>${board.writerName}</td>
                            <td>${board.viewCnt}</td>
                            <td>${board.createdAt.toString().substring(0, 10)}</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>

</div>

<!-- Pagination -->
<nav class="mt-4">

    <ul class="pagination justify-content-center">

        <li class="page-item disabled">
            <a class="page-link" href="#">이전</a>
        </li>

        <li class="page-item active">
            <a class="page-link" href="#">1</a>
        </li>

        <li class="page-item disabled">
            <a class="page-link" href="#">다음</a>
        </li>

    </ul>

</nav>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>

<!-- Page JS -->
<script src="/js/board.js"></script>


<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<h2 class="mb-4">로그인</h2>

<div class="row justify-content-center">
    <div class="col-md-5">

        <div class="card">
            <div class="card-body">

                <form action="/member/login" method="post">
					<div class="mb-3">
					    <label class="form-label">아이디</label>
					    <input type="text" name="loginId" class="form-control" placeholder="아이디를 입력하세요." required>
					</div>
					<div class="mb-3">
					    <label class="form-label">비밀번호</label>
					    <input type="password" name="password" class="form-control" placeholder="비밀번호를 입력하세요." required>
					</div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">로그인</button>
                    </div>					
                </form>

            </div>
        </div>

    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
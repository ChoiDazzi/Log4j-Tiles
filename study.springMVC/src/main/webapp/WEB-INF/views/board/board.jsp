<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div>
		<h4 class="fw-bold py-3 mb-3 mt-5" id="boardNm" data-id="<c:out value="${boardId}"/>">
			<span class="text-muted fw-light">Boards/</span>
			<c:out value="${boardNm}" />
		</h4>
	</div>

	<div class="row justify-content-between mb-3">
		<div class="col-md-6">
			<form action="/board/board/${boardId}" method="get" class="row g-2 align-items-center">
				<div class="col-md-2">
					<select name="type" class="form-select" id="exampleFormControlSelect1" aria-label="Default select example">
						<option value="" selected="">전체</option>
						<option value="postTtl">제목</option>
						<option value="postCnt">내용</option>
						<option value="userNm">작성자</option>
					</select>
				</div>
				<div class="col-md-6">
					<div class="input-group input-group-merge">
						<span class="input-group-text" id="basic-addon-search31"><i class="bx bx-search"></i></span>
						<input type="text" name="keyword" class="form-control" placeholder="Search..." aria-label="Search..." aria-describedby="basic-addon-search31">
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-2 text-end">
			<button id="registerPost" type="button" class="btn btn-primary">게시글 등록</button>
		</div>
	</div>


	<div class="card">
		<div class="table-responsive text-nowrap">
			<table class="table table-hover">
				<thead>
				<tr class="text-center">
					<th>no</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>Actions</th>
				</tr>
				</thead>
				<tbody class="table-border-bottom-0">
				<c:forEach items="${posts}" var="post" varStatus="status">
					<tr class="text-center">
						<td class="col-1"><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong><c:out value="${(pageInfo.pageNum-1) * 10 + status.count}" /></strong></td>
						<td  class="col-5">
							<a href="/post/detailPost/<c:out value="${boardId}"/>/<c:out value="${post.postId}"/>">
								<c:out value="${post.postTtl}" />
							</a>
						</td>
						<td class="col-2"><c:out value="${post.userNm}" /></td>
						<td class="col-4"><c:out value="${post.rgstDt}" /></td>
						<td>
							<div class="dropdown">
								<button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
									<i class="bx bx-dots-vertical-rounded"></i>
								</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="javascript:void(0);"><i class="bx bx-edit-alt me-1"></i> Edit</a>
									<a class="dropdown-item" href="javascript:void(0);"><i class="bx bx-trash me-1"></i> Delete</a>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="demo-inline-spacing">
		<nav aria-label="Page navigation" class="list-unstyled">
			<ul class="pagination justify-content-center">
				<li class="page-item prev">
					<c:if test="${pageInfo.hasPreviousPage}">
						<a class="page-link" href="/board/board/${boardId}?pageNum=${pageInfo.prePage}&type=${param.type}&keyword=${param.keyword}"><i class="tf-icon bx bx-chevron-left"></i></a>
					</c:if>
				</li>

				<c:forEach var="pageNum" begin="1" end="${pageInfo.pages}">
					<c:choose>
						<c:when test="${pageNum eq pageInfo.pageNum}">
							<li class="page-item active">
								<span class="page-link">${pageNum}</span>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="?pageNum=${pageNum}&type=${param.type}&keyword=${param.keyword}" >${pageNum}</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<li class="page-item next">
					<c:if test="${pageInfo.hasNextPage}">
						<a class="page-link" href="/board/board/${boardId}?pageNum=${pageInfo.nextPage}&type=${param.type}&keyword=${param.keyword}"><i class="tf-icon bx bx-chevron-right"></i></a>
					</c:if>
				</li>
			</ul>
		</nav>
	</div>



</div>

<script src="${CONTEXT_PATH}/resources/js/board.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/resources/css/board.css">
<div class="wrapper">
    <div class="header-content">
        <h3 id="boardNm" data-id="${boardId}">${boardNm}</h3>
        <button id="registerPost" type="button">게시글 등록</button>
    </div>
    <table border="1" class="tb tb_board">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>등록날짜</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${posts}" var="post" varStatus="status">
                <tr>
                    <td>${(pageInfo.pageNum-1) * 10 + status.count}</td>
                    <td><a href="/board/detailPost/<c:out value="${boardId}"/>/<c:out value="${post.postId}"/>">${post.postTtl}</a></td>
                    <td>${post.userNm}</td>
                    <td>${post.rgstDt}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="pagenation-content">
        <nav class="pagenation">
            <li>
                <c:if test="${pageInfo.hasPreviousPage}">
                    <a href="/board/board/${boardId}?pageNum=${pageInfo.prePage}" class="pageBtn pageTextBtn">Prev</a>
                </c:if>
            </li>

            <c:forEach var="pageNum" begin="1" end="${pageInfo.pages}">
                <li>
                    <c:choose>
                        <c:when test="${pageNum eq pageInfo.pageNum}">
                            <span class="pageBtn active">${pageNum}</span>
                        </c:when>
                        <c:otherwise>
                            <a href="?pageNum=${pageNum}" class="pageBtn">${pageNum}</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </c:forEach>

            <li>
                <c:if test="${pageInfo.hasNextPage}">
                    <a href="/board/board/${boardId}?pageNum=${pageInfo.nextPage}" class="pageBtn pageTextBtn">Next</a>
                </c:if>
            </li>
        </nav>
    </div>
</div>

<script src="/resources/js/board.js"></script>
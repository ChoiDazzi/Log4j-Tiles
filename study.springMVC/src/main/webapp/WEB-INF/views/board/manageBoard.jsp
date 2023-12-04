<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>게시판 관리</h3>
<nav>
    <ul>
        <c:forEach items="${navItems}" var="navItem">
            <li style="list-style:none;">
            	<input type="text" value="${navItem.boardNm}"/>
            	<button onClick="fn_modifyBoard('<c:out value="${navItem.boardId}"/>')" type="button" class="modifyBtn" data-id='<c:out value="${navItem.boardId}"/>'>수정</button>
            	<button type="button" class="deleteBtn" data-id='<c:out value="${navItem.boardId}"/>'>삭제</button>
            </li>
        </c:forEach>
    </ul>
</nav>
<form action="/board/insertBoard" method="post">
	<input type="text" name="boardNm"/>
	<button type="submit">게시판 등록</button>
</form>

<script src="${CONTEXT_PATH}/resources/js/manageBoard.js"></script>
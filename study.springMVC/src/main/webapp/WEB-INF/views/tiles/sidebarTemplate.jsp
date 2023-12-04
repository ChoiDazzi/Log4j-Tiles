<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="SideBar">
<span>Side</span>
<nav>
    <ul>
        <c:forEach items="${navItems}" var="navItem">
            <li>
            	<a href="/board/board/${navItem.boardId}">${navItem.boardNm}</a>
            </li>
            
        </c:forEach>
    </ul>
</nav>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<button type="button" id="manageBoard">게시판 관리</button>
</sec:authorize>
</div>

<script src="${CONTEXT_PATH}/resources/js/sideBar.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="SideBar">
<span>Side</span>
<nav>
    <ul>
        <c:forEach items="${navItems}" var="navItem">
            <li><a href="/board/board/${navItem.boardId}">${navItem.boardNm}</a></li>
        </c:forEach>
    </ul>
</nav>
</div>
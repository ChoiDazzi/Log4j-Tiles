<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="/signIn" method="post">
	ID: <input type="text" name="userId" id="userId"/>
	NAME: <input type="text" name="userNm" id="userNm"/>
	PW: <input type="password" name="userPw" id="userPw"/>
	
	<c:forEach items="${auths}" var="auth">
		<input type="radio" name="authId" value="<c:out value="${auth.roleNm}"/>"/>
	</c:forEach>
	<button type="submit">로그인</button>
</form>
    
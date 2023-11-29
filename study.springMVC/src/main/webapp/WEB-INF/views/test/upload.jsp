<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p>사용자 이름 : <c:out value="${param.userName}"/></p>
<p>서버에 업로드된 파일 이름 : <c:out value="${result.convFileNm}"/></p>
<p>유저가 업로드한 파일 이름 : <c:out value="${result.orgnFileNm}"/></p>
<p>파일 크기 : <c:out value="${result.fileSize}"/></p>

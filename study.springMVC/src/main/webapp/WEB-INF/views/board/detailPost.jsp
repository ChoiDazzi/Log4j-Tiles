<%--
  Created by IntelliJ IDEA.
  User: ChoiSeoYeon
  Date: 12/3/23
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${CONTEXT_PATH}/resources/css/registerPost.css">
<c:set var="userId" value="${pageContext.request.userPrincipal.name}" />
<c:set var="postId" value="${postInfo.postId}" />
<div class="wrapper">
    <div class="header-content">
        <h3 id="boardNm" data-id="${boardId}">${boardNm} - 게시글 상세</h3>
        <div class="btn-content">
            <button id="backBtn" type="button">목록으로</button>
            <c:if test="${userId eq postInfo.userId}">
                <div class="before">
                    <button id="modify" type="button">수정하기</button>
                    <button id="deleteBtn" type="submit">삭제하기</button>
                </div>
                <div class="after" style="display: none">
                    <button id="modifyBtn" type="button">저장하기</button>
                    <button id="cancelBtn" type="button">취소</button>
                </div>
            </c:if>
        </div>
    </div>
    <div class="form-content">
        <form id="frm" enctype="multipart/form-data">
            <input type="hidden" value="<c:out value="${postInfo.postId}"/>" name="postId"/>
            <input type="hidden" value="<c:out value="${boardId}"/>" name="boardId"/>
            <table border="1" class="tb tb_register">
                <tr>
                    <td>제목</td>
                    <td colspan="3">
                        <input type="text" name="postTtl" value="<c:out value="${postInfo.postTtl}"/>" readonly />
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td><c:out value="${postInfo.userNm}"/></td>
                    <td>날짜</td>
                    <td><c:out value="${postInfo.rgstDt}"/></td>
                </tr>
                <tr>
                	<td>첨부파일</td>
                	<td colspan="3">
                		<nav>
                			<c:choose>
                				<c:when test="${empty files}">
                				<li style="list-style: none;">첨부파일이 없습니다.</li>
                				</c:when>
                				<c:when test="${not empty files}">
	                				<c:forEach items="${files}" var="file">
			                			<li style="list-style: none;">
			                				<a href='/post/fileDownload/<c:out value="${file.fileId}"/>'>${file.fileOrgNm}</a>
			                				<span style="font-size: 10px;">${file.fileSize} byte</span>
			                				<img alt="" src="<%=request.getContextPath()%>/post/preview?fileId=<c:out value="${file.fileId}"/>">
			                			</li>
		                			</c:forEach>
                				</c:when>
                			</c:choose>
                		</nav>
                	</td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td colspan="3"><textarea name="postCnt" cols="30" rows="10" readonly><c:out value="${postInfo.postCnt}"/></textarea></td>
                </tr>
            </table>
        </form>
    </div>
   <%--  
    <div class="comment-content">
    	<div class="comment-box" style="border: 1px solid gray;">
    		<form action="">
    			<span>작성자</span>
    			<span><c:out value="${postInfo.userNm}"/></span>
    			<textarea rows="" cols="" name="cmntDtl" style="border: 1px solid gray;"></textarea>
    			<button type="button" id="registerComment">등록</button>
    		</form>
    	</div>
    	<div id="comment-body"></div>
    </div> --%>
</div>

<script src="${CONTEXT_PATH}/resources/js/detailPost.js"></script>
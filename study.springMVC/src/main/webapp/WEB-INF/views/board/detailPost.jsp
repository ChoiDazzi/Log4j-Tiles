<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${CONTEXT_PATH}/resources/css/registerPost.css">
<c:set var="userId" value="${pageContext.request.userPrincipal.name}" />
<c:set var="postId" value="${postInfo.postId}" />
    <div>
        <div>
            <h4 class="fw-bold py-3 mb-3 mt-5" id="boardNm" data-id="<c:out value="${boardId}"/>">
            <span class="text-muted fw-normal"> <c:out value="${boardNm}" />/</span>
            게시글 상세
            </h4>
        </div>
        <div class="row flex-nowrap">
            <button id="backBtn" type="button" class="btn btn-outline-info">목록으로</button>
            <c:if test="${userId eq postInfo.userId}">
                <div class="before">
                    <button id="modify" type="button" class="btn btn-info">수정하기</button>
                    <button id="deleteBtn" type="submit" class="btn btn-danger">삭제하기</button>
                </div>
                <div class="after" style="display: none">
                    <button id="modifyBtn" type="button" class="btn btn-primary">저장하기</button>
                    <button id="cancelBtn" type="button" class="btn btn-outline-primary">취소</button>
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

<div>

    <div class="card mb-4">
    <div class="card-header d-flex align-items-center justify-content-between">
        <h5 class="mb-0">게시글 등록</h5>
        <div>
        <button id="backBtn" type="button" class="btn btn-outline-info">목록으로</button>
            <c:if test="${userId eq postInfo.userId}">
                <div class="before">
                    <button id="modify" type="button" class="btn btn-info">수정하기</button>
                    <button id="deleteBtn" type="submit" class="btn btn-danger">삭제하기</button>
                </div>
                <div class="after" style="display: none">
                    <button id="modifyBtn" type="button" class="btn btn-primary">저장하기</button>
                    <button id="cancelBtn" type="button" class="btn btn-outline-primary">취소</button>
                </div>
            </c:if>
        </div>
    </div>
    <div class="card-body">
        <form action="/post/registerPost" id="frm" method="post" enctype="multipart/form-data">
        <input type="hidden" name="boardId" value="${boardId}">
            <input type="hidden" value="<c:out value="${postInfo.postId}"/>" name="postId"/>
            <input type="hidden" value="<c:out value="${boardId}"/>" name="boardId"/>
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="basic-default-title">제목</label>
                <div class="col-sm-11">
                <input type="text" name="postTtl" class="form-control" id="basic-default-title" value="<c:out value="${postInfo.postTtl}"/>" readonly />
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="basic-default-title">작성자</label>
                <div class="col-sm-11">
                    <c:out value="${postInfo.userNm}"/>
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label">날짜</label>
                <div class="col-sm-11">
                ${currentTime}
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="formFileMultiple">파일</label>
                <div class="col-sm-11">
                <div class="input-group input-group-merge">
                    <input class="form-control" name="multiUpload" type="file" id="formFileMultiple" multiple="">
                </div>
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="basic-default-content">내용</label>
                <div class="col-sm-11">
                <textarea cols="30" rows="10" name="postCnt" id="basic-default-content" class="form-control" placeholder="내용을 입력해주세요." aria-label="내용을 입력해주세요."></textarea>
                </div>
            </div>
        </form>
    </div>

<script src="${CONTEXT_PATH}/resources/js/detailPost.js"></script>
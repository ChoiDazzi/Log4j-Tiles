<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${CONTEXT_PATH}/resources/css/registerPost.css">
<c:set var="userId" value="${pageContext.request.userPrincipal.name}" />
<c:set var="postId" value="${postInfo.postId}" />
    <div>
        <div class="row justify-content-between align-items-center mb-3">
        	<div class="col-md-10">
	        	<h4 class="fw-bold py-3 mb-3 mt-5" id="boardNm" data-id="<c:out value="${boardId}"/>">
	            <span class="text-muted fw-normal"> <c:out value="${boardNm}" />/</span>
	            게시글 상세
	            </h4>
        	</div>
        	<button id="backBtn" type="button" class="btn btn-primary col-md-1 h-25 text-center">목록으로</button>
        </div>
    </div>
    <div class="card mb-4">
        <div class="form-content">
            <div class="card-header d-flex align-items-center justify-content-between">
                <h5 class="mb-0">게시글 등록</h5>
                <div>
                
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
                        <input type="text" name="postTtl" class="form-control-plaintext" id="basic-default-title" value="<c:out value="${postInfo.postTtl}"/>" readonly />
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-1 col-form-label" for="basic-default-name">작성자</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control-plaintext" id="basic-default-name" value="<c:out value="${postInfo.userNm}"/>" readonly />
                        </div>
                        <label class="col-sm-1 col-form-label" for="basic-default-date">날짜</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control-plaintext" id="basic-default-date" value="<c:out value="${postInfo.rgstDt}"/>" readonly />
                        </div>
                    </div>
                    <div class="row mb-3 d-none" id="modifyFileDiv">
                        <label class="col-sm-1 col-form-label" for="formFileMultiple">파일</label>
                        <div class="col-sm-11">
                        <div class="input-group input-group-merge">
                            <input class="form-control" name="multiUpload" type="file" id="formFileMultiple" multiple />
                        </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-1 col-form-label" for="formFileMultiple">파일 추가</label>
                        <div class="card accordion-item col-sm-11">
                            <c:choose>
	                           <c:when test="${empty files}">
	                           <li style="list-style: none;">첨부파일이 없습니다.</li>
	                           </c:when>
	                           <c:when test="${not empty files}">
	                               <h2 class="accordion-header" id="headingOne">
	                                   <button type="button" class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#accordionOne" aria-expanded="false" aria-controls="accordionOne">
	                                       <c:forEach items="${files}" var="file">
	                                           <div class="me-3">
	                                               <a href='/post/fileDownload/<c:out value="${file.fileId}"/>' class="me-1">${file.fileOrgNm}</a>
	                                               <em class="text-muted small">${file.fileSize} byte</em>
	                                               <span class="badge bg-label-danger d-none deleteFileBtn">X</span>
	                                           </div>
	                                       </c:forEach>
	                                   </button>
	                               </h2>
	                               <div id="accordionOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample" style="">
	                                   <div class="accordion-body">
	                                       <c:forEach items="${files}" var="file">
	                                           <!-- 사진 들어가는 자리 -->
	                                           <img alt="" src="<%=request.getContextPath()%>/post/preview?fileId=<c:out value="${file.fileId}"/>">
	                                       </c:forEach>
	                                       </div>
	                                   </div>
	                           </c:when>
                            </c:choose>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-1 col-form-label" for="basic-default-content">내용</label>
                        <div class="col-sm-11">
                        	<textarea rows="10" name="postCnt" id="basic-default-content" class="form-control-plaintext" readonly><c:out value="${postInfo.postCnt}"/></textarea>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
   

<script src="${CONTEXT_PATH}/resources/js/detailPost.js"></script>
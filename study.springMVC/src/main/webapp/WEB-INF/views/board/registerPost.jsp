<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
  <div>
    <h4 class="fw-bold py-3 mb-3 mt-5" id="boardNm" data-id="<c:out value="${boardId}"/>">
      <span class="text-muted fw-normal"> <c:out value="${boardNm}" />/</span>
      게시글 등록
    </h4>
  </div>
  <div>
    <form action="/post/registerPost" id="frm" method="post" enctype="multipart/form-data">
      <input type="hidden" name="boardId" value="${boardId}">
      <table>
        <tr>
          <td>제목</td>
          <td><input type="text" name="postTtl"></td>
        </tr>
        <tr>
          <td>날짜</td>
          <td>${currentTime}</td>
        </tr>
        <tr>
          <td>첨부파일</td>
          <td><input type="file" name="multiUpload" multiple></td>
        </tr>
        <tr>
          <td>내용</td>
          <td><textarea name="postCnt" cols="30" rows="10"></textarea></td>
        </tr>
      </table>
    </form>
  </div>
</div>

<div class="card mb-4">
  <div class="card-header d-flex align-items-center justify-content-between">
    <h5 class="mb-0">게시글 등록</h5>
    <div>
      <button id="backBtn" type="submit" class="btn btn-outline-primary">목록으로</button>
      <button id="registerPost" type="submit" class="btn btn-primary">등록하기</button>
    </div>
  </div>
  <div class="card-body">
    <form action="/post/registerPost" id="frm" method="post" enctype="multipart/form-data">
      <input type="hidden" name="boardId" value="${boardId}">
      <div class="row mb-3">
        <label class="col-sm-1 col-form-label" for="basic-default-title">제목</label>
        <div class="col-sm-11">
          <input type="text" name="postTtl" class="form-control" id="basic-default-title" placeholder="제목을 입력해주세요.">
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
            <input class="form-control" name="multiUpload"  type="file" id="formFileMultiple" multiple="">
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
</div>

<script src="${CONTEXT_PATH}/resources/js/registerPost.js"></script>
<%--
  Created by IntelliJ IDEA.
  User: ChoiSeoYeon
  Date: 12/3/23
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${CONTEXT_PATH}/resources/css/registerPost.css">
<div class="wrapper">
  <div class="header-content">
    <h3>${boardNm} - 게시글 등록</h3>
    <div>
      <button id="backBtn" type="button">목록으로</button>
      <button id="registerPost" type="submit">등록하기</button>
    </div>
  </div>
  <div class="form-content">
    <form action="/post/registerPost" id="frm" method="post" enctype="multipart/form-data">
      <input type="hidden" name="boardId" value="${boardId}">
      <table border="1" class="tb tb_register">
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

<script src="${CONTEXT_PATH}/resources/js/registerPost.js"></script>
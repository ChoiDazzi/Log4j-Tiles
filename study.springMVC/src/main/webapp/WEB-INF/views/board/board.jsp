<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<link rel="stylesheet" href="/resources/css/board.css">
<div class="wrapper">
    <div class="header-content">
        <h3 id="boardNm" data-id="${boardId}">${boardNm}</h3>
        <button id="registerPost" type="button">게시글 등록</button>
    </div>
    <table border="1" class="tb tb_board">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>등록날짜</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
</div>

<script src="/resources/js/board.js"></script>
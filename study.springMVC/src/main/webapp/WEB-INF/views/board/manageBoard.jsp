<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h4 class="fw-bold py-3 mb-3 mt-5" id="boardNm" data-id="<c:out value="${boardId}"/>">
    <span class="text-muted fw-normal"> 관리자/</span>
    게시판 관리
    </h4>
</div>

<div class="row">
	<div class="card col-md-6">
	 	<h5 class="card-header">게시판 목록</h5>
		 <div class="table-responsive text-nowrap">
		   <table class="table">
		     <thead>
		       <tr>
		         <th>게시판 이름</th>
		       </tr>
		     </thead>
		     <tbody class="table-border-bottom-0">
		     <c:forEach items="${navItems}" var="navItem">
		       <tr>
		         <td><input class="form-control" type="text" value="${navItem.boardNm}" data-id="<c:out value="${navItem.boardId}"/>"/></td>
		         <td>
		           <div class="dropdown">
		             <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown" aria-expanded="false">
		               <i class="bx bx-dots-vertical-rounded"></i>
		             </button>
		             <div class="dropdown-menu">
		               <button type="button" class="dropdown-item" onclick="fn_modifyBoard('<c:out value="${navItem.boardId}"/>')"><i class="bx bx-edit-alt me-1"></i> Edit</button>
		               <button type="button" class="dropdown-item" onclick="fn_deleteBoard('<c:out value="${navItem.boardId}"/>')"><i class="bx bx-trash me-1"></i> Delete</button>
		             </div>
		           </div>
		         </td>
		       </tr>
		       </c:forEach>
		     </tbody>
		   </table>
		 </div>
	</div>
	<div class="col-md-6">
	  <div class="card mb-4">
		  <form action="/boards" method="post">
		    <h5 class="card-header">게시판 등록</h5>
		    <div class="card-body row">
		        <label for="defaultFormControlInput" class="form-label">게시판 이름</label>
		        <input type="text" name="boardNm" class="form-control col-md-8 d-block" id="defaultFormControlInput" placeholder="게시판 이름을 입력하세요." aria-describedby="defaultFormControlHelp">
		      	<button type="submit" class="col-md-4 btn btn-primary mt-3 mx-auto">게시판 등록</button>
		    </div>
		    </form>
	  </div>
	</div>
</div>









<script src="${CONTEXT_PATH}/resources/js/manageBoard.js"></script>
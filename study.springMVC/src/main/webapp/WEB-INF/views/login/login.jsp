<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
function fnLogin() {
	var frm = document.getElementById("frm");
	var username = document.getElementById("userId");
	var password = document.getElementById("userPw");
	
	//id, pw validation ...
	
	return true;
}
</script>

<form action="${CONTEXT_PATH}/login" method="post" id="frm" onsubmit="return fnLogin()">
	<input type="text" name="userId" id="userId"/>
	<input type="password" name="userPw" id="userPw"/>
	<button>로그인</button>
</form>

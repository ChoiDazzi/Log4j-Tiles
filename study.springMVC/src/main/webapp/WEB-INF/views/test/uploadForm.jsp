<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${CPATH}/test/upload.do" method="post" enctype="multipart/form-data">
	 	<fieldset>
			<legend>파일 업로드</legend>
			<p>작성자 : <input type="text" name="userName"></p>
			<p>파일명1 : <input type="file" name="files"/></p>
			<p><input type="submit" value="upload"></p>
	 	</fieldset>
	 </form>
</body>
</html>
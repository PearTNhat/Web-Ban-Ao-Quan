<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="images/upload.htm" method="post" modelAttribute="image"
		enctype="multipart/form-data">

		<form:input type="file" id="file" path="file"/>
		<button type="submit">Upload</button>
	</form:form>
</body>
</html>
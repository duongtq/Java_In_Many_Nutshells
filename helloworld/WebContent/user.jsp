<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<jsp:useBean id="user" class="model.User" />
	<jsp:setProperty name="user" property="name" value="tranduong" />
	Hello <jsp:getProperty name="user" property="name"/>
</body>
</html>
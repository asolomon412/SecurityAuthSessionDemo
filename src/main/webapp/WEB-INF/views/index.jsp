<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Auth Demo</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<%@include file="partials/header.jsp" %>
	<h1>Welcome</h1>
	
	<p class="message">${ message }</p>
	
	<p>This is an auth demo.</p>
	
	<c:if test="${ not empty user }">
		<p>Feel free to browse our <a href="/secrets">secrets</a>.</p>
	</c:if>
</body>
</html>
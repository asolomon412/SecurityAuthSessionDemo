<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<%@include file="partials/header.jsp" %>
	<h1>Login</h1>
	
	<p class="message">${ message }</p>
	
	<form action="/login" method="post">
		<p>
			<label for="username">Username:</label> <input id="username" name="username" value="${ param.username }" required minlength="2" />
		</p>		<p>
			<label for="password">Password:</label> <input id="password" type="password" name="password" required minlength="2" />
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>
	
	or
	
	<p>
		<a href="https://github.com/login/oauth/authorize?client_id=e65d7894c8f3792ccdb8&redirect_uri=http://localhost:8080/oauth-github-callback">Sign in with GitHub</a>
	</p>
</body>
</html>
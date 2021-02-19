<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<head>
<link rel="stylesheet" href="satcoStyle.css">
<title>Acesso | SAtCo</title>
</head>
<body>
	<header>
		<h1 id="title">SAtCo</h1>
	</header>
	<div id="loginBox" class="centralBox">
		<p class="topBottomDoubleBorder">Informe o seu Login para entrar.</p>
    
		<form action="/loginhome" method="post">

			<label for="user">Usu�rio:</label><br>
			<input type="text" id="user" name="name" minlength="5" maxlength="20" required><br>
			<label for="password">Senha:</label><br>
			<input type="password"id="password" name="password" minlength="5" maxlength="20" required><br><br>
			<input type="submit" id="loginButton" value="Entrar">
		</form>
	</div>
</body>
</html>
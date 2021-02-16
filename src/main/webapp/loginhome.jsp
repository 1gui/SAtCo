<html>
<head>
<link rel="stylesheet" href="satcoStyle.css">
<title>Login | SAtCo</title>
</head>
<body>
	<header>
		<h1 id="title">SAtCo</h1>
		<p id="subtitle">Student Attendance Control</p>
	</header>
	<div id="loginBox" class="centralBox">
		<p class="topBottomDoubleBorder">Informe seu login para entrar.</p>
		<form action="/loginhome" method="post">
			<label for="user">Usuário:</label><br>
			<input type="text" id="user" name="name" minlength="5" maxlength="20" required><br>
			<label for="password">Senha:</label><br>
			<input type="password"id="password" name="password" minlength="5" maxlength="20" required><br><br>
			<input type="submit" id="loginButton" value="Entrar">
		</form>
	</div>
</body>
</html>
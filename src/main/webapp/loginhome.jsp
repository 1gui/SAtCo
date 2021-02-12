<html>
<head>
<link rel="stylesheet" href="satcoStyle.css">
<title>Login | SAtCo</title>
</head>
<body>
	<div class="header" id="projectTitle">
		<h1>SAtCo</h1>
		<h4>Student Attendance Control</h4>
	</div>
	<div id="loginBox">
		<label>Informe suas credenciais para ter acesso</label>
		<form action="/login" target="_self" method="post">
			<label for="user">Usu�rio:</label><br>
			<input type="text" id="user" name="name" minlength="5" maxlength="20" required><br>
			<label for="password">Senha:</label><br>
			<input type="password" id="password" name="password" minlength="5" maxlength="20" required><br><br>
			<input type="submit" value="Enviar">
			<!-- (1) ser� necess�rio fazer a autentica��o de login -->
		</form>
	</div>
</body>
</html>
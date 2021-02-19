<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<head>
<link rel="stylesheet" href="satcoStyle.css">
<title>Instituicao | SAtCo</title>
</head>
<body>
	<header>
		<h1 id="title">SAtCo</h1>
	</header>
	<label>Selecione a opcao desejada</label><br><br>
	<table align ="center" border="1px" width"80%">
		<tr>
			<th>Opcoes</th>
			<th>Acesso</th>
		</tr>
		<tr>
			<th><label>Aluno</label></th>
			<th><form action="/student">
				<input type="submit" id="justify" value="Ir"><br>
			</form></th>
		</tr>
		<tr>
			<th><label>Classe</label></th>
			<th><form action="/course">
				<input type="submit" id="justify" value="Ir"><br>
			</form></th>
		</tr>
		<tr>
			<th><label>Empresa</label></th>
			<th><form action="/company">
				<input type="submit" id="justify" value="Ir"><br>
			</form></th>
		</tr>
		<tr>
			<th><label>Materia</label></th>
			<th><form action="/subject">
				<input type="submit" id="justify" value="Ir"><br>
			</form></th>
		</tr>
		<tr>
			<th><label>Professor</label></th>
			<th><form action="/teacher">
				<input type="submit" id="justify" value="Ir"><br>
			</form></th>
		</tr>
	</table>
</body>
</html>
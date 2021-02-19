<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<head>
<link rel="stylesheet" href="satcoStyle.css">
<title>Institui��o | SAtCo</title>
</head>
<body>
	<header>
		<h1 id="title">SAtCo</h1>
	</header>
	<div id="" class="sidebar">
		<label>Selecione a op��o desejada</label><br><br>
		<form id="">
			<label>Justificar falta</label><br>
			<select id="listCourse">
				<option value="idCourse1">TURMA1</option>
				<option value="idCourse2">TURMA2</option>
				<!-- (2.1) Fazer uma lista de turmas no "options" ap�s apertar na setinha do options -->
			</select><br>
			<input type="submit" id="justify" value="Ir"><br>
			<!-- (2.2) ap�s selecionar a turma e apertar o botao, abrir na tela central a lista de alunos, da respectiva turma, com nome e status da frequencia (se o status do aluno for P (presen�a) n�o dar permiss�o para edi��o do mesmo -->
		</form>
		<form>
			<label>Cadastrar</label><br>
			<select id="registrerSTC">
				<option value="student">Aluno</option>
				<option value="company">Empresa</option>
				<option value="subject">Mat�ria</option>
				<option value="teacher">Professor</option>
				<option value="course">Turma</option>
			</select><br>
			<input type="submit" id="register" value="Ir"><br>
			<!-- (2.4) Ap�s apertar botao, carregar na tela central os campos necessarios para o cadastro da respectiva escolha do "select" -->
		</form>
		<form>
			<label>Listar</label><br>
			<select id="listSCT">
				<option value="student">Aluno</option>
				<option value="company">Empresa</option>
				<option value="teacher">Professor</option>
			</select><br>
			<input type="submit" id="list" value="Ir"><br>
			<!-- (2.5) Ap�s apertar botao, carregar na tela central uma lista da respectiva escolha do "select" diretamente do banco -->
		</form>
		<form>
			<label>Editar</label><br>
			<select id="editSCT">
				<option value="student">Aluno</option>
				<option value="company">Empresa</option>
				<option value="teacher">Professor</option>
			</select><br>
			<input type="submit" id="edit" value="Ir"><br>
			<!-- (2.6) Ap�s apertar botao, carregar na tela central uma lista da respectiva escolha do "select" e a op��o de editar para mudar informa��es do banco -->
		</form>
		<form>
			<label>Apagar</label><br>
			<select id="deleteSCT">
				<option value="student">Aluno</option>
				<option value="company">Empresa</option>
				<option value="teacher">Professor</option>
			</select><br>
			<input type="submit" id="delete" value="Ir"><br>
			<!-- (2.7) Ap�s apertar o botao, carregar na tela central uma lista da respectiva escolha do "select" e mostrar as opcoes de deletar -->
		</form>
	</div>
</body>
</html>
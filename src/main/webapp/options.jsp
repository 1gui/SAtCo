<html>
<head>
<link rel="stylesheet" href="satcoStyle.css">
<title>Opções | SAtCo</title>
</head>
<body>
	<header>
		<h1 id="title">SAtCo</h1>
		<p id="subtitle">Student Attendance Control</p>
	</header>
	<div id="" class="sidebar">
		<label>Selecione a opção desejada</label><br><br>
		<form id="">
			<label>Justificar falta</label><br>
			<select id="listCourse">
				<option value="idCourse1">TURMA1</option>
				<option value="idCourse2">TURMA2</option>
				<!-- (2.1) Fazer uma lista de turmas no "options" após apertar na setinha do options -->
			</select><br> <input type="submit" id="" value="Ir"><br>
			<!-- (2.2) após selecionar a turma e apertar o botao, abrir na tela central a lista de alunos, da respectiva turma, com nome e status da frequencia -->
		</form>
		<form>
			<label>Cadastrar</label><br>
			<select id="registrerSTC">
				<option value="student">Aluno</option>
				<option value="company">Empresa</option>
				<option value="subject">Matéria</option>
				<option value="teacher">Professor</option>
				<option value="course">Turma</option>
			</select><br> <input type="submit" id="" value="Ir"><br>
			<!-- (2.4) Após apertar botao, carregar na tela central os campos necessarios para o cadastro da respectiva escolha do "select" -->
		</form>
		<form>
			<label>Listar</label><br>
			<select id="listSCT">
				<option value="student">Aluno</option>
				<option value="company">Empresa</option>
				<option value="teacher">Professor</option>
			</select><br> <input type="submit" id="" value="Ir"><br>
			<!-- (2.5) Após apertar botao, carregar na tela central uma lista da respectiva escolha do "select" diretamente do banco -->
		</form>
		<form>
			<label>Editar</label><br>
			<select id="editSCT">
				<option value="student">Aluno</option>
				<option value="company">Empresa</option>
				<option value="teacher">Professor</option>
			</select><br> <input type="submit" id="" value="Ir"><br>
			<!-- (2.6) Após apertar botao, carregar na tela central uma lista da respectiva escolha do "select" e a opção de editar para mudar informações do banco -->
		</form>
		<form>
			<label>Apagar</label><br>
			<select id="deleteSCT">
				<option value="student">Aluno</option>
				<option value="company">Empresa</option>
				<option value="teacher">Professor</option>
			</select><br> <input type="submit" id="" value="Ir"><br>
			<!-- (2.7) Após apertar o botao, carregar na tela central uma lista da respectiva escolha do "select" e mostrar as opcoes de deletar -->
		</form>
	</div>
</body>
</html>
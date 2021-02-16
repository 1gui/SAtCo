<html>
<head>
<link rel="stylesheet" href="satcoStyle.css">
<title>Professor | SAtCo</title>
</head>
<body>
	<header>
		<h1 id=>SAtCo</h1>
		<p>Student Attendance Control</p>
	</header>
	<div id="teacherOptions" class="sidebar">
		<!-- Cada opção de turma deve ter o ID da turma que representa,
                e o valor deve ser o nome da turma, todos os botões de turma deven ser gerados pelo .jsp -->
		<h4>Turmas:</h4>
		<form>
			<select id="course" name="course">
				<option id="">Turma tal</option>
				<option id="">Turma outra</option>
			</select> <input type="submit" value="Selecionar">
		</form>
	</div>
	<!-- A tabela a seguir deve ser gerada pelo .jsp
            contendo os alunos correspondentes da turma em ordem alfabetica;
             Somente quando o botão correspondente aquela turma for precionado,
              a tabela deve desaparecer ao submeter a chamada,
               e a mesma tabela já preenchida deve aparecer se o botão for precionado novamente dentro do mesmo dia -->
	<div name="studentAttendanceTable" class="centralBox">	
		<form>
			<table name="courseStudents" id="">
				<tr>
					<th>Aluno</th>
					<th>Presença</th>
				</tr>
				<tr>
					<td>
						<p name="studentName" id="">Anderleyson soares da silva
							almeida campos de souza</p>
					</td>
					<td>
					<input type="checkbox" id="">
					</td>
				</tr>
			</table><br>
			<input type="submit" value="Registrar chamada">
		</form>
	</div>
</body>
</html>
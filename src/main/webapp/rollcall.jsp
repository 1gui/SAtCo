<html>
<head>
<link rel="stylesheet" href="satcoStyle.css">
<title>Professor | SAtCo</title>
</head>
<body>
	<header>
		<h1 id=>SAtCo</h1>
		<p>Lista De Chamada</p>
	</header>
	<div id="teacherOptions" class="sidebar">
		
		<h4>Turmas:</h4>
		<form>
			<select id="course" name="course">
				<option id="">Turma A</option>
				<option id="">Turma B</option>
			</select> <input type="submit" value="Selecionar">
		</form>
	</div>
	
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
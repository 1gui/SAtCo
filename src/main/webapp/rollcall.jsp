<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h4>Turmas:</h4>
		<form action="/rollcall?id=<c:out value='${course.id}'/>">
			<select id="course" name="course">
				<c:forEach var="course" items="${courses}" varStatus="id">
				<option><c:out value="${course.name}"/></option>
				</c:forEach>
			</select>
			<input type="submit" value="Selecionar"><br>
		</form>
		<form action="/insertfrequency">
			<table>
				<tr>
					<th>Aluno</th>
					<th>Presenca</th>
				</tr>
				<c:forEach var="student" items="${students}">
				<tr>
					<td>
						<p><c:out value="${student.name}"/></p>
					</td>
					<td>
						<input type="checkbox" id="">
					</td>
				</tr>
				</c:forEach>
			</table><br>
			<input type="submit" value="Registrar chamada">
		</form>
</body>
</html>
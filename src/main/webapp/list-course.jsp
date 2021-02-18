<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<br>
	<div>
		<div>
			<h3>Lista De Opções</h3>
			<hr>
			<br>
			<table>
				<thead>
					<tr>
						<th>Nome</th>
						<th>Matéria</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="course" items="${courses}">
						<tr>
							<td><c:out value="${course.name}"/></td>
							<td><c:out value="${course.teacher}"/></td>
							<td><a href="/updatestudent?id=<c:out value='${course.id}'/>">Editar</a>
								<a href="/removestudent?id=<c:out value='${course.id}'/>">Apagar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
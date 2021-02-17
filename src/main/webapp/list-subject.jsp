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
			<h3>Lista de Opções</h3>
			<hr>
			<div>
				<a href="<%=request.getContextPath()%>/subject">Adicionar matéria</a>
			</div>
			<br>
			<table>
				<thead>
					<tr>
						<th>Nome</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${subject}">
						<tr>
							<td><c:out value="${subject.name}"/></td>
							<td><a href="/updatesubject?id=<c:out value='${subject.id}'/>">Editar</a>
								<a href="/removesubject?id=<c:out value='${subject.id}'/>">Deletar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
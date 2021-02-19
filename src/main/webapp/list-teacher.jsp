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
						<th>CPF</th>
						<th>E-mail</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="teacher" items="${teachers}">
						<tr>
							<td><c:out value="${teacher.name}"/></td>
							<td><c:out value="${teacher.cpf}"/></td>
							<td><c:out value="${teacher.email}"/></td>
							<td><a href="/updateteacher?id=<c:out value='${teacher.id}'/>">Editar</a>
								<a href="/removeteacher?id=<c:out value='${teacher.id}'/>">Apagar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
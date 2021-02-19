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
						<th>Classes</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="course" items="${courses}">
						<tr>
							<td><c:out value="${course.name}"/></td>
							<td><a href="/showcoursestudent?id=<c:out value='${course.id}'/>">Listar</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
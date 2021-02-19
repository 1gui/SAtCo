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
						<th>CNPJ</th>
						<th>E-mail</th>
						<th>Endereço</th>
						<th>Telefone</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="company" items="${companys}">
						<tr>
							<td><c:out value="${company.name}" /></td>
							<td><c:out value="${company.cnpj}" /></td>
							<td><c:out value="${company.email}" /></td>
							<td><c:out value="${company.address}"/></td>
							<td><c:out value="${company.phone}"/></td>
							<td><a href="/updatecompany?id=<c:out value='${company.id}'/>">Editar</a>
								<a href="/deletecompany?id=<c:out value='${company.id}'/>">Apagar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
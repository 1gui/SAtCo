<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<head>
<title>Listar Compania</title>
</head>
<body>
	
	<br>
	<div>
		<div>
			<h3>Lista De Companias</h3>
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
							<td><a href="editCompany?id=<c:out value='${company.id}'/>">Editar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
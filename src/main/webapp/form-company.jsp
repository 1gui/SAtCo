<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="satcoStyle.css">
<title>Cadastro | SAtCo</title>
</head>
<body>
	<header>
		<h1 id="title">SAtCo</h1>
		<p id="subtitle">Student Attendance Control</p>
	</header>
	<br>
	<div>
		<div>
			<div>
				<c:if test="${company != null}">
					<form action="/updatecompany" method="post">
				</c:if>
				<c:if test="${company == null}">
					<form action="/insertcompany" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${company != null}">Editar empresa</c:if>
						<c:if test="${company == null}">Inserir empresa</c:if>
					</h2>
				</caption>
				<c:if test="${company != null}">
					<input type="hidden" name="id"
						value="<c:out value='${company.id}'/>"/>
				</c:if>
				<fieldset>
					<label>Nome:</label> <input type="text" value="<c:out value='${company.name}'/>" name="name">
				</fieldset>
				<fieldset>
					<label>CNPJ:</label> <input type="text" value="<c:out value='${company.cnpj}'/>" name="cnpj">
				</fieldset>
				<fieldset>
					<label>E-mail:</label> <input type="text" value="<c:out value='${company.email}'/>" name="email">
				</fieldset>
				<fieldset>
					<label>Endereço:</label> <input type="text" value="<c:out value='${company.adress}'/>" name="address">
				</fieldset>
				<fieldset>
					<label>Telefone:</label> <input type="text" value="<c:out value='${company.phone}'/>" name="phone">
				</fieldset>
				<button type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
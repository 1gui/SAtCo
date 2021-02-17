<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de Compania</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="<%=request.getContextPath()%>/listCompany">Listar
						Companias</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div>
		<div>
			<div>
				<c:if test="${company != null}">
					<form action="updateCompany" method="post">
				</c:if>
				<c:if test="${company == null}">
					<form action="insertCompany" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${company != null}">Editar Compania</c:if>
						<c:if test="${company == null}">Inserir Compania</c:if>
					</h2>
				</caption>
				<c:if test="${company != null}">
					<input type="hidden" name="id"
						value="<c:out value='${company.id}' />" />
				</c:if>
				<fieldset>
					<label>Nome:</label> <input type="text"
						value="<c:out value='${company.name}' />" name="name">
				</fieldset>
				<fieldset>
					<label>CNPJ:</label> <input type="text"
						value="<c:out value='${company.cnpj}' />" name="cnpj">
				</fieldset>
				<fieldset>
					<label>E-mail:</label> <input type="text"
						value="<c:out value='${company.email}'/>" name="email">
				</fieldset>
				<fieldset>
					<label>Endereço:</label> <input type="text"
						value="<c:out value='${company.adress}' />" name="address">
				</fieldset>
				<fieldset>
					<label>Telefone:</label> <input type="text"
						value="<c:out value='${company.phone}' />" name="telefone">
				</fieldset>
				<button type="submit">Salvar</button>
				</form>
				<c:if test="${company != null}">
					<input type="hidden" name="id"
						value="<c:out value='${company.id}' />" />
					<form action="removeCompany" method="post">
						<button type="submit">Deletar</button>
					</form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
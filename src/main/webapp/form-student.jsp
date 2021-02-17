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
				<c:if test="${student != null}">
					<form action="/updatestudent" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="/insertstudent" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${student != null}">Editar aluno</c:if>
						<c:if test="${student == null}">Inserir aluno</c:if>
					</h2>
				</caption>
				<c:if test="${student != null}">
					<input type="hidden" name="id" value="<c:out value='${student.id}'/>"/>
				</c:if>
				<fieldset>
					<label>Nome:</label> <input type="text" value="<c:out value='${student.name}'/>" name="name">
				</fieldset>
				<fieldset>
					<label>CPF:</label> <input type="text" value="<c:out value='${student.cpf}'/>" name="cpf">
				</fieldset>
				<fieldset>
					<label>E-mail:</label> <input type="text" value="<c:out value='${student.email}'/>" name="email">
				</fieldset>
				<button type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
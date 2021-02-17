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
				<c:if test="${teacher != null}">
					<form action="/updateteacher" method="post">
				</c:if>
				<c:if test="${teacher == null}">
					<form action="/insertteacher" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${teacher != null}">Editar professor</c:if>
						<c:if test="${teacher == null}">Inserir professor</c:if>
					</h2>
				</caption>
				<c:if test="${teacher != null}">
					<input type="hidden" name="id" value="<c:out value='${teacher.id}'/>"/>
				</c:if>
				<fieldset>
					<label>Nome:</label> <input type="text" value="<c:out value='${teacher.name}'/>" name="name">
				</fieldset>
				<fieldset>
					<label>CPF:</label> <input type="text" value="<c:out value='${teacher.cpf}'/>" name="cpf">
				</fieldset>
				<fieldset>
					<label>E-mail:</label> <input type="text" value="<c:out value='${teacher.email}'/>" name="email">
				</fieldset>
				<button type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
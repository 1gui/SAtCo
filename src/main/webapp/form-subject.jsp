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
	</header>
	<br>
	<div>
		<div>
			<div>
				<c:if test="${student != null}">
					<form action="/updatesubject" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="/insertsubject" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${subject != null}">Editar matéria</c:if>
						<c:if test="${subject == null}">Inserir matéria</c:if>
					</h2>
				</caption>
				<c:if test="${subject != null}">
					<input type="hidden" name="id" value="<c:out value='${subject.id}'/>"/>
				</c:if>
				<fieldset>
					<label>Nome:</label>
					<input type="text" value="<c:out value='${subject.name}'/>" name="name">
				</fieldset>
				<button type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
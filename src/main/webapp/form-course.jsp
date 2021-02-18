<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<c:if test="${course != null}">
					<form action="/updatecourse" method="post">
				</c:if>
				<c:if test="${course == null}">
					<form action="/insertcourse" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${course != null}">Editar turma</c:if>
						<c:if test="${course == null}">Inserir turma</c:if>
					</h2>
				</caption>
				<c:if test="${course != null}">
					<input type="hidden" name="id" value="<c:out value='${course.id}'/>" />
				</c:if>
				<fieldset>
					<label>Nome:</label> <input type="text" value="<c:out value='${course.name}'/>" name="name">
				</fieldset>
				<fieldset>
					<label>Professor:</label> <input type="text" value="<c:out value='${course.teacher}'/>" name="teacher">
				</fieldset>
				<button type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
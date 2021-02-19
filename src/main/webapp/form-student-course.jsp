<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="satcoStyle.css">
<title>Lista De Alunos | SAtCo</title>
</head>
<body>
	<fieldset>
	<legend><strong>Lista De Alunos</strong><legend>
	<table align ="center" border="1px" width"80%">
	<tr>
		<th>Classe</th>
		<th>Name</th>
	</tr>
	<tbody>
	<c:forEach var="student" items="${students}">
						<tr>
				<td><c:out value="${course.name}" /></td>
				<td><c:out value="${student.name}" /></td>
	</fieldset>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Usuario</title>
<%@ include file="./includes/header.jsp"%>
</head>
<body>

	<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
			</tr>
			<c:forEach items="${usuarios}" var="user">
				<tr>
					<td>${user.getIdUsuario}</td>
					<td>${user.getNomeUsuario}</td>
					<td>${user.getEmailUsuario}</td>
				</tr>
			</c:forEach>
		</table>

	<%@ include file="./includes/footer.jsp"%>

</body>
</html>
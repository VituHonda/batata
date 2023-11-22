<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin</title>
<%@ include file="./includes/header.jsp"%>
</head>
<body>

	<%@ include file="./includes/admin_menu.jsp"%>

	<div class="container">
		<h1 class="mt-5">Avaliações</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Nota</th>
				<th>Mensagem</th>
				<th>Tecnologia</th>
				<th>ID Usuario</th>
				
			</tr>
			<c:forEach items="${avaliacoes}" var="t">
				<tr>
					<td>${t.idAvaliacao}</td>
					<td>${t.nota}</td>
					<td>${t.mensagem}</td>
					<td>${t.tecnologiaConsulta.idTecnologia}</td>
					<td>${t.usuario.idUsuario}</td>
					<td class="d-flex">
						<form action="avaliacoes" method="post" class="ms-3">
							<input type="hidden" name="acao" value="excluir"> <input
								type="hidden" name="idAvaliacao" value="${t.idAvaliacao}">
							<button type="submit" class="btn btn-danger btn-xs">Excluir</button>
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="./includes/footer.jsp"%>

</body>
</html>
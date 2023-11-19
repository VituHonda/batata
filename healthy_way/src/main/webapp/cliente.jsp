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
<title>Cliente</title>
<%@ include file="header.jsp"%>
</head>
<body>

	<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
			</tr>
			<c:forEach items="${usuarios}" var="p">
				<tr>
					<td>${p.idUsuario}</td>
					<td>${p.nomeUsuario}</td>
					<td>${p}</td>
					<td><c:url value="usuaio" var="link">
							<c:param name="acao" value="abrir-form-edicao" />
							<c:param name="codigo" value="${p.idUsuario }" />
						</c:url> <a href="${link}" class="btn btn-primary btn-xs">Editar</a>
						<button type="button" class="btn btn-danger btn-xs"
							data-toggle="modal" data-target="#excluirModal"
							onclick="codigoExcluir.value = ${p.codigo}">Excluir</button></td>
				</tr>
			</c:forEach>
		</table>

	<%@ include file="footer.jsp"%>

</body>
</html>
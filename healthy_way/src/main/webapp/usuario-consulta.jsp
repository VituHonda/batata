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

	<div class="d-flex">
		<%@ include file="./includes/usuario_sidebar.jsp"%>


<div class="container">
		<h1 class="mt-5">Dados Biometricos</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Convenio</th>
				<th>Tipo Sanguineo</th>
				<th>Genero</th>
				
			</tr>
			<c:forEach items="${dados}" var="t">
				<tr>
					<td>${t.idDadosBiometricosUsuario}</td>
					<td>${t.convenioMedico}</td>
					<td>${t.tipoSanguineo}</td>
					<td>${t.genero}</td>

					<td class="d-flex">
						<form action="dados" method="post" class="ms-3">
							<input type="hidden" name="acao" value="excluir"> <input
								type="hidden" name="idDadosBiometricosUsuario" value="${t.idDadosBiometricosUsuario}">
							<button type="submit" class="btn btn-danger btn-xs">Excluir</button>
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>


	</div>

	<%@ include file="./includes/footer.jsp"%>

</body>
</html>


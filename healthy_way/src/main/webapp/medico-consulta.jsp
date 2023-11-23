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
<title>Medico</title>
<%@ include file="./includes/header.jsp"%>
</head>
<body>

	<div class="d-flex">
		<%@ include file="./includes/medico_sidebar.jsp"%>

		<div class="container">
			<h1 class="mt-5">Consultas agendadas</h1>
			<c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			<c:if test="${not empty erro }">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
			<table class="table table-striped">
				<tr>
					<th>C�digo</th>
					<th>Nome Usuario</th>
					<th>Nome Tecnologia</th>
					<th>Descri��o Tecnologia</th>
					<th>Situa��o</th>

				</tr>
				<c:forEach items="${consultas}" var="t">
					<tr>
						<td>${t.idConsulta}</td>
						<td>${t.usuario.nomeUsuario}</td>
						<td>${t.tecnologiaConsulta.nomeTecnologia}</td>
						<td>${t.tecnologiaConsulta.descricaoTecnologia}</td>
						<td><c:if test="${t.situacao == 1}">
							Atendido
						</c:if> <c:if test="${t.situacao == 0}">
							Nao Atendido
						</c:if></td>


						<td class="d-flex"><c:if test="${t.situacao == 0}">
								<form action="medico-consulta" method="post" class="ms-3">
									<input type="hidden" name="acao" value="atender"> <input
										type="hidden" name="idMedicoConsulta" value="${t.idConsulta}">
									<button type="submit" class="btn btn-danger btn-xs">Atender</button>
								</form>

								<form action="medico-consulta" method="post" class="ms-3">
									<input type="hidden" name="acao" value="excluir"> <input
										type="hidden" name="idMedicoConsulta" value="${t.idConsulta}">
									<button type="submit" class="btn btn-danger btn-xs">Desmarcar</button>
								</form></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

	<%@ include file="./includes/footer.jsp"%>

</body>
</html>

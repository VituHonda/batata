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
<title>Usuario consulta</title>
<%@ include file="./includes/header.jsp"%>
</head>
<body>

	<div class="d-flex">
		<%@ include file="./includes/usuario_sidebar.jsp"%>

		<div class="container">
			<h1>Cadastro de Consulta</h1>
			<c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			<c:if test="${not empty erro }">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
			<form action="usuario-consulta" method="post">
			<input type="hidden" value="cadastrar" name="acao">
				<div class="form-group">
					<label for="id-medico">Medicos</label> <select
						name="medico" id="id-medico" class="form-control">
						<option value="0">Selecione</option>
						<c:forEach items="${medicos}" var="c">
							<option value="${c.idMedico}">${c.nomeMedico}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="id-tecnologia">Tecnologias</label> <select name="tecnologia"
						id="id-tecnologia" class="form-control">
						<option value="0">Selecione</option>
						<c:forEach items="${tecnologias}" var="c">
							<option value="${c.idTecnologia}">${c.nomeTecnologia}</option>
						</c:forEach>
					</select>
				</div>

				<br> <input type="submit" value="Agendar"
					class="btn btn-primary">
			</form>
		</div>


	</div>

	<%@ include file="./includes/footer.jsp"%>

</body>
</html>


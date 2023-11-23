<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./includes/header.jsp"%>
</head>
<body>

	<div class="d-flex">
		<%@ include file="./includes/usuario_sidebar.jsp"%>


		<div class="container">
			<h1>
				Cadastro Avaliação da Tecnologia:
				<c:out value="${consulta.tecnologiaConsulta.nomeTecnologia}" />
			</h1>
			<c:if test="${not empty msg }">
				<div class="alert alert-success">${msg}</div>
			</c:if>
			<c:if test="${not empty erro }">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
			<div class="form-group">
				<form action="avaliacoes" method="post">
					<input type="hidden" value="cadastrar" name="acao">
					<div class="form-group">
						<label for="nota">Nota</label> <select name="nota" id="nota"
							class="form-control">
							<option value="0">Selecione</option>
							<c:forEach items="${notas}" var="c">
								<option value="${c}">${c}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="mensagem">Digite a Mensagem:</label> <input
							type="text" name="mensagem" id="mensagem" placeholder="Opcional"
							class="form-control">
					</div>

					<input type="hidden" name="idTecnologia"
						value="<c:out value='${consulta.tecnologiaConsulta.idTecnologia}' />">
					<input type="hidden" name="idUsuarioConsulta"
						value="<c:out value='${consulta.idConsulta}' />"> <br>
					<input type="submit" value="Salvar" class="btn btn-primary">
				</form>
			</div>
		</div>


	</div>

	<%@ include file="./includes/footer.jsp"%>

</body>
</html>




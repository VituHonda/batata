<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de Tecnologia</title>
<%@ include file="./includes/header.jsp"%>
</head>
<body>
	<%@ include file="./includes/admin_menu.jsp"%>
	<div class="container">
		<h1 class="mt-5">Edição de Tecnologia</h1>
		<form action="tecnologias" method="post">
			<input type="hidden" value="editar" name="acao"> <input
				type="hidden" value="${tecnologia.idTecnologia }" name="codigo">
			<div class="form-group">
				<label for="id-nome">Nome</label> <input type="text" name="nome"
					id="id-nome" class="form-control"
					value="${tecnologia.nomeTecnologia }">
			</div>
			<div class="form-group">
				<label for="id-valor">Descricao</label> <input type="text"
					name="descricao" id="id-valor" class="form-control"
					value="${tecnologia.descricaoTecnologia }">
			</div>

			<br> <input type="submit" value="Salvar" class="btn btn-primary">
			<a href="tecnologias?acao=listar" class="btn btn-danger">Cancelar</a>
		</form>
	</div>
	<%@ include file="./includes/footer.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Tecnologia</title>
<%@ include file="./includes/header.jsp"%>
</head>
<body>
	<%@ include file="./includes/admin_menu.jsp"%>
	<div class="container">
		<h1 class="mt-5">Cadastro de Tecnologia</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<form action="tecnologias" method="post">
			<input type="hidden" value="cadastrar" name="acao">
			<div class="form-group">
				<label for="id-nome">Nome</label> <input type="text" name="nome"
					id="id-nome" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-valor">Descri��o</label> <input type="text" name="descricao"
					id="id-valor" class="form-control">
			</div>
						
			<br>
			<input type="submit" value="Salvar" class="btn btn-primary">
		</form>
	</div>
	<%@ include file="./includes/footer.jsp"%>
</body>
</html>
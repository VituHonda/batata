<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<div class="container">
		<h1>Cadastro Consulta</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
			<div class="form-group">
				<label for="id-categoria">Categoria</label> <select name="categoria"
					id="id-categoria" class="form-control">
					<option value="0">Selecione</option>
					<c:forEach items="${categorias}" var="c">
						<option value="${c.codigo}">${c.nome}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label for="id-marca">Marca</label> <select name="marca"
					id="id_marca" class="form-control">
					<option value="0">Selecione</option>
					<c:forEach items="${marcas}" var="c">
						<option value="${c.codigo}">${c.nome}</option>
					</c:forEach>
				</select>
			</div>

			<br> <input type="submit" value="Salvar" class="btn btn-primary">
		</form>
	</div>

</body>
</html>
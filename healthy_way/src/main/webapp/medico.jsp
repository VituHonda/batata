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

		<div class="m-5">
			<h1>
				Bem-vindo
					<c:out value="${user.nomeMedico}" />
				!!!
			</h1>
		</div>

	</div>

	<%@ include file="./includes/footer.jsp"%>

</body>
</html>
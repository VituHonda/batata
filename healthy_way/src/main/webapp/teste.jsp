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
<title>teste</title>
<%@ include file="./includes/header.jsp"%>
</head>
<body>

	<form action="teste" method="get">
        <input type="submit" value="Chamar Método doGet">
    </form>

	<p>
		<c:out value="${mensagem}" />
	</p>

	<%@ include file="./includes/footer.jsp"%>
</body>
</html>


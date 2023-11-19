<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Usuario</title>
<%@ include file="header.jsp"%>

<style type="text/css">
.navbar_size {
	height: 5rem;
}

.custom-container {
	height: 89vh;
	position: relative;
	background-image: url("./resources/images/techClinic.jpg");
}

.home_option {
	width: 23vw;
	padding: 4rem;
}

.img_button {
	margin-top: 2rem;
}

.home_button {
	text-decoration: none;
	color: white;
}

.nav-item {
	font-size: 1.5rem;
}

.titles {
	padding-top:2rem;
	text-align: center;
	width:40vw;
}

.tecnologias {
	height: 100vh;
	width: 100%;
	background-color: #add8e6;
	display:flex;
	justify-content:center;
}

.sobre {
	height: 100vh;
	width: 100%;
	background-color: #b5bac9;
	display:flex;
	justify-content:center;
}

.footer {
	height: 20vh;
	width: 100%;
	background-color: black;
	display: flex;
	justify-content: right;
}

.footer_link {
	text-decoration: none;
	color: white;
	margin: 2rem;
}
</style>
</head>
<body id="inicio">

	<%@ include file="home_menu.jsp"%>

	<div id="home" class="custom-container">

		<div class="home_option">
			<h1 class="img_text">Plataforma feita para facilitar sua vida na
				hora de procurar um médico</h1>

			<button type="button" class="btn btn-dark img_button">
				<a href="cliente.jsp" class="home_button">Cadastre-se</a>
			</button>
		</div>


	</div>

	<div id="tecnologias" class="tecnologias">

		<h1 class="titles">Nossos médicos usam tecnologias inovadoras em
			suas consultas e exames:</h1>




	</div>

	<div id="sobre" class="sobre">

		<h1 class="titles">Nosso lema é: Facilitar a jornada do cliente até o médico que
			irá resolver seu problema</h1>

	</div>

	<div id="footer" class="footer">
		<a href="#inicio" class="footer_link ">INICIO</a>
	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>
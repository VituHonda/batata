<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Usuario</title>
<%@ include file="./includes/header.jsp"%>

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
	padding-top: 2rem;
	text-align: center;
	width: 40vw;
}

.tecnologias {
	height: 100vh;
	width: 100%;
	background-color: #add8e6;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.cards_container-tec {
	width: 80vw;
	display: flex;
	margin: 5rem;
	justify-content: space-between;
	
}


.sobre {
	height: 100vh;
	width: 100%;
	background-color: #b5bac9;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.sobre_text {
	margin-top: 3rem;
	width: 40vw;
	font-size: 20px;
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
				hora de procurar um m�dico</h1>

			<button type="button" class="btn btn-dark img_button">
				<a href="cadastroUsuario.jsp" class="home_button">Cadastre-se</a>
			</button>
		</div>


	</div>

	<div id="sobre" class="sobre">

		<h1 class="titles">Nosso lema �: Facilitar a jornada do cliente
			at� o m�dico que ir� resolver seu problema</h1>

		<div class="sobre_text">
			<p>Bem-vindo � HealthWay, onde priorizamos o gerenciamento
				proativo de informa��es relacionadas � preven��o de problemas de
				sa�de e � promo��o da qualidade de vida. Estamos empenhados em
				facilitar a ado��o de solu��es tecnol�gicas que contribuam para a
				preven��o de problemas de sa�de, enquanto incentivamos uma
				participa��o ativa por parte dos usu�rios por meio de avalia��es e
				monitoramento personalizado.</p>
			<br>
			<p>Na HealthWay, acreditamos que o cuidado com a sa�de deve ser
				uma jornada colaborativa, onde os usu�rios t�m o poder de tomar
				decis�es informadas sobre seu bem-estar. Ao oferecer ferramentas
				tecnol�gicas avan�adas, buscamos simplificar a integra��o dessas
				solu��es no cotidiano, tornando a preven��o de problemas de sa�de
				acess�vel e eficaz.</p>
			<br>
			<p>Ao escolher a HealthWay, voc� est� escolhendo um parceiro
				comprometido em transformar a abordagem convencional da sa�de,
				capacitando-o a trilhar um caminho mais saud�vel e equilibrado.
				Junte-se a n�s na busca por uma vida plena e ativa, onde o cuidado
				com a sa�de est� ao alcance de suas m�os.</p>
		</div>


	</div>

	<div id="footer" class="footer">
		<a href="#inicio" class="footer_link ">INICIO</a>
	</div>

	<%@ include file="./includes/footer.jsp"%>

</body>
</html>
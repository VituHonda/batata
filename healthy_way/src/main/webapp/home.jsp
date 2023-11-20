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
				hora de procurar um médico</h1>

			<button type="button" class="btn btn-dark img_button">
				<a href="cliente.jsp" class="home_button">Cadastre-se</a>
			</button>
		</div>


	</div>

	<div id="tecnologias" class="tecnologias">

		<h1 class="titles">Nossos médicos usam tecnologias inovadoras em
			suas consultas e exames:</h1>

		<div class="cards_container-tec">
			<div class="card" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>
		</div>
		
		<div class="cards_container-tec">
			<div class="card" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>
			</div>
		</div>



	</div>

	<div id="sobre" class="sobre">

		<h1 class="titles">Nosso lema é: Facilitar a jornada do cliente
			até o médico que irá resolver seu problema</h1>

		<div class="sobre_text">
			<p>Bem-vindo à HealthWay, onde priorizamos o gerenciamento
				proativo de informações relacionadas à prevenção de problemas de
				saúde e à promoção da qualidade de vida. Estamos empenhados em
				facilitar a adoção de soluções tecnológicas que contribuam para a
				prevenção de problemas de saúde, enquanto incentivamos uma
				participação ativa por parte dos usuários por meio de avaliações e
				monitoramento personalizado.</p>
			<br>
			<p>Na HealthWay, acreditamos que o cuidado com a saúde deve ser
				uma jornada colaborativa, onde os usuários têm o poder de tomar
				decisões informadas sobre seu bem-estar. Ao oferecer ferramentas
				tecnológicas avançadas, buscamos simplificar a integração dessas
				soluções no cotidiano, tornando a prevenção de problemas de saúde
				acessível e eficaz.</p>
			<br>
			<p>Ao escolher a HealthWay, você está escolhendo um parceiro
				comprometido em transformar a abordagem convencional da saúde,
				capacitando-o a trilhar um caminho mais saudável e equilibrado.
				Junte-se a nós na busca por uma vida plena e ativa, onde o cuidado
				com a saúde está ao alcance de suas mãos.</p>
		</div>


	</div>

	<div id="footer" class="footer">
		<a href="#inicio" class="footer_link ">INICIO</a>
	</div>

	<%@ include file="./includes/footer.jsp"%>

</body>
</html>
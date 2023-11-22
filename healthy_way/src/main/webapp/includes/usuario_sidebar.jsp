<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark"
	style="width: 280px; height: 100vh">
	<a href="/"
		class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
		<svg class="bi me-2" width="40" height="32">
				<use xlink:href="#bootstrap"></use></svg> <span class="fs-4">MENU</span>
	</a>
	<hr>
	<ul class="nav nav-pills flex-column mb-auto">
		<li><a href="usuario.jsp" class="nav-link text-white"> <svg
					class="bi me-2" width="16" height="16">
						<use xlink:href="#table"></use></svg> Inicio
		</a></li>
		<li><a href="usuario-consulta?acao=cadastrar"
			class="nav-link text-white"> <svg class="bi me-2" width="16"
					height="16">
						<use xlink:href="#table"></use></svg> Agendar Consulta
		</a></li>
		<li><a href="#" class="nav-link text-white"> <svg
					class="bi me-2" width="16" height="16">
						<use xlink:href="#table"></use></svg> Consultas
		</a></li>
		<li><a href="biometricos?acao=listar" class="nav-link text-white"> <svg
					class="bi me-2" width="16" height="16">
						<use xlink:href="#grid"></use></svg> Dados Biometricos
		</a></li>

	</ul>
	<hr>
	<div class="dropdown">
		<a href="#"
			class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
			id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
			<img src="./resources/images/unknown.png" alt="" width="32"
			height="32" class="rounded-circle me-2"> <strong>Op��es</strong>
		</a>
		<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
			aria-labelledby="dropdownUser1" style="">
			<li><a class="dropdown-item" href="home.jsp">Sair</a></li>
		</ul>
	</div>
</div>
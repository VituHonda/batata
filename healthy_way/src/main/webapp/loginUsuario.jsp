<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>LoginUsuario</title>
<%@ include file="./includes/header.jsp"%>
<style type="text/css">
.custom-container {
	height: 100vh;
	position: relative;
	background-image: url("./resources/images/prancheta.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	display: flex;
	align-items: center;
	justify-content: center;
}

.login_container {
	width: 30%;
	height: 50%;
	background-color: white;
	border-radius: 20px;
}

.login_text {

	margin:1rem;
}

.input_size {
	width: 80%;
}
</style>

</head>
<body>

	<div class="custom-container">

		<div class="login_container">
			
			<h1 class="login_text">USER LOGIN</h1>
			<form>
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label m-3">Email
						address</label> <input type="email" class="form-control ms-3 input_size"
						id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label m-3">Password</label>
					<input type="password" class="form-control ms-3 input_size"
						id="exampleInputPassword1">
				</div>

				<button type="submit" class="btn btn-primary ms-4">Submit</button>
			</form>

		</div>

	</div>

	<%@ include file="./includes/footer.jsp"%>

</body>
</html>
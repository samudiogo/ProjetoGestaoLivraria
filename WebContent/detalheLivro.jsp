<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhe livro</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://v4-alpha.getbootstrap.com/examples/narrow-jumbotron/narrow-jumbotron.css">
</head>
<body>
	<div class="container">
		<h2>
			Detalhe Livro <span class="text-info">${livro.nome }</span>
		</h2>
		<div class="well">
			<c:if test="${livro.id != null }">
				<h4>
					Reserve este livro! <a class="btn btn-outline-warning btn-sm"
						href="ManterLivro?livroId=${livro.id}"> Reservar</a>
				</h4>
			</c:if>
		</div>
		<form class="form-signin" action="ManterLivro" method="post">
			<input type="hidden" name="id" value="${livro.id }">
			<div class="form-group">
				<label for="inputEmail" class="sr-only">Nome</label> <input
					type="text" name="nome" class="form-control" value="${livro.nome }"
					placeholder="nome do livro" required autofocus>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="sr-only">Quantidade</label> <input
					type="text" name="qtde" class="form-control" value="${livro.qtde }"
					placeholder="qtde de livros" required>
			</div>
			<button class="btn btn-lg btn-outline-primary " type="submit">Salvar</button>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Livros</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://v4-alpha.getbootstrap.com/examples/narrow-jumbotron/narrow-jumbotron.css">
</head>
<body>
	<div class="container">
		<h1>Lista Livros - <a class="btn btn-outline-warning" href="ControlaLivro?ac=new"> adicionar novo</a></h1>
		<hr>
		
		<table class="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Ação</th>
				</tr>
			</thead>
			<c:forEach var="livros" items="${listalivros}">
				<tr>
					<td>${livros.nome}</td>
					<td><a class="btn btn-outline-success btn-sm" href="ControlaLivro?id=${livros.id}"> Detalhes </a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>
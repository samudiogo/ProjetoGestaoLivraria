<%@page import="negocio.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastramento de Usuário</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://v4-alpha.getbootstrap.com/examples/narrow-jumbotron/narrow-jumbotron.css">
</head>
</head>
<body>
	<%
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
		Boolean foiIncluido = (Boolean) request.getAttribute("ehIncluido");
	%>
	<div class="container">
	
		<h2>Perfil de Usuario - <a href="ControlaLivro" class="btn btn-outline-success"> >> Listar livros </a>
		</h2>
	
	
		<form action="ManterUsuario" method="post">
			
			<label>Nome</label>
			<input type="text" class="form-control" name="nome"
				value="<%=u.getNome() != null ? u.getNome() : ""%>">

			<label>E-mail</label>
			<input type="text" class="form-control" name="email"
				value="<%=u.getEmail() != null ? u.getEmail() : ""%>">

			<label>Login</label>
			<input type="text" class="form-control" name="login"
				value="<%=u.getLogin() != null ? u.getLogin() : ""%>">

			<label>Senha</label>
			<input type="password" class="form-control" name="senha"
				value="<%=u.getSenha() != null ? u.getSenha() : ""%>">
			<hr>
			<input type="hidden" name="operacao"
				value="<%=foiIncluido ? "alterar" : "incluir"%>"> <input
				type="submit" value="<%=foiIncluido ? "Atualizar" : "Gravar"%>" class="btn btn-outline-info">

			<hr>
		</form>
	</div>
</body>
</html>
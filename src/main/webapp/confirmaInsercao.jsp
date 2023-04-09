<%@page import="entidades.Pesquisa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-2">
		<div class="card">
			<div class="card-header">Dados inseridos com sucesso</div>
			<div class="card-body">
			<%
				Pesquisa pesquisa = (Pesquisa) request.getAttribute("pesquisa");
			%>
				<h5 class="card-title"><%= pesquisa.getNome() %></h5>
				<p class="card-text"><%= pesquisa.getEmail() %></p>
				<p class="card-text"><%= pesquisa.getSexo() %></p>				
				<p class="card-text"><%= pesquisa.getCivil() %></p>
				<p>Generos de filmes que gosta:</p>
				<p class="card-text"><%= pesquisa.getCheck1() == null ? "-" : pesquisa.getCheck1()  %></p>
				<p class="card-text"><%= pesquisa.getCheck2() == null ? "-" : pesquisa.getCheck2()  %></p>
				<p class="card-text"><%= pesquisa.getCheck3() == null ? "-" : pesquisa.getCheck3()  %></p>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>

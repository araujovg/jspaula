<%@page import="java.util.List"%>
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
	
	<div class="alert alert-success" role="alert">
	  Gravado com sucesso.
	</div>
		
	</div>
	
	<div class="container mt-2">
		<table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nome</th>
		      <th scope="col">Email</th>
		      <th scope="col">Sexo</th>
		      <th scope="col">Est. Civil</th>
		      <th scope="col">Pref. 1</th>
		      <th scope="col">Pref. 2</th>
		      <th scope="col">Pref. 3</th>
		    </tr>
		  </thead>
		  <tbody>
		  <% 
		  	List<Pesquisa> pesquisas = (List<Pesquisa>) request.getAttribute("pesquisas");
		  	for(Pesquisa pesquisa : pesquisas) {
		  %>
		    <tr>
		      <th scope="row"><%= pesquisa.getId() %></th>
		      <td><%= pesquisa.getNome() %></td>
		      <td><%= pesquisa.getEmail() %></td>
		      <td><%= pesquisa.getSexo() %></td>
		      <td><%= pesquisa.getCivil() %></td>
		      <td><%= pesquisa.getCheck1() == null ? "-" : pesquisa.getCheck1()  %></td>
		      <td><%= pesquisa.getCheck2() == null ? "-" : pesquisa.getCheck2()  %></td>
		      <td><%= pesquisa.getCheck3() == null ? "-" : pesquisa.getCheck3()  %></td>
		    </tr>
		    <%	
		    } 
		    %>
		  </tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>

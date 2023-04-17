<%@page import="java.util.List"%>
<%@page import="entidades.Pesquisa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			  <th scope="col">A��es</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${ pesquisas }" var="pesquisa">
			  <tr>
			      <th scope="row">${ pesquisa.id }</th>
			      <td>${ pesquisa.nome }</td>
			      <td>${ pesquisa.email }</td>
			      <td>${ pesquisa.sexo }</td>
			      <td>${ pesquisa.civil }</td>
				  <c:choose>
				  	<c:when test="${ pesquisa.check1 != null }">
						<td>${ pesquisa.check1 }</td>
					</c:when>
					<c:otherwise>
						<td> - </td>
					</c:otherwise>
				  </c:choose>

				  <c:choose>
				  	<c:when test="${ pesquisa.check2 != null }">
						<td>${ pesquisa.check2 }</td>
					</c:when>
					<c:otherwise>
						<td> - </td>
					</c:otherwise>
				  </c:choose>

				  <c:choose>
				  	<c:when test="${ pesquisa.check3 != null }">
						<td>${ pesquisa.check3 }</td>
					</c:when>
					<c:otherwise>
						<td> - </td>
					</c:otherwise>
				  </c:choose>

				  <td>
				  	<a class="btn btn-primary" href="/jspaula/PesquisaBuscaServlet?p_email=${ pesquisa.email }" role="button">Atualizar</a>
				  	<a class="btn btn-danger" href="/jspaula/PesquisaExcluirServlet?p_id=${ pesquisa.id }" role="button">Excluir</a>
				  </td>
			    </tr>
		  </c:forEach>

		  </tbody>
		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>

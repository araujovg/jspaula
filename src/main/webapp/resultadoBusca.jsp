<%@page import="entidades.Pesquisa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a class="btn btn-primary" href="/jspaula/ListaPesquisasServlet" role="button">Listar Pesquisas</a>
	<div class="container">
		<h1>Dados para pesquisa</h1>
	    <form action="/jspaula/PesquisaAtualizaServlet" method="post">
	    <input type="hidden" name="p_id" value="${ pesquisa.id }">
	    <div class="mb-3">
		  <label class="form-label">Nome</label>
		  <input type="text" name="p_nome" class="form-control" size="20" value="${ pesquisa.nome }>">
		</div>
		
		<div class="mb-3">
		  <label class="form-label">Email</label>
		  <input type="email" name="p_email" class="form-control" size="20" placeholder="name@example.com" value="${ pesquisa.email }">
		</div>
		
		<div class="card mb-3">
		 <div class="card-header">
		    Marque seu sexo
		  </div>
		  <div class="card-body">
		    <div class="form-check">
			  <input class="form-check-input" type="radio" name="p_sexo" value="masculino" checked="${ pesquisa.nome eq "masculino" }" value="masculino">
			  <label class="form-check-label">
			    Masculino
			  </label>
			</div>
		
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="p_sexo" value="feminino" checked="${ pesquisa.nome eq "feminino" }">
			  <label class="form-check-label">
			    Feminino
			  </label>
			</div>
		  </div>
		</div>
		
		<div class="card mb-3">
		 <div class="card-header">
		    Marque seu sexo
		  </div>
		  <div class="card-body">
		  	<div class="form-check">
			  <input class="form-check-input" type="checkbox" name="p_ck1" value="romance" ${ pesquisa.check1 != null ? "checked" : "" }>
			  <label class="form-check-label">
			    Romance
			  </label>
			</div>
			
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" name="p_ck2" value="aventura" ${ pesquisa.check2 != null ? "checked" : "" }>
			  <label class="form-check-label">
			    Aventura
			  </label>
			</div>
			
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" name="p_ck3" value="ficção" ${ pesquisa.check3 != null ? "checked" : "" }>
			  <label class="form-check-label">
			    Ficção
			  </label>
			</div>
		  </div>
	  </div>
		
		<div class="mb-3">
			<select class="form-select" name="p_civil">
			  <option value="solteiro(a)" ${ pesquisa.civil eq "solteiro(a)" ? "selected" : "" } >Solteiro</option>
			  <option value="casado(a)" ${ pesquisa.civil eq "casado(a)" ? "selected" : "" } >Casado</option>
			  <option value="viuvo(a)" ${ pesquisa.civil eq "viuvo(a)" ? "selected" : "" } >Viúvo</option>
			</select>
		</div>
	
	
	  	<button type="submit" class="btn btn-primary">Enviar</button>
	  	<button type="reset" class="btn btn-warning">Limpar</button>
	  	<a class="btn btn-danger" href="/jspaula/PesquisaExcluirServlet?p_id=${ pesquisa.id }" role="button">Excluir</a>
	
	    </form>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
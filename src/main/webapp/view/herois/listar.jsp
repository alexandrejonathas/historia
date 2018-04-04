<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
	
		<h4 id="h">Lista de Heróis</h4>
		
		<hr />
		

		<c:if test="${msg != null }" >
			<div class="alert alert-success alert-dismissible">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  ${msg}
			</div>
		</c:if>		
		
		
		<form action="<c:url value="/?cmd=PesquisarFilosofo" />" method="post">
		  <div class="form-group">
		    <label for="nome">Nome:</label>
		    <input type="text" class="form-control" id="nome" name="nome" />
		  </div>
		  <button type="submit" class="btn btn-info pull-right" >Pesquisar</button>			
		</form>		
		
		<a class="btn btn-success" href="<c:url value="/?cmd=NovoHeroi"/>">Adicionar</a>	
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Conhecido Por</th>
					<th>Habilidade</th>
					<th>Característica</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${herois}" var="h">
					<tr>
						<td>${h.id}</td>
						<td>${h.nome}</td>
						<td>${h.conhecidoPor}</td>
						<td>${h.habilidade}</td>
						<td>${h.caracteristica}</td>
						<td class="inline">
							<a class="btn btn-primary" href="<c:url value="/?cmd=EditarHeroi&id=${h.id}"/>">Editar</a>
							<form action="<c:url value="/?cmd=RemoverHeroi"/>" method="post">
								<input type="hidden" name="id" value="${h.id}" />
								<button class="btn btn-danger" type="submit">Excluir</button>
							</form>
							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</tags:template>
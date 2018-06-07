<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
	
		<h4 id="h" >Lista de Pinturas</h4>
		
		<hr />
		
		<c:if test="${msg != null }" >
			<div class="alert alert-success alert-dismissible">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  ${msg}
			</div>
		</c:if>		
		
		
		<form action="<c:url value="/?cmd=PesquisarPintura" />" method="post">
		  <div class="form-group">
		    <label for="nome">Nome:</label>
		    <input type="text" class="form-control" id="nome" name="nome" />
		  </div>
		  <button type="submit" class="btn btn-info pull-right" >Pesquisar</button>			
		</form>	
		<a class="btn btn-success" href="<c:url value="/?cmd=NovaPintura"/>">Adicionar</a>
		<div class="table-responsive"> 
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Autor</th>
						<th>Ano</th>
						<th>Valor</th>
						<th class="col-md-2"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pinturas}" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.nome}</td>
							<td>${p.autor}</td>
							<td>${p.ano}</td>
							<td>${p.valor}</td>
							<td class="inline">
								<a class="btn btn-primary" href="<c:url value="/?cmd=EditarPintura&id=${p.id}"/>">Editar</a>
								<form action="<c:url value="/?cmd=RemoverPintura"/>" method="post">
									<input type="hidden" name="id" value="${p.id}" />
									<button class="btn btn-danger" type="submit">Excluir</button>
								</form> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</jsp:attribute>
</tags:template>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
	
		<h4 id="h" >Lista de Pinturas</h4>
		
		<hr />
		
		<a class="btn btn-success" href="<c:url value="/pinturas/manutencao"/>">Adicionar</a>
		<div class="table-responsive"> 
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Autor</th>
						<th>Ano</th>
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
							<td>
								<a class="btn btn-primary" href="<c:url value="/pinturas/manutencao?id=${p.id}"/>">Editar</a>
								<a class="btn btn-danger" href="<c:url value="/pinturas/excluir?id=${p.id}"/>">Excluir</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</jsp:attribute>
</tags:template>
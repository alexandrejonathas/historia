<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
	
		<h4 id="h">Lista de Filósofos</h4>
		
		<hr />
		
		<a class="btn btn-success" href="<c:url value="/filosofos/manutencao"/>">Adicionar</a>	
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Nascimento</th>
					<th>Morte</th>
					<th>Característica</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${filosofos}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.nome}</td>
						<td>${p.nascimento}</td>
						<td>${p.morte}</td>
						<td>${p.caracteristica}</td>
						<td>
								<a class="btn btn-primary" href="<c:url value="/filosofos/manutencao?id=${p.id}"/>">Editar</a>
								<a class="btn btn-danger" href="<c:url value="/filosofos/remover?id=${p.id}"/>">Excluir</a>
							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</tags:template>
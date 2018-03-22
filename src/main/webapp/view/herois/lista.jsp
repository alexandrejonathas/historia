<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
	
		<h4 id="h">Lista de Heróis</h4>
		
		<hr />
		
		<a class="btn btn-success" href="<c:url value="/herois/manutencao"/>">Adicionar</a>	
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Conhecido Por</th>
					<th>Habilidade</th>
					<th>Caracteristica</th>
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
						<td>
								<a class="btn btn-primary" href="<c:url value="/herois/manutencao?id=${h.id}"/>">Editar</a>
								<a class="btn btn-danger" href="<c:url value="/herois/remover?id=${h.id}"/>">Excluir</a>
							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</tags:template>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
	
		<h4>Lista de Pinturas</h4>
		
		<hr />
		
		<a href="<c:url value="/pinturas/manutencao"/>">Adicionar</a>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Autor</th>
					<th>Ano</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pinturas}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.nome}</td>
						<td>${p.autor}</td>
						<td>${p.ano}</td>
						<td><a href="<c:url value="/pinturas/manutencao?id=${p.id}"/>">Editar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</tags:template>
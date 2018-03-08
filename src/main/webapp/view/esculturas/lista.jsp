<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
		
		<h4>Lista de Esculturas</h4>
		
		<hr />
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Autor</th>
					<th>Ano</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${esculturas}" var="e">
					<tr>
						<td>${e.id}</td>
						<td>${e.nome}</td>
						<td>${e.autor}</td>
						<td>${e.ano}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</tags:template>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
		
		<form class="form-horizontal" action="<c:url value="/pinturas/manutencao" />" method="post">
		  <input type="hidden" name="id" value="${pintura.id}" />
		  <div class="form-group">
		    <label for="nome">Nome:</label>
		    <input type="text" class="form-control" id="nome" name="nome" value="${pintura.nome}" />
		  </div>
		  <div class="form-group">
		    <label for="autor">Autor:</label>
		    <input type="text" class="form-control" id="autor" name="autor" value="${pintura.autor}" />
		  </div>
		  <div class="form-group">
		    <label for="ano">Ano:</label>
		    <input type="text" class="form-control" id="ano" name="ano" value="${pintura.ano}"/>
		  </div>
		  <button type="submit" class="btn btn-success">Salvar</button>		
		</form>
		
	</jsp:attribute>
</tags:template>
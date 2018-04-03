<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">

		<h4 id="h" >Editar Escultura</h4>
		
		<hr />			
		<c:if test="${msg != null}" >
			<div class="alert alert-success alert-dismissible">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  ${msg}
			</div>
		</c:if>		
		
		<form class="form-horizontal" action="<c:url value="/?cmd=AlterarEscultura" />" method="post">
		  <input type="hidden" name="id" value="${escultura.id}" />
		  <div class="form-group">
		    <label for="nome">Nome:</label>
		    <input type="text" class="form-control" id="nome" name="nome" value="${escultura.nome}" />
		  </div>
		  <div class="form-group">
		    <label for="ano">Ano:</label>
		    <input type="text" class="form-control" id="ano" name="ano" value="${escultura.ano}"/>
		  </div>	  
		  <div class="form-group">
		    <label for="longitude">Longitude:</label>
		    <input type="text" class="form-control" id="longitude" name="longitude" value="${escultura.longitude}"/>
		  </div>
		  <div class="form-group">
		    <label for="latitude">Latitude:</label>
		    <input type="text" class="form-control" id="latitude" name="latitude" value="${escultura.latitude}"/>
		  </div>		  		  		  
		  <div class="form-group">
		    <label for="autor">Autor:</label>
		    <input type="text" class="form-control" id="autor" name="autor" value="${escultura.autor}" />
		  </div>
		  <button type="submit" class="btn btn-success">Salvar</button>		
		</form>
		
	</jsp:attribute>
</tags:template>
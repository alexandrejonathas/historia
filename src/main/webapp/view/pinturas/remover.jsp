<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
		
		<h4 id="h" >Remover Pintura</h4>
		
		<hr />		
		
		<c:if test="${msg != null}" >
			<div class="alert alert-success alert-dismissible">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  ${msg}
			</div>
		</c:if>				
		
		<form class="form-horizontal" action="<c:url value="/pinturas/remover" />" method="post">
		  <input type="hidden" name="id" value="${pintura.id}" />
		  <div class="form-group">
		    <label for="nome">Nome:</label>
		    <input type="text" disabled="disabled" class="form-control" id="nome" name="nome" value="${pintura.nome}" />
		  </div>
		  <div class="form-group">
		    <label for="autor">Autor:</label>
		    <input type="text" disabled="disabled" class="form-control" id="autor" name="autor" value="${pintura.autor}" />
		  </div>
		  <div class="form-group">
		    <label for="ano">Ano:</label>
		    <input type="text" disabled="disabled" class="form-control" id="ano" name="ano" value="${pintura.ano}"/>
		  </div>
		  <div class="form-group">
		    <label for="valor">Valor:</label>
		    <input type="text" disabled="disabled" class="form-control" id="valor" name="valor" value="${pintura.valor}"/>
		  </div>	  		  		  		  
		  <button type="submit" class="btn btn-success">Remover</button>		
		</form>
		
	</jsp:attribute>
</tags:template>
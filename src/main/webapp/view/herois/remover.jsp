<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
		
		<h4 id="h" >Remover Heroi</h4>
		
		<hr />			
		
		<c:if test="${msg != null}" >
			<div class="alert alert-success alert-dismissible">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  ${msg}
			</div>
		</c:if>		
		
		<form class="form-horizontal" action="<c:url value="/herois/remover" />" method="post">
		  <input type="hidden" name="id" value="${heroi.id}" />
		  <div class="form-group">
		    <label for="nome">Nome:</label>
		    <input type="text" disabled="disabled" class="form-control" id="nome" name="nome" value="${heroi.nome}" />
		  </div>
		  <div class="form-group">
		    <label for="conhecidoPor">Conhecido Por:</label>
		    <input type="text" disabled="disabled" class="form-control" id="conhecidoPor" name="conhecidoPor" value="${heroi.conhecidoPor}" />
		  </div>
		  <div class="form-group">
		    <label for="habilidade">Habilidade:</label>
		    <input type="text" disabled="disabled" class="form-control" id="habilidade" name="habilidade" value="${heroi.habilidade}"/>
		  </div>
		  <div class="form-group">
		    <label for="caracteristica">Caracteristica:</label>
		    <input type="text" disabled="disabled" class="form-control" id="caracteristica" name="caracteristica" value="${heroi.caracteristica}"/>
		  </div>
		  <button type="submit" class="btn btn-danger">Deletar</button>		
		</form>
		
	</jsp:attribute>
</tags:template>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template>
	<jsp:attribute name="body">
		
		<h4 id="h" >Remover Filosofo</h4>
		
		<hr />			
		
		<c:if test="${msg != null}" >
			<div class="alert alert-success alert-dismissible">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  ${msg}
			</div>
		</c:if>		
		
		<form class="form-horizontal" action="<c:url value="/filosofos/remover" />" method="post">
		  <input type="hidden" name="id" value="${filosofo.id}" />
		  <div class="form-group">
		    <label for="nome">Nome:</label>
		    <input type="text" disabled="disabled" class="form-control" id="nome" name="nome" value="${filosofo.nome}" />
		  </div>
		  <div class="form-group">
		    <label for="conhecidoPor">Conhecido Por:</label>
		    <input type="text" disabled="disabled" class="form-control" id="conhecidoPor" name="conhecidoPor" value="${filosofo.conhecidoPor}" />
		  </div>
		  <div class="form-group">
		    <label for="nascimento">Nascimento:</label>
		    <input type="text" disabled="disabled" class="form-control" id="nascimento" name="nascimento" value="${filosofo.nascimento}"/>
		  </div>
		  <div class="form-group">
		    <label for="morte">Morte:</label>
		    <input type="text" disabled="disabled" class="form-control" id="morte" name="morte" value="${filosofo.morte}"/>
		  </div>
		  <div class="form-group">
		    <label for="caracteristica">Caracteristica:</label>
		    <input type="text" disabled="disabled" class="form-control" id="caracteristica" name="caracteristica" value="${filosofo.caracteristica}"/>
		  </div>
		  <button type="submit" class="btn btn-danger">Deletar</button>		
		</form>
		
	</jsp:attribute>
</tags:template>
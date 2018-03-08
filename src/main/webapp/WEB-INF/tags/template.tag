<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" type="text/stylesheet">
	<title>História</title>
</head>
<body>
     <nav class="navbar navbar-default">
       <div class="container">
         <div class="navbar-header">
           <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
             <span class="sr-only">Toggle navigation</span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
           </button>
           <a class="navbar-brand" href="#">Histórias</a>
         </div>
         <div id="navbar" class="navbar-collapse collapse">
           <ul class="nav navbar-nav navbar-right">
             <li class="active"><a href="<c:url value="/"/>">Home</a></li>
   	   		 <li><a href="<c:url value="/pinturas"/>">Pinturas</a></li>       		                     		
             <li><a href="<c:url value="/esculturas"/>">Esculturas</a></li>                              	            
           </ul>
         </div><!--/.nav-collapse -->
       </div><!--/.container-fluid -->
     </nav>	
    
	<div class="container">
		<jsp:invoke fragment="body" />
	</div>
	
	<div id="footer" class="footer navbar-fixed-bottom">
		<div class="container text-center">
			<span class="text-muted">Projeto desenvolvido na disciplina de Laboratorio de Desenvolvimento de Software OO</span>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value="/resources/jQuery/jquery-3.1.1.slim.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>"> </script>
</body>
</html>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true"%>
<%@attribute name="body" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"  media="all" />
	<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" /> -->
<title>História</title>
<style>
<%@ include file="../../resources/css/bootstrap.min.css" %>
<%@ include file="../../resources/css/style.css" %>
</style>
<script>
	
<%@ include file="../../resources/js/jquery-3.1.1.min.js" %>
	
<%@ include file="../../resources/js/bootstrap.js" %>
	
</script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Histórias</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="<c:url value="/"/>">Home</a></li>
					<li><a href="<c:url value="/pinturas"/>">Pinturas</a></li>
					<li><a href="<c:url value="/esculturas"/>">Esculturas</a></li>
					<li><a href="<c:url value="/herois"/>">Herois</a></li>
					<li><a href="<c:url value="/filosofos"/>">Filosofos</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</nav>

	<div class="wrapper" role="main">
		<div class="container">
			<div class="row">
				<script type="text/javascript">
					$(document).ready(function() {

						$("h1").click(function() {
							alert("Teste");
						})
					})
				</script>
				<jsp:invoke fragment="body" />
			</div>
		</div>
	</div>
	<footer>
		<div class="copyright">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<p class="copyright-text">&copy; Sistema desenvolvido na
							cadeira de Laboratório de Desenvolvimento de Sistemas.</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>
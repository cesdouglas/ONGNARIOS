<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML>

<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<title>ONGNários</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<script>
	$(window).load(function() {
		$('.mensagens').slideDown(3000, function(){
			$(this).slideUp(6000, 'swing');			
		});

	});
</script>
<style>
	.mensagens{
		position: absolute;
		vertical-align: middle;
		border: 2px solid #c30;
		text-align: center;
		display: none;
		background-color: #37C0FB;
		width: 100%;
		height: auto;
		z-index: 2;
		font-size: 20px;
		font-weight: bold;
	}
</style>
</head>
<body>
		<div class="mensagens">
			<p>${msg}</p>
			<p>${msg2}</p>
		</div>

	<div id="page-wrapper">
		<!-- Login -->

		<c:if test="${!empty empresa.nm_empresa}">
			<div style="position: absolute; right: 170px; top: 12px;">
				<p>Olá ${empresa.nm_empresa}!</p>
			</div>
		</c:if>
		<c:if test="${!empty usuario.nm_usuario}">
			<div style="position: absolute; right: 170px; top: 12px;">
				<p>Olá ${usuario.nm_usuario}!</p>
			</div>
		</c:if>
		<c:if test="${!empty empresa.nr_cnpj}">
			<div id="button_log">
				<a href="cadastro_vaga.jsp" class="button"
					style="right: 300px; top: 44px; position: absolute;">Cadastrar
					Vaga</a>
			</div>
		</c:if>
		<c:if test="${empty logado}">
			<div id="button_log">
				<a href="login.jsp" class="button"
					style="right: 50px; top: 44px; position: absolute;">Login</a>
			</div>
		</c:if>
		<!-- Logout -->
		<c:if test="${logado == 'sim'}">
			<div id="button_log">
				<form action="midlet" method="post">
					<input type="hidden" name="form" value="logout"> <input
						type="submit" value="Logout"
						style="background: red; right: 50px; top: 44px; position: absolute;">
				</form>
			</div>
		</c:if>


		<!-- Header -->
		<div id="header">

			<!-- Logo -->
			<h1>
				<a href="index.jsp" id="logo">ONG<em>nários</em></a>
			</h1>
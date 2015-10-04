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
		$('.mensagens').slideDown(2000, function(){
			$(this).slideUp(6000, 'swing');			
		});
		$('.mensagens2').slideDown(2000, function(){
			$(this).slideUp(6000, 'swing');			
		});

	});
	
</script>
<style>
.mensagens, .mensagens2 {
	position: absolute;
	vertical-align: middle;
	text-align: center;
	display: none;
	background-color: #37C0FB;
	width: 100%;
	z-index: 2;
	font-size: 20px;
	font-weight: bold;
	height: 30px;
	max-height: 64px;
}
.mensagens2{
	top: 30px;
}
</style>
</head>
<body>
	<c:if test="${!empty msg}">
		<span class="mensagens">
			<p>${msg}</p>
		</span>
	</c:if>
	<c:if test="${!empty msg2}">
		<span class="mensagens2">
			<p>${msg2}</p>
		</span>
	</c:if>

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

		<!-- Header -->
		<div id="header">

			<!-- Logo -->
			<h1>
				<a href="index.jsp" id="logo">ONG<em>nários</em></a>
			</h1>
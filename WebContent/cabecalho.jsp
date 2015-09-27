<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<title>ONGN�rios</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />

</head>
<body>
	<div id="page-wrapper">
		<!-- Login -->
		<c:if test="${empty logado}">
			<div id="button_log">
				<a href="login.jsp" class="button" style="right: 50px; top: 44px; position: absolute;">Login</a>
			</div>
		</c:if>
		<!-- Logout -->
		<c:if test="${logado == 'true'}">
			<div id="button_log">
				<form action="midlet" method="post">
					<input type="hidden" name="form" value="logout">		
					<input type="submit" value="Logout" style="background: red" style="right: 50px; top: 44px; position: absolute;">							
				</form>
			</div>
		</c:if>
		

		<!-- Header -->
		<div id="header">

			<!-- Logo -->
			<h1>
				<a href="index.html" id="logo">ONG<em>n�rios</em></a>
			</h1>


	
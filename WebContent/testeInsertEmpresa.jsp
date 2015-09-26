<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teste insert</title>
</head>
<body>
	<form action="midlet" method="get">
		cnpj<input type="text" name="cnpj"><br>
		nome<input type="text" name="nome"><br>
		endereco<input type="text" name="endereco"><br>
		telefone<input type="text" name="telefone"><br>
		ddd<input type="text" name="ddd"><br>
		email<input type="text" name="email"><br>
		senha<input type="text" name="senha"><br>
		<input type="submit">	
	</form>
	<p>${msg}<p>
</body>
</html>
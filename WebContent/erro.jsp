<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.jsp"%>
<nav id="nav">
	<ul>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="parceiros.jsp">Parceiros</a></li>
		<li><a href="perfil.jsp">Perfil</a></li>
		<li><a href="vagas.jsp">Vagas</a></li>
		<c:if test="${empty logado}">
			<li><a href="cadastro.jsp">Cadastre-se</a></li>
			<li><a href="login.jsp">Login</a></li>
		</c:if>
		<c:if test="${!empty empresa.nr_cnpj}">
			<li><a href="cadastro_vaga.jsp">Cadastrar Vaga</a></li>
		</c:if>
		<!-- Logout -->
		<c:if test="${logado == 'sim'}">
			<li><a href="midlet?form=logout">Logout</a>
		</c:if>
		</div>

	</ul>
</nav>

</div>



<!-- Vagas em destaque -->
<section class="wrapper style1">
	<div class="container">
		<div class="row 200%">
			<section class="12u 6u(narrower)">
				<div class="box highlight">
					<i class="icon major fa-exclamation-triangle"></a></i>
					<h3>
						ERRO! <br> Página não encontrada!
					</h3>
				</div>
			</section>
		</div>
	</div>
</section>


<%@ include file="rodape.jsp"%>
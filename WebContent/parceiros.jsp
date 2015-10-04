<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.jsp"%>
<nav id="nav">
	<ul>
		<li><a href="index.jsp">Home</a></li>
		<li class="current"><a href="parceiros.jsp">Parceiros</a></li>
		<li><a href="perfil.jsp">Perfil</a></li>
		<li><a href="vagas.jsp">Vagas</a></li>
		<c:if test="${empty logado}">
			<li><a href="cadastro.jsp">Cadastre-se</a></li>
			<li><a href="login.jsp">Login</a></li>
		</c:if>
		<c:if test="${!empty empresa.nr_cnpj}">
				<li><a href="cadastro_vaga.jsp">Cadastrar Vaga</a></li>
		</c:if>
	</ul>
</nav>

</div>

<!-- Uma mudança gigantesca -->
<section class="wrapper style2">
	<div class="container">
		<header class="major">
			<h2>Seja um parceiro!</h2>
			<p>Vamos juntos, fazer a diferença.</p>
		</header>
	</div>
</section>

<!-- Vagas -->
<section class="wrapper style1">
	<div class="container">
		<div class="row">


			<section class="6u 12u(narrower)">
				<div class="box post">
					<a href="#" class="image left"><img
						src="images/logo-adoteumgatinho.jpg" alt="" /></a>
					<div class="inner">
						<h3>Adote um Gatinho</h3>
						<p>ONG voltada para o resgate e tratamento de gatos de rua.</p>

					</div>
				</div>
			</section>


			<section class="6u 12u(narrower)">
				<div class="box post">
					<a href="#" class="image left"><img
						src="images/preview-Funda%C3%A7%C3%A3o_Roberto_Marinho_Rede_Globo.png"
						alt="" /></a>
					<div class="inner">
						<h3>Fundação Roberto Marinho</h3>
						<p>Fundação com foco na profissionalização de pessoas
							carentes.</p>
					</div>
				</div>
			</section>
		</div>
		<div class="row">
			<section class="6u 12u(narrower)">
				<div class="box post">
					<a href="#" class="image left"><img src="images/347.jpg" alt="" /></a>
					<div class="inner">
						<h3>Green Peace</h3>
						<p>ONG voltada para a proteção ambiental.</p>

					</div>
				</div>
			</section>
			<section class="6u 12u(narrower)">
				<div class="box post">
					<a href="#" class="image left"><img
						src="images/Rotaract_color_regular.jpg" alt="" /></a>
					<div class="inner">
						<h3>Rotaract</h3>
						<p>Grupo de apoio a ONGs.
					</div>
				</div>
			</section>
		</div>
	</div>
</section>




<%@ include file="rodape.jsp"%>
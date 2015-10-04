<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="cabecalho.jsp"%>

<nav id="nav">
	<ul>
		<li class="current"><a href="index.jsp">Home</a></li>
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
	</ul>
</nav>

</div>

<!-- Banner -->
<section id="banner">
	<header>
		<h2>
			Rotaract: <em> Junte-se a um grupo e faça a diferença! <a
				href="vagas.jsp"></a></em>
		</h2>
		<a href="vagas.jsp" class="button">Inscreva-se</a>
	</header>
</section>

<!-- Vagas em destaque -->
<section class="wrapper style1">
	<div class="container">
		<div class="row 200%">
			<section class="4u 12u(narrower)">
				<div class="box highlight">
					<i class="icon major fa-heart"></a></i>
					<h3>
						Seja voluntário <br> na AACD
					</h3>
					<p>Ajude com a reabilitação das crianças na AACD, você pode
						desenpenhar diversas atividades.</p>
					<a href="vagas.jsp" class="button">Inscreva-se</a>
				</div>
			</section>
			<section class="4u 12u(narrower)">
				<div class="box highlight">
					<i class="icon major fa-comment"></a></i>
					<h3>
						Sopão para os <br> moradores de rua
					</h3>
					<p>Ajude a comunidade carente, procura-se voluntários para
						ajudar com o sopão dos moradores de rua do Rio de Janeiro.</p>
					<a href="vagas.jsp" class="button">Inscreva-se</a>
				</div>
			</section>
			<section class="4u 12u(narrower)">
				<div class="box highlight">
					<i class="icon major fa-check-circle"></a></i>
					<h3>
						Faça a alegria de <br> uma criança com câncer
					</h3>
					<p>O grupo Palhaços da alegria busca voluntários para atuar nos
						hospitáis de São Paulo. Faça a diferença.</p>
					<a href="vagas.jsp" class="button">Inscreva-se</a>
				</div>
			</section>
		</div>
	</div>
</section>



<%@ include file="rodape.jsp"%>

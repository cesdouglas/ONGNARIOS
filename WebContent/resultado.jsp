<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.jsp"%>
<nav id="nav">
	<ul>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="parceiros.jsp">Parceiros</a></li>
		<li><a href="perfil.jsp">Perfil</a></li>
		<li><a href="vagas.jsp">Vagas</a></li>
		<li><a href="cadastro.jsp">Cadastre-se</a></li>
	</ul>
</nav>
</div>



<!-- Uma mudança gigantesca -->
<section class="wrapper style2">
	<div class="container">
		<header class="major">
			<form action="midlet" method="get">
				<input type="search" name="search" required="required"
					placeholder="Buscar Vaga"> <input type="hidden" name="form"
					value="buscarVaga"> <input type="submit" value="buscar">
			</form>
			<h2>Seja a mudança que você quer ver no mundo.</h2>
			<p>Ser feliz é fazer as pessoas felizes.</p>
		</header>
		<center>
			<form action="midlet" method="post">
				<input type="hidden" name="form" value="carregarVagas"> <input
					type="submit" value="Ver todas as vagas"
					style="background-color: green">
			</form>
		</center>
	</div>
</section>

<!-- Vagas -->
<section class="wrapper style1">
	<div class="container">
		<div class="row">

			<c:forEach var="n" items="${vagas}">
				<section class="6u 12u(narrower)">
					<div class="box post">
						<a href="#" class="image left"><img
							src="images/logo-adoteumgatinho.jpg" alt="" /></a>
						<div class="inner">
							<h3>${n.nm_vaga}</h3>
							<p>
								Descrição: ${n.ds_vaga}<br> Salário: ${n.vl_salario}<br>
								CNPJ: ${n.t_ONG_EMPRESA_nr_cnpj}
							</p>
							<c:if test="${!empty usuario.nr_cpf}">
								<c:if test="${empty n.t_ONG_USUARIO_nr_cpf}">
									<form action="midlet" method="post">
										<input type="hidden" name="form" value="inscrever">
										<input type="hidden" name="cpf" value="${usuario.nr_cpf}">
										<input type="hidden" name="id" value="${n.cd_vaga}"> <input
											type="submit" style="background-color: #37c0fb"
											value="Inscreva-se">
									</form>
								</c:if>
								<c:if test="${usuario.nr_cpf == n.t_ONG_USUARIO_nr_cpf}">
									<form action="midlet" method="post">
										<input type="hidden" name="form" value="desinscrever">
										<input type="hidden" name="id" value="${n.cd_vaga}">
										<input type="submit" style="background-color: red"
											value="Desinscrever-se">
									</form>
								</c:if>	
							</c:if>
						</div>
					</div>
				</section>
			</c:forEach>

		</div>
	</div>
	<c:if test="${empty vagas}">
		<center>
			<h4>Sua busca não retornou nenhum resultado.</h4>
		</center>
	</c:if>
</section>




<%@ include file="rodape.jsp"%>
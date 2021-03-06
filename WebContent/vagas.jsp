<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.jsp"%>
<nav id="nav">
	<ul>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="parceiros.jsp">Parceiros</a></li>
		<li><a href="perfil.jsp">Perfil</a></li>
		<li class="current"><a href="vagas.jsp">Vagas</a></li>
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
	</ul>
</nav>
</div>




<!-- Uma mudan�a gigantesca -->
<section class="wrapper style2">
	<div class="container">
		<header class="major">
			<form action="midlet" method="get">
				<input type="search" name="search" required="required"
					placeholder="Buscar Vaga"> <input type="hidden" name="form"
					value="buscarVaga"> <input type="submit" value="buscar">
			</form>
			<h2>Seja a mudan�a que voc� quer ver no mundo.</h2>
			<p>Ser feliz � fazer as pessoas felizes.</p>
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
			<c:forEach var="n" items="${vagas}" varStatus="loop">
				<section class="6u 12u(narrower)">
					<div class="box post">
						<c:if test="${loop.index == 0}">
							<a href="#" class="image left"><img
								src="images/logo-adoteumgatinho.jpg" alt="" /></a>
						</c:if>
						<c:if test="${loop.index == 1}">
							<a href="#" class="image left"><img
								src="images/preview-Funda��o_Roberto_Marinho_Rede_Globo.png"
								alt="" /></a>
						</c:if>
						<c:if test="${loop.index == 2}">
							<a href="#" class="image left"><img
								src="images/Rotaract_color_regular.jpg" alt="" /></a>
						</c:if>
						<c:if test="${loop.index == 3}">
							<a href="#" class="image left"><img
								src="images/aacd_logo1.png" alt="" /></a>
						</c:if>
						<c:if test="${loop.index == 4}">
							<a href="#" class="image left"><img src="images/347.jpg"
								alt="" /></a>
						</c:if>
						<c:if test="${loop.index > 4}">
							<a href="#" class="image left"><img
								src="images/logo-adoteumgatinho.jpg" alt="" /></a>
						</c:if>
						<div class="inner">
							<h3>${n.nm_vaga}</h3>
							<p>
								Descri��o: ${n.ds_vaga}<br> Sal�rio:
								<fmt:formatNumber value="${n.vl_salario}" type="currency" />
								<br> CNPJ: ${n.t_ONG_EMPRESA_nr_cnpj}
								<c:if test="${!empty n.t_ONG_USUARIO_nr_cpf && usuario.nr_cpf != n.t_ONG_USUARIO_nr_cpf}">
									<br/><b>N�mero de inscri��es excedido !</b>
								</c:if>
							</p>
							<c:if test="${!empty usuario.nr_cpf}">
								<c:if test="${empty n.t_ONG_USUARIO_nr_cpf}">
									<form action="midlet" method="post">
										<input type="hidden" name="form" value="inscrever"> <input
											type="hidden" name="cpf" value="${usuario.nr_cpf}"> <input
											type="hidden" name="id" value="${n.cd_vaga}"> <input
											type="submit" style="background-color: #37c0fb"
											value="Inscreva-se">
									</form>
								</c:if>
								<c:if test="${usuario.nr_cpf == n.t_ONG_USUARIO_nr_cpf}">
									<form action="midlet" method="post">
										<input type="hidden" name="form" value="desinscrever">
										<input type="hidden" name="id" value="${n.cd_vaga}"> <input
											type="submit" style="background-color: red"
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
</section>




<%@ include file="rodape.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.jsp" %>
			<nav id="nav">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="parceiros.jsp">Parceiros</a></li>
					<li><a href="perfil.jsp">Perfil</a></li>
					<li><a href="vagas.jsp">Vagas</a></li>
					<li><a href="cadastro.jsp">Cadastre-se</a></li>
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


	<!-- Footer -->
	<div id="footer">
		<div class="container">
			<div class="row">
				<section class="3u 6u(narrower) 12u$(mobilep)">
					<h3>Parceiros</h3>
					<ul class="links">
						<li><a href="#">AACD</a></li>
						<li><a href="#">Adote um Gatinho</a></li>
						<li><a href="#">Rotaract</a></li>
						<li><a href="#">Fundação Roberto Marinho</a></li>
						<li><a href="#">Green Peace</a></li>
						<li><a href="#">Fundação Airton Senna</a></li>
					</ul>
				</section>
				<section class="3u 6u$(narrower) 12u$(mobilep)">
					<h3>Dúvidas Frequêntes</h3>
					<ul class="links">
						<li><a href="duvidas.jsp">Quem somos</a></li>
						<li><a href="duvidas.jsp">Como ajudar</a></li>
						<li><a href="duvidas.jsp">Parcerias</a></li>
						<li><a href="duvidas.jsp">Como se candidatar</a></li>
						<li><a href="duvidas.jsp">Responsabilidades</a></li>
						<li><a href="duvidas.jsp">Eventos</a></li>
					</ul>
				</section>
				<section class="6u 12u(narrower)">
					<h3>Entre em contato</h3>
					<form>
						<div class="row 50%">
							<div class="6u 12u(mobilep)">
								<input type="text" name="name" id="name" placeholder="Nome" />
							</div>
							<div class="6u 12u(mobilep)">
								<input type="email" name="email" id="email" placeholder="Email" />
							</div>
						</div>
						<div class="row 50%">
							<div class="12u">
								<textarea name="message" id="message" placeholder="Mensagem"
									rows="5"></textarea>
							</div>
						</div>
						<div class="row 50%">
							<div class="12u">
								<ul class="actions">
									<li><input type="submit" class="button alt"
										value="Enviar Mensagem" /></li>
								</ul>
							</div>
						</div>
					</form>
				</section>
			</div>
		</div>

	<%@ include file="rodape.jsp" %>
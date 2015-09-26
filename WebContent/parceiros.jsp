<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



    <!DOCTYPE HTML>

<html>
	<head>
		<title>ONGNários</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		
	</head>
	<body>
		<div id="page-wrapper">
        
			<!-- Login -->
            <div id="login">
                        <a href="login.jsp" class="button">Login</a></div>
            
            <!-- Header -->
				<div id="header">                    

					<!-- Logo -->
						<h1><a href="index.jsp" id="logo">ONG <em>Nários</em></a></h1>  
                    	
                    <!-- Cabeçalho -->
                                                         
						<nav id="nav">
							<ul>
								<li><a href="index.jsp">Home</a></li>
								<li class="current"><a href="parceiros.jsp">Parceiros</a></li>
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
									<a href="#" class="image left"><img src="images/logo-adoteumgatinho.jpg" alt="" /></a>
									<div class="inner">
										<h3>Adote um Gatinho</h3>
										<p> ONG voltada para o resgate e tratamento de gatos de rua.</p>
										
									</div>
								</div>
							</section>
                            
                            
							<section class="6u 12u(narrower)">
								<div class="box post">
									<a href="#" class="image left"><img src="images/preview-Funda%C3%A7%C3%A3o_Roberto_Marinho_Rede_Globo.png" alt="" /></a>
									<div class="inner">
										<h3>Fundação Roberto Marinho</h3>
										<p> Fundação com foco na profissionalização de pessoas carentes.</p>
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
										<p> ONG voltada para a proteção ambiental.</p>
                                       
									</div>
								</div>
							</section>
							<section class="6u 12u(narrower)">
								<div class="box post">
									<a href="#" class="image left"><img src="images/Rotaract_color_regular.jpg" alt="" /></a>
									<div class="inner">
										<h3>Rotaract</h3>
										<p> Grupo de apoio a ONGs.
									</div>
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
                                            <textarea name="message" id="message" placeholder="Mensagem" rows="5"></textarea>
										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<ul class="actions">
                                                <li><input type="submit" class="button alt" value="Enviar Mensagem"/></li>
											</ul>
										</div>
									</div>
								</form>
							</section>
						</div>
					</div>

					<!-- Rodapé-->
                    <!-- Icons -->
						<ul class="icons">                        
							<li><a href="erro.jsp" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="erro.jsp" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="erro.jsp" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
                            <li><a href="erro.jsp" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						</ul>

					<!-- Copyright -->
						<div class="copyright">
							<ul class="menu">
								<li>&copy; Untitled. All rights reserved</li><li>Design: LDBL</a></li>
							</ul>
						</div>

				</div>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>
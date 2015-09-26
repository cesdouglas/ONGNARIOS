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
								<li><a href="parceiros.jsp">Parceiros</a></li>
                                <li class="current"><a href="perfil.jsp">Perfil</a></li>
								<li><a href="vagas.jsp">Vagas</a></li>
                                <li ><a href="cadastro.jsp">Cadastre-se</a></li>
                                
							</ul>
						</nav>

				</div>

			
		
			<!-- Footer -->
				<div id="footer">
					<div class="container">
						<div class="row">
                            
                            <section class="6u 12u$(narrower) 12u$(mobilep)">
                                <div class="box highlight">
                                      <i class="icon major fa-pencil"></a></i>  
							
                                <h3>Seja Bem-Vindo! "Colocar o nome da Pessoa"</h3>
                                <p> 
                                Caso deseje atualizar seus dados, basta modificar no campo ao lado e clicar em atualizar.<br>
                                Mostrar aqui os dados salvos da pessoa.
                                </p>
                                
							</section>
                            
							
							<section class="6u 12u(narrower)">
                                <h3>Alterar Cadastro</h3>
                                
                                <!--Cadastro-->
								<form>
									
                                    <div class="row 50%">
										<div class="6u 12u(mobilep)">
											
                                            
                                            <input type="text" name="name" id="name" placeholder="Nome" />
								</div>
                                        
                                        
                                        
										<div class="6u 12u(mobilep)">								
                                            
                                            <input type="text" name="sobrenome" id="sobrenome" placeholder="Sobrenome" />
										</div>
									
                                    
                                   		<div class="6u 12u(mobilep)">
											<input type="text" name="CPF" id="cpf" placeholder="CPF" />
										</div>	
                            
										<div class="6u 12u(mobilep)">
											<input type="text" name="email" id="email" placeholder="Email" /> 
                                        </div>
                                        
                                            <div class="6u 12u(mobilep)">
											<input type="text" name="endereco" id="endereco" placeholder="Endereço"/>
                                        </div>
                                    
                                        <div class="6u 12u(mobilep)">
											<input type="text" name="senha" id="senha" placeholder="Senha" />
                                        </div>
                                        <div class="row 50%">
										<div class="12u">
											<ul class="actions">
                                                <li><input type="submit" class="button alt" value="Cadastrar"/></li>
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
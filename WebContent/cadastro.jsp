<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE HTML>
<html>
	<head>
		<title>ONGNários</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
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
                                <li><a href="perfil.jsp">Perfil</a></li>
								<li><a href="vagas.jsp">Vagas</a></li>
                                <li class="current"><a href="cadastro.jsp">Cadastre-se</a></li>
                                
							</ul>
						</nav>

				</div>

			
		
			<!-- Footer -->
				<div id="footer">
					<div class="container">
						<div class="row">
                            
                            <section class="6u 12u$(narrower) 12u$(mobilep)">
                                <div class="box highlight">
                                      <i class="icon major fa-hand-peace-o"></a></i>  
							
                                <h3>Seja um voluntário!</h3>
                                <p> Cadastre-se! <br>
                                Ajude a sua comunidade a crescer e se tornar um lugar melhor.<br>
                                Juntos podemos mais!</p>
                                
							</section>
                            <div id="buttons">
							<h3>O que você é?</h3>
	                            <input type="button" value="Pessoa Física" id="button_usuario">
	                            <input type="button" value="Pessoa Jurídica" id="button_empresa">
                            </div>
							
                                <!--Cadastro Empresa-->
							<section class="6u 12u(narrower)" id="empresa" style="display:none;">
                                <h3>Cadastro Empresa</h3>
                                
								<form action="midlet" method="post">
									
                                    <div class="row 50%">
										<div class="6u 12u(mobilep)">	
                                            <input type="text" name="nome" id="name" placeholder="Nome" required="required"/>
										</div>
										
										<div class="2u 3u(mobilep)">
                                            <input type="text" name="ddd" id="ddd" placeholder="ddd" maxlength="2" required="required"/>
										</div>
										
										<div class="4u 12u(mobilep)">								
                                            
                                            <input type="text" name="telefone" id="telefone" placeholder="telefone" maxlength="9" required="required"/>
										</div>
									
                                   		<div class="6u 12u(mobilep)">
											<input type="text" name="cnpj" id="cnpj" placeholder="CNPJ" maxlength="14" required="required"/>
										</div>	
                            
										<div class="6u 12u(mobilep)">
											<input type="text" name="email" id="email" placeholder="Email" maxlength="40" required="required"/> 
                                        </div>
                                        
                                            <div class="6u 12u(mobilep)">
											<input type="text" name="endereco" id="endereco" placeholder="Endereço" maxlength="50" required="required"/>
                                        </div>
                                    
                                        <div class="6u 12u(mobilep)">
											<input type="text" name="senha" id="senha" placeholder="Senha" maxlength="12" required="required"/>
                                        </div>
                                        <input type="hidden" name="form" value="insertEmpresa">
                                        <div class="row 50%">
										<div class="12u">
											<ul class="actions">
                                                <li><input type="submit" class="button alt" value="Cadastrar"/></li>
											</ul>
										</div>
									</div>
                                 </form>
							</section>
                              <!--Cadastro Usuário-->
							<section class="6u 12u(narrower)" id="usuario" style="display:none;">
                                <h3>Cadastro Usuário</h3>
                                
                                <!--Cadastro Usuario-->
								<form action="midlet" method="post">
									
                                    <div class="row 50%">
										<div class="6u 12u(mobilep)">	
                                            <input type="text" name="nome" id="name" placeholder="Nome" required="required" />
										</div>
										
										<div class="2u 3u(mobilep)">
                                            <input type="text" name="ddd" id="ddd" placeholder="ddd" maxlength="2" required="required"/>
										</div>
										
										<div class="4u 12u(mobilep)">								
                                            
                                            <input type="text" name="telefone" id="telefone" placeholder="telefone" maxlength="9" required="required"/>
										</div>
									
                                   		<div class="6u 12u(mobilep)">
											<input type="text" name="cpf" id="cpf" placeholder="CPF" maxlength="14" required="required"/>
										</div>	
                            
										<div class="6u 12u(mobilep)">
											<input type="text" name="email" id="email" placeholder="Email" maxlength="40" required="required"/> 
                                        </div>
                                    
                                        <div class="6u 12u(mobilep)">
											<input type="text" name="senha" id="senha" placeholder="Senha" maxlength="12" required="required"/>
                                        </div>
                                        	<input type="hidden" name="form" value="insertUsuario">
                                        <div class="row 50%">
										<div class="12u">
											<ul class="actions">
                                                <li><input type="submit" class="button alt" value="Cadastrar"/></li>
											</ul>
										</div>
									</div>
                                 </form>
							</section>
							<script type="text/javascript">
								$('#button_empresa').click(function(){
									$('#buttons').hide();
									$('#empresa').show();
								});
								$('#button_usuario').click(function(){
									$('#buttons').hide();
									$('#usuario').show();
								});
							</script>
						</div>
					</div>

					<!-- RodapÃ©-->
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
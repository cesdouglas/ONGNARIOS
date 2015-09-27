<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<%@ include file="cabecalho.jsp" %>
		<div id="page-wrapper">
        
                                                         
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
			</div>

			
		
			<!-- Footer -->
				<div id="footer">
					<div class="container">
						<div class="row">
                            
                            <section class="6u 12u$(narrower) 12u$(mobilep)">
                                <div class="box highlight">
                                      <i class="icon major fa-hand-peace-o"></i>  
							
                                <h3>Seja um voluntário!</h3>
                                <p> Cadastre-se! <br>
                                Ajude a sua comunidade a crescer e se tornar um lugar melhor.<br>
                                Juntos podemos mais!</p>
                               </div>
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
									</div>
                                 </form>
                                 <a href="javascript:;" id="voltar" style="font-size: 12px">Escolher de novo?</a>
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
                                 <a href="javascript:;" id="voltar2" style="font-size: 12px; margin-left: 10px;">Escolher de novo?</a>
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
								$('#voltar').click(function(){
									$('#usuario').hide();
									$('#empresa').hide();
									$('#buttons').show();
								});
								$('#voltar2').click(function(){
									$('#usuario').hide();
									$('#empresa').hide();
									$('#buttons').show();
								});
							</script>
						</div>
					</div>

					<%@ include file="rodape.jsp" %>

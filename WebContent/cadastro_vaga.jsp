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
                                <li><a href="cadastro.jsp">Cadastre-se</a></li>
                                
							</ul>
						</nav>

				</div>
			</div>

			
			<!-- Footer -->
				<div id="footer">
					<div class="container">                            
                            <section class="6u 12u(narrower)">
                            <h3>Cadastrar Vaga</h3>
                            
                            	<form action="midlet" method="post">
           
           
          								 <div class="row 50%">
										<div class="6u 12u(mobilep)">
											<input type="hidden" name="form" value="insertVaga">
	                   			<% String teste = (String)session.getAttribute("cnpj"); 
			 						application.setAttribute("teste", teste); %>
										</div>
           
           								<div class="6u 12u(mobilep)">
	                            		<input type="hidden" name="cnpj" value="${teste}">	                            		
	                            		</div>
	                            		
	                            		<div class="6u 12u(mobilep)">
	                            		<input type="text" name="nome" required="required" maxlength="40" placeholder="Titulo">	                            		
	                            		</div>
			 						
										<div class="6u 12u(mobilep)">
	                            		<input type="text" name="nr_vaga" required="required" maxlength="4" placeholder="N�mero de Vagas">
	                            		</div>	                            	
	                            	
	                            		<div class="6u 12u(mobilep)">
	                            		<input type="text" name="descricao" required="required" maxlength="120" placeholder="Descri��o">
	                            		</div>
	                            	
	                            	<div class="6u 12u(mobilep)">
	                            		<input type="text" name="salario" required="required" maxlength="10" placeholder="Sal�rio">
	                            	</div>
	                            	
	                            	
	                            	<div class="6u 12u(mobilep)">
	                            		<input type="submit" value="Cadastrar Vaga">
                            	</div>
	                            	
	                            	</form>
                            </section>
					</div>
				</div>

					<%@ include file="rodape.jsp" %>

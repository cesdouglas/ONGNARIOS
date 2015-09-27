<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.jsp" %>                 
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
				<% String teste = (String)session.getAttribute("nome"); 
				   String teste2 = String.valueOf(session.getAttribute("ddd")); 
				   String teste3 = String.valueOf(session.getAttribute("telefone")); 
				   String teste4 = (String)session.getAttribute("cnpj"); 
				   String teste5 = (String)session.getAttribute("email"); 
				   String teste6 = (String)session.getAttribute("endereco"); 
				   String teste7 = (String)session.getAttribute("senha"); 
				   application.setAttribute("a", teste); 
				   application.setAttribute("b", teste2); 
				   application.setAttribute("c", teste3); 
				   application.setAttribute("d", teste4); 
				   application.setAttribute("e", teste5); 
				   application.setAttribute("f", teste6); 
				   application.setAttribute("g", teste7); 
				%>
				<% 
				   String teste8 = (String)session.getAttribute("cpf"); 
				   application.setAttribute("h", teste8); 
			 	%>
				<c:if test="${!empty d}">
				
                            <section class="6u 12u(narrower)" id="empresa" style="margin-left: 330px; margin-top: 40px">
								<h3>Editar Empresa</h3>
								<form action="midlet" method="post">
									
                                    <div class="row 50%">
										<div class="6u 12u(mobilep)">	
                                            <input type="text" name="nome" id="name" placeholder="Nome" required="required" value="${a}"/>
										</div>
										
										<div class="2u 3u(mobilep)">
                                            <input type="text" name="ddd" id="ddd" placeholder="ddd" maxlength="2" required="required"/ value="${b}">
										</div>
										
										<div class="4u 12u(mobilep)">								
                                            
                                            <input type="text" name="telefone" id="telefone" placeholder="telefone" maxlength="9" required="required" value="${c}"/>
										</div>
									
											<input type="hidden" name="cnpj" id="cnpj" placeholder="CNPJ" maxlength="14" required="required" value="${d}"/>
                            
										<div class="6u 12u(mobilep)">
											<input type="text" name="email" id="email" placeholder="Email" maxlength="40" required="required" value="${e}"/> 
                                        </div>
                                        
                                            <div class="6u 12u(mobilep)">
											<input type="text" name="endereco" id="endereco" placeholder="Endereço" maxlength="50" required="required" value="${f}"/>
                                        </div>
                                    
                                        <div class="6u 12u(mobilep)">
											<input type="text" name="senha" id="senha" placeholder="Senha" maxlength="12" required="required" value="${g}"/>
                                        </div>
                                        <input type="hidden" name="form" value="atualizarEmpresa">
                                        <div class="row 50%">
										<div class="12u">
											<ul class="actions">
                                                <li><input type="submit" class="button alt" value="Atualizar"/></li>
                                                </form>
                                                <li>
													<form action="midlet" method="post">
														<input type="hidden" name="form" value="apagarEmpresa">		
														<input type="submit" id="apagar" value="Apagar Conta" style="background: red;">							
													</form>
												</li>
											</ul>
										</div>
										</div>
									</div>
							</section>
						</c:if>
						<c:if test="${!empty h}">
                            <section class="6u 12u(narrower)" id="empresa" style="margin-left: 330px; margin-top: 40px">
								<h3>Editar Usuário</h3>
								<form action="midlet" method="post">
									
                                    <div class="row 50%">
										<div class="6u 12u(mobilep)">	
                                            <input type="text" name="nome" id="name" placeholder="Nome" required="required" value="${a}"/>
										</div>
										
										<div class="2u 3u(mobilep)">
                                            <input type="text" name="ddd" id="ddd" placeholder="ddd" maxlength="2" required="required"/ value="${b}">
										</div>
										
										<div class="4u 12u(mobilep)">								
                                            
                                            <input type="text" name="telefone" id="telefone" placeholder="telefone" maxlength="9" required="required" value="${c}"/>
										</div>
									
											<input type="hidden" name="cpf" id="cpf" placeholder="CNPJ" maxlength="14" required="required" value="${h}"/>
                            
										<div class="6u 12u(mobilep)">
											<input type="text" name="email" id="email" placeholder="Email" maxlength="40" required="required" value="${e}"/> 
                                        </div>
                                    
                                        <div class="6u 12u(mobilep)">
											<input type="text" name="senha" id="senha" placeholder="Senha" maxlength="12" required="required" value="${g}"/>
                                        </div>
                                        <input type="hidden" name="form" value="atualizarUsuario">
                                        <div class="row 50%">
										<div class="12u">
											<ul class="actions">
                                                <li><input type="submit" class="button alt" value="Atualizar"/></li>
                                                <li>
                                                </form>
													<form action="midlet" method="post" id="formApagar">
														<input type="hidden" name="form" value="apagarUsuario">		
														<input type="submit" id="apagar" value="Apagar Conta" style="background: red;margin-left: 188px;margin-top: -51px;position: absolute;">							
													</form>
												</li>
											</ul>
										</div>
										</div>
									</div>
							</section>
						</c:if>
						<script type="text/javascript">
// 							$('#apagar').click(function(){
// 								var r = confirm("Você tem certeza que deseja apagar sua conta?");
// 								if (r == true) {
// 								    $('#formApagar').submit();
// 								} else {
// 									$('#formApagar').preventDefault();
// 								}
// 							});
						
						</script>
						

			
<%@ include file="rodape.jsp" %>
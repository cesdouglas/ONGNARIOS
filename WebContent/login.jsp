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
		<li><a href="login.jsp" class="current">Login</a></li>
	</ul>
</nav>
</div>

<section class="wrapper style2">
	<center>
		<div id="buttons">
			<h3>O que você é?</h3>
			<input type="button" value="Pessoa Física" id="button_usuario">
			<input type="button" value="Pessoa Jurídica" id="button_empresa">
		</div>
		<div class="container" id="empresa" style="display: none;">
			<h3>Empresa</h3>
			<form action="midlet" method="post">
				<div class="3u 6u(mobilep)">
					<input type="text" name="cnpj" id="cnpj" placeholder="CNPJ"
						maxlength="14" required="required" />
				</div>
				<div class="3u 6u(mobilep)">
					<input type="password" name="senha" id="senha" placeholder="Senha"
						maxlength="12" required="required" style="margin-top: 10px" />
				</div>
				<input type="hidden" name="form" value="loginEmpresa">
				<div class="row 50%">
					<div class="12u">
						<ul class="actions">
							<li><input type="submit" class="button alt" value="Logar"
								style="margin-top: 10px" /></li>
						</ul>
					</div>
				</div>
			</form>
			<a href="javascript:;" id="voltar" style="font-size: 12px">Escolher
				de novo?</a>
		</div>

		<div class="container" id="usuario" style="display: none;">
			<h3>Usuário</h3>
			<form action="midlet" method="post">
				<div class="3u 6u(mobilep)">
					<input type="text" name="cpf" id="cpf" placeholder="CPF"
						maxlength="14" required="required" />
				</div>
				<div class="3u 6u(mobilep)">
					<input type="password" name="senha" id="senha" placeholder="Senha"
						maxlength="12" required="required" style="margin-top: 10px" />
				</div>
				<input type="hidden" name="form" value="loginUsuario">
				<div class="row 50%">
					<div class="12u">
						<ul class="actions">
							<li><input type="submit" class="button alt" value="Logar"
								style="margin-top: 10px" /></li>
						</ul>
					</div>
				</div>
			</form>
			<a href="javascript:;" id="voltar2" style="font-size: 12px">Escolher
				de novo?</a>
		</div>
	</center>
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





<%@ include file="rodape.jsp"%>
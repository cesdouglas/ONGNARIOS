<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="cabecalho.jsp"%>
<nav id="nav">
	<ul>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="parceiros.jsp">Parceiros</a></li>
		<li class="current"><a href="perfil.jsp">Perfil</a></li>
		<li><a href="vagas.jsp">Vagas</a></li>
		<li><a href="cadastro.jsp">Cadastre-se</a></li>

	</ul>
</nav>

</div>

<c:if test="${!empty empresa.nr_cnpj}">

	<section class="6u 12u(narrower)" id="empresa"
		style="margin-left: 330px; margin-top: 40px">
		<h3>Editar Empresa</h3>
		<form action="midlet" method="post">

			<div class="row 50%">
				<div class="6u 12u(mobilep)">
					<label for="name">Nome:</label>
					<input type="text" name="nome" id="name" placeholder="Nome"
						required="required" value="${empresa.nm_empresa}" />
				</div>

				<div class="2u 3u(mobilep)">
					<label for="ddd">DDD:</label>
					<input type="text" name="ddd" id="ddd" placeholder="ddd"
						maxlength="2" required="required" / value="${empresa.nr_ddd}">
				</div>

				<div class="4u 12u(mobilep)">
					<label for="telefone">Telefone:</label>
					<input type="text" name="telefone" id="telefone"
						placeholder="telefone" maxlength="9" required="required"
						value="${empresa.nr_telefone}" />
				</div>

				<input type="hidden" name="cnpj" id="cnpj" placeholder="CNPJ"
					maxlength="14" required="required" value="${empresa.nr_cnpj}" />

				<div class="6u 12u(mobilep)">
					<label for="email">E-mail:</label>
					<input type="text" name="email" id="email" placeholder="Email"
						maxlength="40" required="required" value="${empresa.ds_email}" />
				</div>

				<div class="6u 12u(mobilep)">
					<label for="endereco">Endere�o:</label>
					<input type="text" name="endereco" id="endereco"
						placeholder="Endere�o" maxlength="50" required="required"
						value="${empresa.ds_endereco}" />
				</div>

				<div class="6u 12u(mobilep)">
					<label for="senha">Senha:</label>
					<input type="text" name="senha" id="senha" placeholder="Senha"
						maxlength="12" required="required" value="${empresa.ds_senha}" />
				</div>
				<input type="hidden" name="form" value="atualizarEmpresa">
				<div class="row 50%">
					<div class="12u">
						<ul class="actions">
							<li><input type="submit" class="button alt"
								value="Atualizar" /></li>
		</form>
		<li>
			<form action="midlet" method="post">
				<input type="hidden" name="form" value="apagarEmpresa"> <input
					type="hidden" name="cnpj" id="cnpj" placeholder="CNPJ"
					maxlength="14" required="required" value="${empresa.nr_cnpj}" /> <input
					type="submit" id="apagar" value="Apagar Conta"
					style="background: red;">
			</form>
		</li>
		</ul>
		</div>
		</div>
		</div>
	</section>
	<center>
		<form action="midlet" method="post">
			<input type="hidden" name="form" value="carregarVagas2"> <input
				type="submit" value="Ver minhas vagas"
				style="background-color: green; position: absolute; margin-top: 0.25em; margin-left: -1em;">
		</form>
	</center>
</c:if>
<c:if test="${!empty usuario.nr_cpf}">
	<section class="6u 12u(narrower)" id="empresa"
		style="margin-left: 330px; margin-top: 40px">
		<h3>Editar Usu�rio</h3>
		<form action="midlet" method="post">

			<div class="row 50%">
				<div class="6u 12u(mobilep)">
					<label for="name">Nome:</label>
					<input type="text" name="nome" id="name" placeholder="Nome"
						required="required" value="${usuario.nm_usuario}" />
				</div>

				<div class="2u 3u(mobilep)">
					<label for="ddd">DDD:</label>
					<input type="text" name="ddd" id="ddd" placeholder="ddd"
						maxlength="2" required="required" / value="${usuario.nr_ddd}">
				</div>

				<div class="4u 12u(mobilep)">
					<label for="telefone">Telefone:</label>
					<input type="text" name="telefone" id="telefone"
						placeholder="telefone" maxlength="9" required="required"
						value="${usuario.nr_telefone}" />
				</div>
				<input type="hidden" name="cpf" id="cpf" placeholder="CPF"
					maxlength="14" required="required" value="${usuario.nr_cpf}" />
				
				<div class="6u 12u(mobilep)">
					<label for="email">E-mail:</label>
					<input type="text" name="email" id="email" placeholder="Email"
						maxlength="40" required="required" value="${usuario.ds_email}" />
				</div>

				<div class="6u 12u(mobilep)">
					<label for="senha">Senha:</label>
					<input type="text" name="senha" id="senha" placeholder="Senha"
						maxlength="12" required="required" value="${usuario.ds_senha}" />
				</div>
				<input type="hidden" name="form" value="atualizarUsuario">
				<div class="row 50%">
					<div class="12u">
						<ul class="actions">
							<li><input type="submit" class="button alt"
								value="Atualizar" /></li>
							<li>
		</form>
		<form action="midlet" method="post" id="formApagar">
			<input type="hidden" name="form" value="apagarUsuario"> <input
				type="hidden" name="cpf" id="cpf" placeholder="CPF" maxlength="14"
				required="required" value="${usuario.nr_cpf}" /> <input
				type="submit" id="apagar" value="Apagar Conta"
				style="background: red; margin-left: 1em; margin-top: 1em; position: absolute;">
		</form>
		</li>
		</ul>
		</div>
		</div>
		</div>
	</section>
</c:if>


<c:forEach var="n" items="${vagas}">
	<c:if test="${!empty n && n.t_ONG_EMPRESA_nr_cnpj == empresa.nr_cnpj}">
		<section class="6u 12u(narrower)" id="empresa"
			style="margin-left: 330px; margin-top: 40px">
			<h3>Editar ${n.nm_vaga}</h3>
			<form action="midlet" method="post">

				<div class="row 50%">
					<div class="6u 12u(mobilep)">
						<label for="nameVaga">Nome:</label>
						<input type="text" name="nome" id="nameVaga" placeholder="Nome"
							maxlength="40" required="required" value="${n.nm_vaga}" />
					</div>


					<div class="4u 20u(mobilep)">
						<label for="descricao">Descri��o:</label>
						<input type="text" name="descricao" id="descricao"
							placeholder="Descri��o" maxlength="120" required="required"
							value="${n.ds_vaga}">
					</div>

					<div class="6u 12u(mobilep)">
						<label for="salario">Sal�rio:</label>
						<input type="text" name="salario" id="salario"
							placeholder="S�l�rio" maxlength="10" required="required"
							value="${n.vl_salario}" />
					</div>

					<input type="hidden" name="cd_vaga" value="${n.cd_vaga}"> <input
						type="hidden" name="form" value="atualizarVaga">
					<div class="row 50%">
						<div class="12u">
							<ul class="actions">
								<li><input type="submit" class="button alt"
									value="Atualizar" /></li>
								<li>
			</form>
			<form action="midlet" method="post" id="formApagar">
				<input type="hidden" name="form" value="apagarVaga"> <input
					type="hidden" name="id" value="${n.cd_vaga}"> <input
					type="submit" id="apagar" value="Apagar Vaga"
					style="background: red; margin-left: 10em; margin-top: -2.7em; position: absolute;">
			</form>
			</li>
			</ul>
			</div>
			</div>
			</div>
		</section>
	</c:if>
</c:forEach>

<c:if test="${empty empresa.nr_cnpj && empty usuario.nr_cpf}">
	<center>
		<h3 style="margin-top: 70px;">Realize o login para ver o perfil</h3>
	</center>
</c:if>

<script type="text/javascript">
	// 							$('#apagar').click(function(){
	// 								var r = confirm("Voc� tem certeza que deseja apagar sua conta?");
	// 								if (r == true) {
	// 								    $('#formApagar').submit();
	// 								} else {
	// 									$('#formApagar').preventDefault();
	// 								}
	// 							});
</script>



<%@ include file="rodape.jsp"%>
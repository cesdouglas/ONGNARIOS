package br.com.fiap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.bo.EmpresaBO;
import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.bo.VagaBO;
import br.com.fiap.excecoes.Excecao;

/**
 * Servlet implementation class ONGNARIOS
 */
//@WebServlet("/ONGNARIOS")
public class ONGNARIOS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ONGNARIOS() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Login Usuario
	protected void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		//Recupera a sessão do usuário ou cria uma nova se não existe
		String login = request.getParameter("cpf");
		String senha = request.getParameter("senha"); 
		UsuarioBO bo = new UsuarioBO();
		if(bo.entrar(login, senha)){
			HttpSession session = request.getSession();
			
			//Adiciona o usuário na sessão
			session.setAttribute("usuario", bo.buscar(login));
			session.setAttribute("logado", "sim");
			request.setAttribute("msg", "Logado com sucesso!");
			request.getRequestDispatcher("vagas.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "CPF ou Senha errada!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	//Login Empresa
	protected void loginEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		//Recupera a sessão da empresa ou cria uma nova se não existe
		String login = request.getParameter("cnpj");
		String senha = request.getParameter("senha"); 
		EmpresaBO bo = new EmpresaBO();
		if(bo.entrar(login, senha)){
			HttpSession session = request.getSession();
			
			//Adiciona os atributos da empresa na sessão
			session.setAttribute("empresa", bo.buscar(login));
			session.setAttribute("logado", "sim");
			request.setAttribute("msg", "Logado com sucesso!");
			request.getRequestDispatcher("vagas.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "CNPJ ou Senha errada!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	//Logout, usado tanto para Empresa quanto Usuário
	protected void logoutAmbos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		HttpSession session = request.getSession();
		//Destruir sessão
		session.invalidate();
		request.setAttribute("msg", "Logout com sucesso!");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	//Valida o login de ambos
	protected boolean validaLogin(HttpServletRequest request) throws ServletException, IOException, Exception {
		HttpSession session = request.getSession();
		//Verifica se esta logado
		String logado = (String)session.getAttribute("logado");
		if (logado.equals("sim")){
			return true;
		}else{
			return false;
		}
	}
	
	//Carregar vagas vagas.jsp
	protected void carregarVagas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try{
			VagaBO bo = new VagaBO();		
			request.setAttribute("vagas", bo.carregarTodas());
			request.getRequestDispatcher("vagas.jsp").forward(request, response);
		}catch(Exception e){
			throw new Excecao(e);
		}
	}
	
	//Carregar vagas perfil.jsp
	protected void carregarVagas2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try{
			VagaBO bo = new VagaBO();		
			request.setAttribute("vagas", bo.carregarTodas());
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
		}catch(Exception e){
			throw new Excecao(e);
		}
	}
	
	
	
	//Buscar Vaga
	protected void procurarVaga(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try{
			VagaBO bo = new VagaBO();
			String nome = request.getParameter("search");
			request.setAttribute("vagas", bo.buscar(nome));
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
		}catch(Exception e){
			throw new Excecao(e);
		}
	}
	
	
	//Insere Vaga
	protected void inserirVaga(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		VagaBO bo = new VagaBO();
		try{
			//Setando vagas no beans
			if (bo.inserir(request.getParameter("nome"), request.getParameter("descricao"), request.getParameter("salario"),
					request.getParameter("cnpj"))){
				request.setAttribute("msg", "Vaga cadastrada com sucesso!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "Ocorreu um erro no cadastro!");
				request.getRequestDispatcher("erro.jsp").forward(request, response);
			}
	
		}catch(Exception e){
			throw new Excecao(e);
		}
	}

	//Insert Empresa
	protected void inserirEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		EmpresaBO ebo = new EmpresaBO();
		try{
			//Inserir Empresa e verifica se foi inserido ou não
			if(ebo.inserir(request.getParameter("cnpj"), request.getParameter("nome"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("telefone")),
					Integer.parseInt(request.getParameter("ddd")), request.getParameter("email"), request.getParameter("senha")) == true){
				request.setAttribute("msg", "Empresa cadastrada com sucesso!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			//Se não vai para pag de erro
			}else{
				request.setAttribute("msg", "Ocorreu um erro no cadastro!");
				request.getRequestDispatcher("erro.jsp").forward(request, response);
			}
		}catch(Exception e){
			throw new Excecao(e);
		}
	}

	//Insert Usuario
	protected void inserirUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		UsuarioBO ubo = new UsuarioBO();
		try{
			//Verificar se inseriu ou nao
			if(ubo.inserir(request.getParameter("cpf"), request.getParameter("nome"), Integer.parseInt(request.getParameter("telefone")),
					Integer.parseInt(request.getParameter("ddd")), request.getParameter("email"), request.getParameter("senha"))){
				request.setAttribute("msg", "Usuário cadastrado com sucesso!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "Ocorreu um erro no cadastro!");
				request.getRequestDispatcher("erro.jsp").forward(request,response);
			}
		}catch(Exception e){
			throw new Excecao(e);
		}
	}


	//Atualizar dados Usuario
	protected void atualizarUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		UsuarioBO bo = new UsuarioBO();
		try{
			if(bo.atualizar(request.getParameter("cpf"), request.getParameter("nome"), Integer.parseInt(request.getParameter("telefone")),
					Integer.parseInt(request.getParameter("ddd")), request.getParameter("email"), request.getParameter("senha")) > 0){
				
				HttpSession session = request.getSession();
				
				//Atualizar o usuário na sessão
				session.setAttribute("usuario", bo.buscar(request.getParameter("cpf")));
				request.setAttribute("msg", "Dados atualizados com sucesso");
				request.getRequestDispatcher("index.jsp").forward(request, response);			
			}else{
				request.setAttribute("msg", "Ocorreu algum erro, verifique os campos");
				request.getRequestDispatcher("perfil.jsp").forward(request, response);	
			}
		}catch(Exception e){
			throw new Excecao(e);
		}
	}
	
	//Atualizar dados Empresa
	protected void atualizarEmpresa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		EmpresaBO bo = new EmpresaBO();
		try{
			if (bo.atualizar(request.getParameter("cnpj"), request.getParameter("nome"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("telefone")),
					Integer.parseInt(request.getParameter("ddd")), request.getParameter("email"), request.getParameter("senha"))>0){
				HttpSession session = request.getSession();
				
				//Atualiza os atributos da empresa na sessão
				session.setAttribute("empresa", bo.buscar(request.getParameter("cnpj")));
				request.setAttribute("msg", "Dados atualizados com sucesso");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "Ocorreu algum erro, verifique os campos");
				request.getRequestDispatcher("perfil.jsp").forward(request, response);	
			}							
			
		}catch(Exception e){
			throw new Excecao(e);
		}
	}
	
	//Editar Vaga
	protected void atualizarVaga (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		VagaBO bo = new VagaBO();
		try{
			HttpSession session = request.getSession();
			if(bo.atualizar(request.getParameter("nome"), request.getParameter("descricao"), request.getParameter("salario"),
					(String)session.getAttribute("cnpj"), Integer.parseInt(request.getParameter("cd_vaga")))>0){
				request.setAttribute("msg", "Dados atualizados com sucesso");
				request.getRequestDispatcher("index.jsp").forward(request, response);				
			}else{
				request.setAttribute("msg", "Ocorreu algum erro, verifique os campos");
				request.getRequestDispatcher("perfil.jsp").forward(request, response);	
			}
		}catch(Exception e){
			throw new Excecao(e);
		}
	}
	
	
	//Apagar Vaga
	protected void apagarVaga (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		VagaBO bo = new VagaBO();
		try{
			//Recupera id
			int id = Integer.parseInt(request.getParameter("id"));
			//Verifica se apagou ou nao
			if(bo.deletar(id)>0){
				request.setAttribute("msg", "Vaga apagada com sucesso");
				request.getRequestDispatcher("perfil.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "Ocorreu algum erro desconhecido");
				request.getRequestDispatcher("perfil.jsp").forward(request, response);	
			}
		}catch(Exception e){
			throw new Excecao(e);
		}
	}
	
	
	//Apagar dados Empresa
	protected void apagarEmpresa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		EmpresaBO bo = new EmpresaBO();
		try{
			//Recupera CNPJ da session e verifica se apagou ou nao
			if(bo.deletar(request.getParameter("cnpj"))>0){
				request.setAttribute("msg", "Dados apagados com sucesso");
				logoutAmbos(request,response);
			}
		}catch(Exception e){
			request.setAttribute("msg", "Apague suas vagas cadastradas e tente novamente");
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
			throw new Excecao(e);
		}
	}
	
	//Inscrever na Vaga
	protected void inscreverVaga (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try{
			//Recupera CPF da sessao e insere na Vaga
			VagaBO bo = new VagaBO();
			String cpf = request.getParameter("cpf");
			int id = Integer.parseInt(request.getParameter("id"));
			bo.insereCPF(cpf, id);
			request.getRequestDispatcher("vagas.jsp").forward(request, response);
		}catch(Exception e){
			throw new Excecao(e);
		}
		
	}
	
	//Desinscrever na Vaga
	protected void desinscreverVaga (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try{
			//Insere null na Vaga
			VagaBO bo = new VagaBO();
			String cpf = null;
			int id = Integer.parseInt(request.getParameter("id"));
			bo.insereCPF(cpf, id);
			request.getRequestDispatcher("vagas.jsp").forward(request, response);
		}catch(Exception e){
			throw new Excecao(e);
		}
		
	}
	
	//Apagar Usuario
	protected void apagarUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		UsuarioBO bo = new UsuarioBO();
		try{
			//Recupera cpf da session e verifica se apagou o usuario
			if(bo.deletar(request.getParameter("cpf"))>0){
				request.setAttribute("msg2", "Dados apagados com sucesso");
				logoutAmbos(request,response);
			}else{
				request.setAttribute("msg", "Ocorreu algum erro desconhecido");
				request.getRequestDispatcher("perfil.jsp").forward(request, response);	
			}
		}catch(Exception e){
			throw new Excecao(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//Metodos GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			//verifica o value do name=form e executa a funcao desejada
			if(request.getParameter("form").equals("buscarVaga")){
				procurarVaga(request,response);
			}
		}catch(Exception e){
			response.sendRedirect("resultado.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//Metodos Post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			//verifica o value do name=form e executa a funcao desejada
			if (request.getParameter("form").equals("insertEmpresa")){
				inserirEmpresa(request,response);
			}else if (request.getParameter("form").equals("insertUsuario")){
				inserirUsuario(request, response);
			}else if (request.getParameter("form").equals("insertVaga")){
				inserirVaga(request, response);
			}else if (request.getParameter("form").equals("loginUsuario")){
				loginUsuario(request,response);
			}else if (request.getParameter("form").equals("loginEmpresa")){
				loginEmpresa(request,response);
			}else if(request.getParameter("form").equals("logout")){
				logoutAmbos(request,response);
			}else if(request.getParameter("form").equals("atualizarUsuario")){
				atualizarUsuario(request,response);
			}else if(request.getParameter("form").equals("atualizarEmpresa")){
				atualizarEmpresa(request,response);
			}else if(request.getParameter("form").equals("apagarEmpresa")){
				apagarEmpresa(request,response);
			}else if(request.getParameter("form").equals("apagarUsuario")){
				apagarUsuario(request,response);
			}else if(request.getParameter("form").equals("carregarVagas")){
				carregarVagas(request,response);
			}else if(request.getParameter("form").equals("inscrever")){
				inscreverVaga(request,response);
			}else if(request.getParameter("form").equals("desinscrever")){
				desinscreverVaga(request,response);
			}else if(request.getParameter("form").equals("buscarVaga")){
				procurarVaga(request,response);
			}else if(request.getParameter("form").equals("apagarVaga")){
				apagarVaga(request,response);
			}else if(request.getParameter("form").equals("atualizarVaga")){
				atualizarVaga(request,response);
			}else if(request.getParameter("form").equals("carregarVagas2")){
				carregarVagas2(request,response);
			}
		}catch(Exception e){
			response.sendRedirect("erro.jsp");
		}
	}

}

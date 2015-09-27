package br.com.fiap.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.beans.EmpresaBean;
import br.com.fiap.beans.UsuarioBean;
import br.com.fiap.beans.VagaBean;
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
			
			//Setando usuario no beans
			UsuarioBean u = bo.buscar(login);
			
			//Adiciona o usuário na sessão
			session.setAttribute("cpf", u.getNr_cpf());
			session.setAttribute("nome", u.getNm_usuario());
			session.setAttribute("telefone", u.getNr_telefone());
			session.setAttribute("ddd", u.getNr_ddd());
			session.setAttribute("email", u.getDs_email());
			session.setAttribute("senha", u.getDs_senha());
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
			
			//Setando empresa no bens
			EmpresaBean e = bo.buscar(login);
			
			//Adiciona o atributo usuário na sessão
			session.setAttribute("cnpj", e.getNr_cnpj());
			session.setAttribute("nome", e.getNm_empresa());
			session.setAttribute("endereco", e.getDs_endereco());
			session.setAttribute("telefone", e.getNr_telefone());
			session.setAttribute("ddd", e.getNr_ddd());
			session.setAttribute("email", e.getDs_email());
			session.setAttribute("senha", e.getDs_senha());
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
		session.invalidate();
		request.setAttribute("msg", "Logout com sucesso!");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	//Valida o login de ambos
	protected boolean validaLogin(HttpServletRequest request) throws ServletException, IOException, Exception {
		HttpSession session = request.getSession();
		String logado = (String)session.getAttribute("logado");
		if (logado.equals("sim")){
			return true;
		}else{
			return false;
		}
	}
	
	//Carregar vagas
	protected void carregarVagas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try{
			VagaBO bo = new VagaBO();		
			request.setAttribute("vagas", bo.carregarTodas());
			request.getRequestDispatcher("vagas.jsp").forward(request, response);
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
			VagaBean v = new VagaBean();
			v.setNm_vaga(request.getParameter("nome"));
			v.setNr_vaga(Integer.parseInt(request.getParameter("nr_vaga")));
			v.setDs_vaga(request.getParameter("descricao"));
			v.setVl_salario(Double.parseDouble(request.getParameter("salario")));
			HttpSession session = request.getSession();
			v.setT_ONG_EMPRESA_nr_cnpj((String)session.getAttribute("cnpj"));
			if(bo.inserir(v) == true){
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
			if(ebo.inserir(request.getParameter("cnpj"), request.getParameter("nome"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("telefone")),
					Integer.parseInt(request.getParameter("ddd")), request.getParameter("email"), request.getParameter("senha")) == true){
				request.setAttribute("msg", "Empresa cadastrada com sucesso!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
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
			UsuarioBean u = new UsuarioBean();
			u.setNr_cpf(request.getParameter("cpf"));
			u.setNm_usuario(request.getParameter("nome"));
			u.setNr_telefone(Integer.parseInt(request.getParameter("telefone")));			
			u.setNr_ddd(Integer.parseInt(request.getParameter("ddd")));
			u.setDs_email(request.getParameter("email")); 
			u.setDs_senha(request.getParameter("senha"));			
			if(bo.atualizar(u)>0){
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
			EmpresaBean u = new EmpresaBean();
			u.setNr_cnpj(request.getParameter("cnpj"));
			u.setNm_empresa(request.getParameter("nome"));
			u.setNr_telefone(Integer.parseInt(request.getParameter("telefone")));			
			u.setNr_ddd(Integer.parseInt(request.getParameter("ddd")));
			u.setDs_endereco(request.getParameter("endereco"));
			u.setDs_email(request.getParameter("email")); 
			u.setDs_senha(request.getParameter("senha"));			
			if(bo.atualizar(u)>0){
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
	
	//Apagar dados Empresa
	protected void apagarEmpresa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		EmpresaBO bo = new EmpresaBO();
		try{
			HttpSession session = request.getSession();
			System.out.println("teste");
			if(bo.deletar((String)session.getAttribute("cnpj"))>0){
				request.setAttribute("msg", "Dados apagados com sucesso");
				logoutAmbos(request,response);
			}else{
				request.setAttribute("msg", "Ocorreu algum erro desconhecido");
				request.getRequestDispatcher("perfil.jsp").forward(request, response);	
			}
		}catch(Exception e){
			throw new Excecao(e);
		}
	}
	
	//Inscrever na Vaga
	protected void inscreverVaga (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try{
			VagaBO bo = new VagaBO();
			HttpSession session = request.getSession();
			String cpf = (String)session.getAttribute("cpf");
			bo.insereCPF(cpf);
			request.getRequestDispatcher("vagas.jsp").forward(request, response);
		}catch(Exception e){
			throw new Excecao(e);
		}
		
	}
	
	//Desinscrever na Vaga
	protected void desinscreverVaga (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		try{
			VagaBO bo = new VagaBO();
			String cpf = null;
			bo.insereCPF(cpf);
			request.getRequestDispatcher("vagas.jsp").forward(request, response);
		}catch(Exception e){
			throw new Excecao(e);
		}
		
	}
	
	//Apagar Usuario
	protected void apagarUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		UsuarioBO bo = new UsuarioBO();
		try{
			HttpSession session = request.getSession();
			if(bo.deletar((String)session.getAttribute("cpf"))>0){
				request.setAttribute("msg", "Dados apagados com sucesso");
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
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
			}
		}catch(Exception e){
			response.sendRedirect("erro.jsp");
		}
	}

}

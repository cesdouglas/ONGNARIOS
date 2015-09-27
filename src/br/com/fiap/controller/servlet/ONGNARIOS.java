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
import br.com.fiap.bo.EmpresaBO;
import br.com.fiap.bo.UsuarioBO;
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

	protected void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		//Recupera a sessão do usuário ou cria uma nova se não existe
		String login = request.getParameter("cpf");
		String senha = request.getParameter("senha"); 
		UsuarioBO bo = new UsuarioBO();
		if(bo.entrar(login, senha)){
			HttpSession session = request.getSession();
			//Instancia o UsuarioBean
			UsuarioBean u = new UsuarioBean();
			//Setando dados no bean
			u.setNr_cpf(request.getParameter("cpf"));
			u.setNm_usuario(request.getParameter("nome"));
			u.setNr_telefone(Integer.parseInt(request.getParameter("telefone")));
			u.setNr_ddd(Integer.parseInt(request.getParameter("ddd")));
			u.setDs_email(request.getParameter("email"));
			u.setDs_senha(request.getParameter("senha"));
			
			//Adiciona o atributo usuário na sessão
			session.setAttribute("cpf", u.getNr_cpf());
			session.setAttribute("nome", u.getNm_usuario());
			session.setAttribute("telefone", u.getNr_telefone());
			session.setAttribute("ddd", u.getNr_ddd());
			session.setAttribute("email", u.getDs_email());
			session.setAttribute("senha", u.getDs_senha());
			session.setAttribute("logado", "sim");
			request.setAttribute("msg", "Logado com sucesso!");
			request.getRequestDispatcher("vaga.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "CPF ou Senha errada!");
			request.getRequestDispatcher("testeLogin.jsp").forward(request, response);
		}
	}
	
	
	protected void loginEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		//Recupera a sessão da empresa ou cria uma nova se não existe
		String login = request.getParameter("cnpj");
		String senha = request.getParameter("senha"); 
		EmpresaBO ebo = new EmpresaBO();
		if(ebo.entrar(login, senha)){
			HttpSession session = request.getSession();
			//Instancia o EmpresaBean
			EmpresaBean e = new EmpresaBean();
			
			//Setando dados no bean
			e.setNr_cnpj(request.getParameter("cpf"));
			e.setNm_empresa(request.getParameter("nome"));
			e.setDs_endereco(request.getParameter("endereco"));
			e.setNr_telefone(Integer.parseInt(request.getParameter("telefone")));
			e.setNr_ddd(Integer.parseInt(request.getParameter("ddd")));
			e.setDs_email(request.getParameter("email"));
			e.setDs_senha(request.getParameter("senha"));
			
			//Adiciona o atributo usuário na sessão
			session.setAttribute("cpf", e.getNr_cnpj());
			session.setAttribute("nome", e.getNm_empresa());
			session.setAttribute("endereco", e.getDs_endereco());
			session.setAttribute("telefone", e.getNr_telefone());
			session.setAttribute("ddd", e.getNr_ddd());
			session.setAttribute("email", e.getDs_email());
			session.setAttribute("senha", e.getDs_senha());
			session.setAttribute("logado", "sim");
			request.setAttribute("msg", "Logado com sucesso!");
			request.getRequestDispatcher("vaga.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "CNPJ ou Senha errada!");
			request.getRequestDispatcher("testeLogin.jsp").forward(request, response);
		}
	}
	
	//Logout, usado tanto para Empresa quanto Usuário
	protected void logoutAmbos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		HttpSession session = request.getSession();
		session.invalidate();
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

	//Insert Empresa
	protected void inserirEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		EmpresaBO ebo = new EmpresaBO();
		try{
			if(ebo.inserir(request.getParameter("cnpj"), request.getParameter("nome"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("telefone")),
					Integer.parseInt(request.getParameter("ddd")), request.getParameter("email"), request.getParameter("senha")) == true){
				request.setAttribute("msg", "Empresa cadastrada com sucesso!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				System.out.println("Erro no inserirEmpresa");
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



//	protected int atualizarUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
//		UsuarioBO ubo = new UsuarioBO();
//		try{
//			if(ubo.atualizar((request.getParameter("cpf"), request.getParameter("nome"), Integer.parseInt(request.getParameter("telefone")),
//					Integer.parseInt(request.getParameter("ddd")), request.getParameter("email"), request.getParameter("senha")));))
//
//			request.setAttribute("msg", "Dados atualizados com sucesso");
//			request.getRequestDispatcher("testeUpdateUsuario.jsp").forward(request, response);
//		}
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


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
			}
			else if (request.getParameter("form").equals("login")){
				loginUsuario(request,response);
			}
		}catch(Exception e){
			response.sendRedirect("erro.jsp");
		}
	}

}

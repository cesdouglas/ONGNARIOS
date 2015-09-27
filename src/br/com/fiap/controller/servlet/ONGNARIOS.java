package br.com.fiap.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	protected void processarLoginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		//Recupera a sessão do usuário ou cria uma nova se não existe
		String login = request.getParameter("nr_cpf");
		String senha = request.getParameter("ds_senha"); 
		UsuarioBO bo = new UsuarioBO();
		if(bo.entrar(login, senha)){
			UsuarioBean e = new UsuarioBean();
			HttpSession session = request.getSession();
			//Adiciona o atributo usuário na sessão
			session.setAttribute("nr_cpf", e.getNr_cpf());
			session.setAttribute("nm_usuario", e.getNm_usuario());
			session.setAttribute("nr_telefone", e.getNr_telefone());
			session.setAttribute("nr_ddd", e.getNr_ddd());
			session.setAttribute("ds_email", e.getDs_email());
			session.setAttribute("ds_senha", e.getDs_senha());
			session.setAttribute("logado", "true");
			request.setAttribute("msg", "Logado com sucesso!");
			request.getRequestDispatcher("testeUpdateUsuario.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "CPF ou Senha errada!");
			request.getRequestDispatcher("testeLogin.jsp").forward(request, response);
		}
	}

	//Insert Empresa
	protected void inserirEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		EmpresaBO ebo = new EmpresaBO();
		try{

			if(ebo.inserir(Integer.parseInt(request.getParameter("id")),request.getParameter("cnpj"), request.getParameter("nome"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("telefone")),
					Integer.parseInt(request.getParameter("ddd")), request.getParameter("email"), request.getParameter("senha"))){

				request.setAttribute("msg", "Empresa cadastrada com sucesso!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "Ocorreu um erro no cadastro!");
				request.getRequestDispatcher("erro.jsp");
			}
		}catch(Exception e){
			throw new Excecao(e);
		}
	}

	//Insert Usuario
	protected void inserirUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		UsuarioBO ubo = new UsuarioBO();
		try{
			if(ubo.inserir(Integer.parseInt(request.getParameter("id")),request.getParameter("cpf"), request.getParameter("nome"), Integer.parseInt(request.getParameter("telefone")),
					Integer.parseInt(request.getParameter("ddd")), request.getParameter("email"), request.getParameter("senha"))){

				request.setAttribute("msg", "Usuário cadastrado com sucesso!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "Ocorreu um erro no cadastro!");
				request.getRequestDispatcher("erro.jsp");
			}
		}catch(Exception e){
			throw new Excecao(e);
		}
	}

	//    protected int atualizarUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
	//    	
	//    	
	//    	request.setAttribute("msg", "Dados atualizados com sucesso");
	//    	request.getRequestDispatcher("testeUpdateUsuario.jsp").forward(request, response);
	//    }

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
			if (request.getParameter("id")=="1"){
				inserirEmpresa(request,response);
			}else if (request.getParameter("id")=="2"){
				inserirUsuario(request, response);
			}
			processarLoginUsuario(request,response);
		}catch(Exception e){
			System.out.println(e);
		}
	}

}

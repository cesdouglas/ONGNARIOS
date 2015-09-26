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
    	//Recupera a sessão do usuário ou cria uma nova se não
    	// existe
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
    		request.getRequestDispatcher("testeLogin.jsp").forward(request, response);
    	}else{
    		request.setAttribute("msg", "CPF ou Senha errada!");
    		request.getRequestDispatcher("testeLogin.jsp").forward(request, response);
    	}
    }

    //Insert Empresa
    protected void inserirEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
    	EmpresaBean e = new EmpresaBean();
    	e.setNr_cnpj(request.getParameter("cnpj"));
    	e.setNm_empresa(request.getParameter("nome"));
    	e.setDs_endereco(request.getParameter("endereco"));
    	e.setNr_telefone(Integer.parseInt(request.getParameter("telefone")));
    	e.setNr_ddd(Integer.parseInt(request.getParameter("ddd")));
    	e.setDs_email(request.getParameter("email"));
    	e.setDs_senha(request.getParameter("senha"));    	
    	System.out.println("servlet");
    	new EmpresaBO().inserir(e);
    	request.setAttribute("msg", "Cliente cadastrado com sucesso!!!");
    	request.getRequestDispatcher("testeInsertEmpresa.jsp").forward(request, response);
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			inserirEmpresa(request,response);			
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			processarLoginUsuario(request,response);			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}

package br.com.fiap.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.beans.EmpresaBean;
import br.com.fiap.bo.EmpresaBO;

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
    
//    protected void processarLoginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
//    	//Recupera a sess�o do usu�rio ou cria uma nova se n�o
//    	// existe
//    	String login = request.getParameter("login");
//    	String senha = request.getParameter("senha");    	
//    	HttpSession session = request.getSession();
//    	//Adiciona o atributo usu�rio na sess�o
//    	session.setAttribute("cpf", "Thiago");
//    	session.setAttribute("nome", "Thiago");
//    	//Recupera o atributo usuario da sess�o
//    	String usuario = (String) session.getAttribute("usuario");
//    }

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
	}

}

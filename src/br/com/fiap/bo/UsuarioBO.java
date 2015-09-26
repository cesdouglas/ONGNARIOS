package br.com.fiap.bo;

import br.com.fiap.beans.UsuarioBean;
import br.com.fiap.dao.UsuarioDAO;


public class UsuarioBO {
	private UsuarioDAO dao;
	
	public UsuarioBO() throws Exception{
		dao = new UsuarioDAO();
	}
	
	public void inserir(UsuarioBean e) throws Exception{
		dao.insert(e);
	}
	
	public UsuarioBean buscar(String cpf) throws Exception{
		return dao.search(cpf);
	}
	
	public int atualizar(UsuarioBean e) throws Exception{
		return dao.update(e);
	}
	
	public int deletar(String cpf) throws Exception{
		return dao.delete(cpf);
	}
	
	public boolean entrar(String cpf, String senha) throws Exception{
		try{
			dao.login(cpf,senha);
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
}

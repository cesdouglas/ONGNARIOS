package br.com.fiap.bo;


import br.com.fiap.beans.UsuarioBean;
import br.com.fiap.dao.UsuarioDAO;

//Classe BO que abrange as regras de negocio
public class UsuarioBO {
	private UsuarioDAO dao;
	
	public UsuarioBO() throws Exception{
		dao = new UsuarioDAO();
	}
	
	//Verifica se inseriu o Usuario
	public boolean inserir(String cpf, String nome, int telefone, int ddd, String email, String senha) throws Exception{
		try{
			UsuarioBean u = new UsuarioBean(cpf, nome, telefone, ddd, email, senha);
			dao.insert(u);
			return true;
		}catch(Exception f){
			System.out.println(f);
			return false;
		}
	}
	
	public UsuarioBean buscar(String cpf) throws Exception{
		return dao.search(cpf);
	}
	
	public int atualizar(String cpf, String nome, int telefone, int ddd, String email, String senha) throws Exception{
		UsuarioBean u = new UsuarioBean(cpf, nome, telefone, ddd, email, senha);
		return dao.update(u);
	}
	
	public int deletar(String cpf) throws Exception{
		return dao.delete(cpf);
	}
	
	//Confere se os dados sao iguais ao do banco
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

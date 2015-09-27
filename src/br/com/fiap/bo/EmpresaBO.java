package br.com.fiap.bo;

import br.com.fiap.beans.EmpresaBean;
import br.com.fiap.dao.EmpresaDAO;

public class EmpresaBO {
	private EmpresaDAO dao;
	
	public EmpresaBO() throws Exception{
		dao = new EmpresaDAO();
	}
	
	public boolean inserir(int id, String cnpj, String nome, String endereco, int telefone, int ddd, String email, String senha) throws Exception{
		EmpresaBean e = new EmpresaBean(cnpj, nome, endereco, telefone, ddd, email, senha);
		if(dao.insert(e)){
			return true;
		}else{
			return false;
		}
	}
	
	public EmpresaBean buscar(String cnpj) throws Exception{
		return dao.search(cnpj);
	}
	
	public int atualizar(EmpresaBean e) throws Exception{
		return dao.update(e);
	}
	
	public int deletar(String cnpj) throws Exception{
		return dao.delete(cnpj);
	}
}

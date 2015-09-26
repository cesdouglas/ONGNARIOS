package br.com.fiap.bo;

import br.com.fiap.beans.EmpresaBean;
import br.com.fiap.dao.EmpresaDAO;

public class EmpresaBO {
	private EmpresaDAO dao;
	
	public EmpresaBO() throws Exception{
		dao = new EmpresaDAO();
	}
	
	public void inserir(EmpresaBean e) throws Exception{
		dao.insert(e);
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

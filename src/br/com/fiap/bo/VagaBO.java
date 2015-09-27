package br.com.fiap.bo;

import br.com.fiap.beans.VagaBean;
import br.com.fiap.dao.VagaDAO;

public class VagaBO {
	private VagaDAO dao;
	
	public VagaBO() throws Exception{
		dao = new VagaDAO();
	}
	
	public boolean inserir(VagaBean e) throws Exception{
		try{
		dao.insert(e);
		return true;
		}catch (Exception f) {
			return false;
		}
	}
	
	public VagaBean buscar(String cd_vaga) throws Exception{
		return dao.search(cd_vaga);
	}
	
	public int atualizar(VagaBean e) throws Exception{
		return dao.update(e);
	}
	
	public int deletar(String cd_vaga) throws Exception{
		return dao.delete(cd_vaga);
	}
}
